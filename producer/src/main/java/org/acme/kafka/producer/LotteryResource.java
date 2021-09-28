package org.acme.kafka.producer;

//import com.amazonaws.services.sqs.AmazonSQS;
//import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
//import com.amazonaws.services.sqs.model.CreateQueueResult;
//import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.acme.kafka.model.Lottery;
import org.jboss.logging.Logger;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/lottery")
public class LotteryResource {

    private static final Logger LOGGER = Logger.getLogger(LotteryResource.class);

    @Inject
    SqsClient sqs;

//    String queueUrl = sqs.getQueueUrl(QUEUE_NAME).get
//    @Inject
//    AmazonSQS amazonSQS = AmazonSQSClientBuilder.defaultClient();

    static final String QUEUE_NAME = "sqs-queue";
    static final String QUEUE_URL = "https://sqs.ap-northeast-2.amazonaws.com/UNIQUE-NUM/sqs-queue";
    static ObjectWriter WRITER = new ObjectMapper().writerFor(Lottery.class);
    static ObjectReader READER = new ObjectMapper().readerFor(Lottery.class);

    @GET
    public void test() {
        System.out.println("test get");
    }

    @POST
    @Path("/shoot")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sendMessage(Lottery lottery) throws Exception {
        // 아마존 awssdk 예제 -> https://github.com/awsdocs/aws-doc-sdk-examples/blob/master/java/example_code/sqs/src/main/java/aws/example/sqs/SendReceiveMessages.java
        CreateQueueRequest createQueueRequest = CreateQueueRequest.builder()
                .queueName(QUEUE_NAME)
                .build();

        sqs.createQueue(createQueueRequest);
        System.out.println("Get queue url");
        GetQueueUrlResponse getQueueUrlResponse =
                sqs.getQueueUrl(GetQueueUrlRequest.builder().queueName(QUEUE_NAME).build());
        String queueUrl = getQueueUrlResponse.queueUrl();



        String message = WRITER.writeValueAsString(lottery);
        SendMessageResponse response = sqs.sendMessage(m -> m.queueUrl(QUEUE_URL).messageBody(message));
        LOGGER.infov("Fired Lotto[{0}, {1}}]", lottery.getId(), lottery.getNumber());
        return Response.ok().entity(response.messageId()).build();

    }

    @GET
    public List<Lottery> receive() {
        List<Message> messages = sqs.receiveMessage(m -> m.maxNumberOfMessages(10).queueUrl(QUEUE_URL)).messages();


        return messages.stream()
                .map(Message::body)
                .map(this::toLottery)
                .collect(Collectors.toList());
    }

    private Lottery toLottery(String message) {
        Lottery lottery = null;
        try {
            lottery = READER.readValue(message);
        } catch (Exception e) {
            LOGGER.error("Error decoding message", e);
            throw new RuntimeException(e);
        }
        return lottery;
    }
}

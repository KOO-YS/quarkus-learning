package org.acme.kafka.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.acme.kafka.model.Lottery;
import org.jboss.logging.Logger;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/lottery")
public class LotteryResource {

    private static final Logger LOGGER = Logger.getLogger(LotteryResource.class);

//    @Inject
//    SqsClient sqs;

//    static ObjectWriter WRITER = new ObjectMapper().writerFor(Lottery.class);

    @GET
    public void test() {
        System.out.println("test get");
    }

//    @POST
//    @Path("/shoot")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response sendMessage(Lottery lottery) throws Exception {
//        String message = WRITER.writeValueAsString(lottery);
////        SendMessageResponse response = sqs.sendMessage(m -> m.queueUrl(queueUrl).messageBody(message));
//        SendMessageResponse response = sqs.sendMessage(System.out::println);
//        LOGGER.infov("Fired Lotto[{0}, {1}}]", lottery.getId(), lottery.getNumber());
//        return Response.ok().entity(response.messageId()).build();
//    }
}

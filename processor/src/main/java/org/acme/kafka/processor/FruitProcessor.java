package org.acme.kafka.processor;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.acme.kafka.model.Fruit;
import org.acme.kafka.model.Quote;
import org.acme.kafka.resource.FruitResource;
import org.apache.kafka.common.record.Record;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

//@Path("test")
@ApplicationScoped
public class FruitProcessor {

    @Inject
    FruitResource resource;


    @GET
    @Path("{id}")
    public Fruit testGet(@PathParam("id") Long id) {
        System.out.println("input id : "+id);
        Fruit fruit = resource.get(id);
        System.out.println(fruit);
        return fruit;
    }


    @POST
    public Fruit testPost() {
        Fruit fruit = new Fruit();
        fruit.setName("orange");
        fruit.setPrice(500);
        resource.add(fruit);
        System.out.println("post add : "+fruit);
        return fruit;
    }

//    @Incoming("fruit-produce")
//    public Uni<Void> process(Message<Fruit> fruit) {
//        System.out.println("processor get fruit -> "+fruit);
//        System.out.println(fruit.getMetadata().toString());
//        System.out.println(fruit.getPayload().toString());
//
//        return Uni.createFrom().nullItem();
//    }

    @Incoming("fruit-produce")
    public Fruit process(Fruit fruit) {
        System.out.println("processor get fruit -> "+fruit);
        System.out.println(fruit.toString());

        return fruit;
    }
}

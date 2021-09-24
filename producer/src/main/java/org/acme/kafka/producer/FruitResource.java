package org.acme.kafka.producer;

import org.acme.kafka.model.Fruit;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("fruits")
public class FruitResource {

//    @Channel("test-emit")
//    Emitter<String> testEmitter;

    @Channel("fruit-produce")
    Emitter<Fruit> fruitEmitter;

    @GET
    public Fruit bringFruit() {
        Fruit fruit = new Fruit();
        fruit.setName("Banana");
        fruit.setPrice(3000);

        System.out.println("send FRUIT :: "+fruit);
        fruitEmitter.send(fruit);

        return fruit;
    }

    @POST
    public Fruit createFruit(Fruit fruit) {
        System.out.println("send : "+fruit);
        fruitEmitter.send(fruit);
        return fruit;
    }
}

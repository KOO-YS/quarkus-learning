package org.acme.kafka.resource;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import org.acme.kafka.model.Fruit;

public interface FruitResource extends PanacheEntityResource<Fruit, Long> {
}

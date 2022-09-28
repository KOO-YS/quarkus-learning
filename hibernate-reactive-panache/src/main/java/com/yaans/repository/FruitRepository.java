package com.yaans.repository;

import com.yaans.entity.Fruit;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FruitRepository implements PanacheRepository<Fruit> {

//    public Uni<Fruit>
}

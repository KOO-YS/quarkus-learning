package com.yaans.jdbc.repository;

import com.yaans.jdbc.entity.Fruit;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FruitRepository implements PanacheRepository<Fruit> {

//    public Uni<Fruit>
}

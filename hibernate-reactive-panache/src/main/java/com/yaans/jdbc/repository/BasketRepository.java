package com.yaans.jdbc.repository;

import com.yaans.jdbc.entity.Basket;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BasketRepository implements PanacheRepository<Basket> {


}

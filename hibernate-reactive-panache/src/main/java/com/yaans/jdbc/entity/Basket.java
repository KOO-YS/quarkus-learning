package com.yaans.jdbc.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Basket extends PanacheEntity {

    private String name;

    @OneToMany
    private List<Fruit> fruits = new ArrayList<>();
}

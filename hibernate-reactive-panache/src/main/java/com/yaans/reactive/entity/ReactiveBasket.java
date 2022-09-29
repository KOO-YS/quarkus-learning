package com.yaans.reactive.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reactive_basket")
@Getter
public class ReactiveBasket extends PanacheEntityBase {

    @Id
    private Long basketId;

    private String name;

    @OneToMany
    private List<ReactiveFruit> fruits = new ArrayList<>();
}

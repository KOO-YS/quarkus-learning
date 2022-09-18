package com.yaans.entity;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Fruit {

    @Id
    private Long fruitId;

    private String name;

    private int price;
}

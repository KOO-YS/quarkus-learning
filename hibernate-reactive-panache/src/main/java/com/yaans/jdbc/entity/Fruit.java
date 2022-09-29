package com.yaans.jdbc.entity;


import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fruit extends PanacheEntity {

    private String name;

    private int price;


}

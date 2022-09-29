package com.yaans.reactive.entity;


import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reactive_fruit")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReactiveFruit extends PanacheEntityBase {

    @Id
    private Long fruitId;

    private String name;

    private int price;


}

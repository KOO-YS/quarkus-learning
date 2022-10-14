package com.yaans.heritance.domain;


import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import lombok.Getter;

import javax.persistence.*;

/**
 * Super Class
 */
@Entity
@Getter
public class Animal extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "",
            sequenceName = "animal_seq",
            initialValue = 1,
            allocationSize = 1)
    private Long animalId;

    private String name;

    private boolean canFly;



}

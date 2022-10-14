package com.yaans.heritance.domain;

import javax.persistence.Entity;

/**
 * Sub Class
 */
@Entity
public class Dog extends Animal{

    private String size;
    private String hairLength;

}

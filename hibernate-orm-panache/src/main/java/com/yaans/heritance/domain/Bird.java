package com.yaans.heritance.domain;

import javax.persistence.Entity;

/**
 * Sub Class
 */
@Entity
public class Bird extends Animal{

    private String feed;
    private String habitat;

}

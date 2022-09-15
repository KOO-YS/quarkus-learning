package org.acme.kafka.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@Setter
@ToString
public class Fruit extends PanacheEntityBase {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private Integer price;

}

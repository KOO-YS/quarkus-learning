package org.acme.kafka.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Setter
@ToString
public class Fruit{

    private Long id;
    private String name;
    private Integer price;

}

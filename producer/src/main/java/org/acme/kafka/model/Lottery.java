package org.acme.kafka.model;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@RegisterForReflection
@Getter
@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
@ToString
public class Lottery {

    private long id;
    private long number;


}

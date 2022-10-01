package com.yaans.jdbc;

import com.yaans.jdbc.entity.Fruit;
import com.yaans.jdbc.repository.FruitRepository;
import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
/**
 * Default CRUD using One Entity
 */
@Path("/fruit")
public class FruitResource {

    @Inject
    @DataSource("jdbc-entity")
    AgroalDataSource jdbcDataSource;

    @Inject
    FruitRepository fruitRepository;

//    @GET
//    @Path("health")
//    public Uni<Boolean> healthy() throws SQLException {
//        return Uni.createFrom().item(jdbcDataSource.isHealthy(true));
//    }
    @GET
    @Path("c")
    public Uni<Response> create() {
        Fruit f = Fruit.builder()
//            .fruitId(1L)
            .name("Apple")
            .price(2000)
        .build();
        return Panache.<Fruit>withTransaction(f::persist)
            .onItem()
            .transform(saved -> Response.ok(saved).build());
    }


    @GET
    @Path("r")
    public Uni<Response> read() {
        Fruit f = Fruit.builder()
//            .fruitId(1L)
            .build();
        return Fruit.<Fruit>findById(1L)
            .onItem()
            .transform(result -> Response.ok(result).build());
    }


    @GET
    @Path("u")
    public Uni<Response> update() {
        Fruit f = Fruit.builder()
//            .fruitId(1L)
            .name("Banana")
            .price(3000)
            .build();

        return Fruit.<Fruit>findById(1L)
            .map(get -> {
                get.setName(f.getName());
                get.setPrice(f.getPrice());
                return get;
            })
            .chain(get -> Panache.<Fruit>withTransaction(get::persist)
            .onItem()
            .transform(updated -> Response.ok(updated).build()));
    }


    @GET
    @Path("d")
    public Uni<Response> delete() {
        return Fruit.deleteById(1L)
            .onItem()
            .transform(deleted -> Response.ok(deleted).build());
    }
}
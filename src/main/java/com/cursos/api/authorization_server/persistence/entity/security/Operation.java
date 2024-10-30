package com.cursos.api.authorization_server.persistence.entity.security;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    private String name; //FIND_ALL_PRODUCTS.... ETC

    private String path;  // /products/{product}/disabled ejemplo

    private String httpMethod;  // POST, PUT, GET

    private boolean permitAll;

    @Column(name = "module_id")
    private long moduleId;



}

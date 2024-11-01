package com.cursos.api.authorization_server.persistence.entity.security;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClientApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String clientId;

    private String clientSecret;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> clientAuthenticationMethods;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> authorizationGrantTypes;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> redirectUris;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> scopes;

    private int durationInMinutes;

    private boolean requiredProofKey;

}

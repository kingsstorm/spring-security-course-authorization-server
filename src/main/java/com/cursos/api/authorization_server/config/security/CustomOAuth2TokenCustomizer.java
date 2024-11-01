package com.cursos.api.authorization_server.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomOAuth2TokenCustomizer implements OAuth2TokenCustomizer<JwtEncodingContext> {
    @Override
    public void customize(JwtEncodingContext context) {
        Authentication authentication = context.getPrincipal(); // authentication

        String tokenType =context.getTokenType().getValue();

        List<String> authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        if (tokenType.equals("access_token")) {
            context.getClaims().claim("permissions", authorities);
        }
    }
}

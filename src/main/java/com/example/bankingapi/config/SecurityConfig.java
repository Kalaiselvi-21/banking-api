package com.example.bankingapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.Map;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .cors(cors -> {})

                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                .authorizeHttpRequests(auth -> auth

                        // Account APIs
                        .requestMatchers(HttpMethod.GET, "/api/accounts")
                        .authenticated()

                        .requestMatchers(HttpMethod.GET, "/api/accounts/*")
                        .authenticated()

                        // Create account → admin
                        .requestMatchers(HttpMethod.POST, "/api/accounts")
                        .hasRole("admin")

                        // Create transaction → maker
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/accounts/*/transactions"
                        )
                        .hasRole("maker")

                        // Delete beneficiary → admin or checker
                        .requestMatchers(
                                HttpMethod.DELETE,
                                "/api/beneficiaries/*"
                        )
                        .hasAnyRole("admin", "checker")

                        // Everything else requires login
                        .anyRequest().authenticated()
                )

                .oauth2ResourceServer(oauth2 ->
                        oauth2.jwt(jwt ->
                                jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())
                        )
                );

        return http.build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {

        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();

        converter.setJwtGrantedAuthoritiesConverter(this::extractRoles);

        return converter;
    }

    private List<GrantedAuthority> extractRoles(Jwt jwt) {

        Map<String, Object> realmAccess =
                jwt.getClaimAsMap("realm_access");

        if (realmAccess == null) {
            return List.of();
        }

        Object rolesObject = realmAccess.get("roles");

        if (!(rolesObject instanceof List<?> roles)) {
            return List.of();
        }

        return roles.stream()
                .filter(String.class::isInstance)
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .map(authority -> (GrantedAuthority) authority)
                .toList();
    }
}
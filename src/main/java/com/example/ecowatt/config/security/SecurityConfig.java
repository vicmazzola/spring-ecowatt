package com.example.ecowatt.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for Spring Security.
 *
 * <p>Defines basic HTTP security settings for the Ecowatt application.</p>
 * <ul>
 *     <li>Requires authentication for POST, PUT, and DELETE requests to <code>/api/energy</code>.</li>
 *     <li>Allows GET and other requests without authentication.</li>
 * </ul>
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configures the security filter chain for the application.
     *
     * @param httpSecurity the {@link HttpSecurity} to configure
     * @return the configured {@link SecurityFilterChain}
     * @throws Exception if a security configuration error occurs
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/energy").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/api/energy/**").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/api/energy/**").authenticated()
                        .anyRequest().permitAll()
                )
                .httpBasic(http -> {
                })
                .build();
    }
}


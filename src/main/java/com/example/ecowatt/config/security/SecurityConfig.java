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
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configures the security filter chain for the application.
     *
     * <p>Disables CSRF protection, sets stateless session policy, and enables basic authentication.</p>
     * <ul>
     *     <li>Allows all POST requests to <code>/energy</code> only for authenticated users.</li>
     *     <li>All other requests are permitted.</li>
     * </ul>
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
                        .requestMatchers(HttpMethod.POST, "/energy").authenticated()
                        .anyRequest().permitAll()
                )
                .httpBasic(http -> {})
                .build();
    }
}

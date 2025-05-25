package com.medislot.appointment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api/uploads/**",
                                "/api/users/register",
                                "/api/users/login",
                                "/api/admin/register",
                                "/api/admin/login",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-resources/**",
                                "/webjars/**"

                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()); // enables basic authentication
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

}

//
//"/api/users/register",
//        "/api/users/login",
//        "/api/admin/register",
//        "/api/admin/login",
//        "/api/uploads/**",
//        "/swagger-ui/**",
//        "/v3/api-docs/**",
//        "/swagger-resources/**",
//        "/webjars/**"

//api/users/register",
//        "/api/users/login",
//        "/swagger-ui/**",
//        "/v3/api-docs/**",
//        "/swagger-resources/**",
//        "/webjars/**",
//        "/api/admin/register",
//        "/api/admin/login",
//        "/api/uploads/**"
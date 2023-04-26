package com.pdl.PDL_Backend.security;

import com.pdl.PDL_Backend.config.JwtAuthFilter;
import com.pdl.PDL_Backend.user.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/user/register_client", "/api/user/login", "/api/user/register_admin").permitAll()
                .requestMatchers("/api/category/admin/**", "/api/product/admin/**", "/api/command/admin/**", "/api/supply/admin/**", "/api/supply_product/**").hasAnyRole("ADMIN")
                .requestMatchers("/api/command/client/**").hasAnyRole("CLIENT")
                .requestMatchers("/api/category/categories", "/api/product/products", "/api/product/products/**", "/api/command/commands", "/api/command_product/**").hasAnyRole("CLIENT", "ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        ;
        return http.build();

    }
}

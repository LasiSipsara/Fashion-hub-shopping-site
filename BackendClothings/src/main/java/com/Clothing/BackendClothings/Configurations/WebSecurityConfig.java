package com.Clothing.BackendClothings.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private static final String[] WHITE_LIST_URLS = {
            "/api/v1/register",
            "/api/v1/addOrderItems",
            "/api/v1/product"

    };

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(WHITE_LIST_URLS).permitAll()
                                .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable()) // Disable CSRF (Cross-Site Request Forgery) protection
                .cors(cors -> cors.disable()); // Disable CORS (Cross-Origin Resource Sharing)

        return http.build();
    }
}

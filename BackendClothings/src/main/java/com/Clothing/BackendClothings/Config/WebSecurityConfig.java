package com.Clothing.BackendClothings.Config;

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
            "/api/v1/products",
            "/api/v1/product/AllProducts",
            "/api/v1/product/productId",
            "/api/v1/product/search",
            "/api/v1/product/ProductCategory",
            "/api/v1/product/UpdateQuantity",
            "/api/v1/product/AddProduct",
            "/user/check-email/{email}",
            "/login",
            "/user"


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
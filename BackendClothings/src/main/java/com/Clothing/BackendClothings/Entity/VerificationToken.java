package com.Clothing.BackendClothings.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static jakarta.persistence.FetchType.EAGER;

@Entity
@Data
@NoArgsConstructor
public class VerificationToken {
    private static final int EXPIRATION_TIME =10 ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private Date expirationTime;
    @OneToOne(fetch = EAGER)
    @JoinColumn(name= "cust_id",nullable = false,foreignKey = @ForeignKey(name = "FK_USER_VERIFY_TOKEN"))
    private  Customer customer;

    public VerificationToken(String token, Customer customer) {
        this.token = token;
        this.customer = customer;
        this.expirationTime = calculateExpirationTime(EXPIRATION_TIME);
    }
    public VerificationToken(String token) {
        this.token = token;

        this.expirationTime = calculateExpirationTime(EXPIRATION_TIME);
    }
    private Date calculateExpirationTime(int expiryTimeInMinutes) {
        Date now = new Date();
        long expirationTimeInMillis = now.getTime() + (expiryTimeInMinutes * 60 * 1000);
        return new Date(expirationTimeInMillis);
    }


}

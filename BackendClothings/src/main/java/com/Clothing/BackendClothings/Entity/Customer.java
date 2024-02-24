package com.Clothing.BackendClothings.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")

    Long id;
    String firstName;
    String lastName;
    @Column(name = "email_address")
    String email;

    String password;
    String city;
    @Column(name = "postal_code")
    String postalCode;
    String address;


}

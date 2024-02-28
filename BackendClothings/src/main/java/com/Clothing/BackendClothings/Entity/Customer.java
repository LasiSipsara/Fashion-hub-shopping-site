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

   private Long id;
 private    String firstName;
  private   String lastName;
    @Column(name = "email_address")
  private   String email;

   private String password;
   private String city;
    @Column(name = "postal_code")
   private String postalCode;
   private String address;
    private String role ;
    private boolean enabled = false;


}

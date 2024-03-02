package com.Clothing.BackendClothings.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String address;
    private String city;
    private String postalCode;

    public Customer(Long id, String firstName, String lastName, String email, String password, String city, String postalCode, String address, String user, boolean b) {
    }


    public String getFirstName() {
        return this.firstname;
    }

    public String getLastName() {
        return this.lastname;
    }
}

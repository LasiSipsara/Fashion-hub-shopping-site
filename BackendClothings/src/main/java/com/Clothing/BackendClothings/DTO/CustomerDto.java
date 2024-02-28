package com.Clothing.BackendClothings.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDto {
    Long id;
    String firstName;
    String lastName;

    String email;

    String password;
    String city;

    String postalCode;
    String address;
     String role ;


}

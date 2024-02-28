package com.Clothing.BackendClothings.Mapping;

import com.Clothing.BackendClothings.DTO.CustomerDto;
import com.Clothing.BackendClothings.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    private static PasswordEncoder passwordEncoder;

    @Autowired
    public CustomerMapper(PasswordEncoder passwordEncoder) {
        CustomerMapper.passwordEncoder = passwordEncoder;
    }

    public static CustomerDto customerToCustomerDto(Customer customer) {
        String password = passwordEncoder.encode(customer.getPassword());

        return new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                password,
                customer.getCity(),
                customer.getPostalCode(),
                customer.getAddress(),
                "User"
        );
    }

    public static Customer customerDtoToCostumer(CustomerDto customerDto) {
        String password = passwordEncoder.encode(customerDto.getPassword());

        return new Customer(
                customerDto.getId(),
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmail(),
                password,
                customerDto.getCity(),
                customerDto.getPostalCode(),
                customerDto.getAddress(),
                "user",
                false
        );
    }
}


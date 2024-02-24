package com.Clothing.BackendClothings.Mapping;

import com.Clothing.BackendClothings.DTO.CustomerDto;
import com.Clothing.BackendClothings.Entity.Customer;

public class CustomerMapper {

    public  static CustomerDto customerToCustomerDto(Customer customer){
        return  new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getCity(),
                customer.getPostalCode(),
                customer.getAddress()

        );
    }
    public static  Customer customerDtoToCostumer(CustomerDto customerDto){
        return new Customer(
                customerDto.getId(),
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmail(),
                customerDto.getPassword(),
                customerDto.getCity(),
                customerDto.getPostalCode(),
                customerDto.getAddress()
        );


    }
        }

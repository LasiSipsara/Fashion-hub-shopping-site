package com.Clothing.BackendClothings.Service;

import com.Clothing.BackendClothings.DTO.CustomerDto;
import com.Clothing.BackendClothings.Entity.Customer;

public interface CustomerService {

     static Customer getCustomerByCustomerId(long customerId);
     CustomerDto  CreateCustomer(CustomerDto customerDto);

    void saveTokenForCustomerVerification(String token, Customer customer);

    String validateVerificationToken(String token);

}

package com.Clothing.BackendClothings.Service;

import com.Clothing.BackendClothings.Entity.Customer;

public interface CustomerService {

    Customer saveCustomer(Customer newCustomer);
    Customer getCustomer(Customer getCustomer);
    Boolean  findByEmail(String email);


    Customer getCustomerById(long customerId);
}

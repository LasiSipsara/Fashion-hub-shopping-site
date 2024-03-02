package com.Clothing.BackendClothings.Service;


import com.Clothing.BackendClothings.Entity.Customer;
import com.Clothing.BackendClothings.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CustomerImpl implements  CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

    @Override
    public Customer getCustomer(Customer loginCustomer) {
        Customer existingCustomer = customerRepository.findByEmailAndPassword(loginCustomer.getEmail(), loginCustomer.getPassword());

        if (existingCustomer != null) {

            return existingCustomer;
        } else {

            return null;
        }
    }

    @Override
    public Boolean findByEmail(String email) {
        return  customerRepository.existsByEmail(email);
    }

    @Override
    public Customer getCustomerById(long customerId) {
       return customerRepository.findByCustomerId(customerId);
    }

}




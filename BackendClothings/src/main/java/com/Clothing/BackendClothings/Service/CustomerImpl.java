package com.Clothing.BackendClothings.Service;


import com.Clothing.BackendClothings.DTO.CustomerDto;
import com.Clothing.BackendClothings.Entity.Customer;
import com.Clothing.BackendClothings.Mapping.CustomerMapper;
import com.Clothing.BackendClothings.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CustomerImpl implements  CustomerService {
    @Autowired
    private CustomerRepository  customerRepository;
    @Override
    public CustomerDto CreateCustomer(CustomerDto customerDto) {
        Customer customer = customerRepository.save(CustomerMapper.customerDtoToCostumer(customerDto));
        return CustomerMapper.customerToCustomerDto(customer);
    }
}



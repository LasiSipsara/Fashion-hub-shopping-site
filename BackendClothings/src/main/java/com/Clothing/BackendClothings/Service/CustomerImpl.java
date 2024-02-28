package com.Clothing.BackendClothings.Service;


import com.Clothing.BackendClothings.Config.WebSecurityConfig;
import com.Clothing.BackendClothings.DTO.CustomerDto;
import com.Clothing.BackendClothings.Entity.Customer;
import com.Clothing.BackendClothings.Entity.VerificationToken;
import com.Clothing.BackendClothings.Mapping.CustomerMapper;
import com.Clothing.BackendClothings.Repository.CustomerRepository;
import com.Clothing.BackendClothings.Repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CustomerImpl implements  CustomerService {
    @Autowired
    private CustomerRepository  customerRepository;
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;


    @Override
    public CustomerDto CreateCustomer(CustomerDto customerDto) {
        Customer customer = customerRepository.save(CustomerMapper.customerDtoToCostumer(customerDto));
        return CustomerMapper.customerToCustomerDto(customer);
    }

    @Override
    public void saveTokenForCustomerVerification(String token, Customer customer) {
      VerificationToken verificationToken = new VerificationToken(token,customer);
      verificationTokenRepository.save(verificationToken);
    }
}



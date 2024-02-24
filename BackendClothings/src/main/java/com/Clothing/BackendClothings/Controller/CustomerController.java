package com.Clothing.BackendClothings.Controller;


import com.Clothing.BackendClothings.DTO.CustomerDto;
import com.Clothing.BackendClothings.Entity.Customer;
import com.Clothing.BackendClothings.Mapping.CustomerMapper;
import com.Clothing.BackendClothings.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ap1/v1/customer")
@RestController


public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping()
    public ResponseEntity saveCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto customerDto1 = customerService.CreateCustomer(customerDto);
        return new ResponseEntity<>(customerDto1, HttpStatus.CREATED);

    }


}

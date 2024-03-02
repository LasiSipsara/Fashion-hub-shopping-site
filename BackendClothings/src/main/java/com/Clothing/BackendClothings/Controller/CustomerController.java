package com.Clothing.BackendClothings.Controller;


import com.Clothing.BackendClothings.Entity.Customer;
import com.Clothing.BackendClothings.Service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/user")
    Customer newUser(@RequestBody Customer newCustomer) {
        return customerService.saveCustomer(newCustomer) ;
    }
    @PostMapping("/login")
    Customer loginUser(@RequestBody Customer loginCustomer) {

        Customer customer =  customerService.getCustomer(loginCustomer);
        return  customer;

    }
    @GetMapping("/user/check-email/{email}")
    public ResponseEntity<Map<String, Boolean>> checkEmailExists(@PathVariable String email) {
        boolean exists = customerService.findByEmail(email);
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return ResponseEntity.ok(response);
    }


}

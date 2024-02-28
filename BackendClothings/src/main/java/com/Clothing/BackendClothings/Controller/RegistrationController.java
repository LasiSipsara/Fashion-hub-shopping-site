package com.Clothing.BackendClothings.Controller;


import com.Clothing.BackendClothings.DTO.CustomerDto;
import com.Clothing.BackendClothings.Event.RegistrationCompleteEvent;
import com.Clothing.BackendClothings.Mapping.CustomerMapper;
import com.Clothing.BackendClothings.Service.CustomerService;
import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/register")
@RestController

public class RegistrationController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping()
    public ResponseEntity saveCustomer(@RequestBody CustomerDto customerDto,HttpServletRequest request ){
        CustomerDto customerDto1 = customerService.CreateCustomer(customerDto);
        publisher.publishEvent(new RegistrationCompleteEvent(CustomerMapper.customerDtoToCostumer(customerDto1),applicationUrl(request) ));
        return new ResponseEntity<>(customerDto1, HttpStatus.CREATED);

    }
    private String applicationUrl(HttpServletRequest request ){
        return  "http://" + request.getServerName()+":"+request.getServerPort()+request.getContextPath();

    }
}

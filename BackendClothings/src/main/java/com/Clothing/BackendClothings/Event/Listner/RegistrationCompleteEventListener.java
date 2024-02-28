package com.Clothing.BackendClothings.Event.Listner;

import com.Clothing.BackendClothings.Entity.Customer;
import com.Clothing.BackendClothings.Event.RegistrationCompleteEvent;
import com.Clothing.BackendClothings.Service.CustomerService;
import com.Clothing.BackendClothings.Service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmailService emailService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        Customer customer = event.getCustomer();
        String token = UUID.randomUUID().toString();
        customerService.saveTokenForCustomerVerification(token, customer);


        String url = event.getUrl() + "/verifyRegistration?token=" + token;


        //sendVerificationEmail()
        log.info("Click the link to verify your account: {}",
                url);
    }
}

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


        String subject = "Complete Registration";
        String text = "Dear " + customer.getFirstName() + ",\n\n"
                + "Please click on the following link to complete your registration:\n"
                + url;


        emailService.sendEmail(customer.getEmail(), subject, text);

        log.info("Email sent for registration confirmation to: {}", customer.getEmail());
    }
}

package com.Clothing.BackendClothings.Event;

import com.Clothing.BackendClothings.Entity.Customer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
import org.springframework.security.core.userdetails.User;

@Getter
@Setter

public class RegistrationCompleteEvent extends ApplicationEvent {

    Customer customer;
    String url;
    public RegistrationCompleteEvent(Customer customer , String url) {
        super(customer);
        this.customer = customer;
        this.url = url;
    }
}

package com.Clothing.BackendClothings.Repository;

import com.Clothing.BackendClothings.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer getCustomerByCustomerId(long customerId);


}
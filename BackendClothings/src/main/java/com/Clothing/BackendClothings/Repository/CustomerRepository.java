package com.Clothing.BackendClothings.Repository;

import com.Clothing.BackendClothings.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);

    Customer findByCustomerId(long customerId);
}

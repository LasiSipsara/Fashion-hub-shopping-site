package com.Clothing.BackendClothings.Repository;

import com.Clothing.BackendClothings.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {
}

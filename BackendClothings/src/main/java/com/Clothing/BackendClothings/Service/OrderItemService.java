package com.Clothing.BackendClothings.Service;

import com.Clothing.BackendClothings.Entity.OrderItem;
import com.Clothing.BackendClothings.Repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService  {
    @Autowired
    private OrderItemRepository orderItemRepository;
    public OrderItem saveOrderItem(OrderItem orderItem){
        OrderItem orderItem1= orderItemRepository.save(orderItem);
        return orderItem1;
    }
}

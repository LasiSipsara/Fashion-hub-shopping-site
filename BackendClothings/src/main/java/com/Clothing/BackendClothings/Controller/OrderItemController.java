package com.Clothing.BackendClothings.Controller;

import com.Clothing.BackendClothings.Entity.OrderItem;
import com.Clothing.BackendClothings.Service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/addOrderItems")
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;

    @PostMapping
    public String addSingleOrderToOrderItem(@RequestBody OrderItem orderItem) {
        try {
            orderItemService.saveOrderItem(orderItem);
            return "Successfully added to the OrderItem";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while adding to the OrderItem: " + e.getMessage();
        }
    }
}

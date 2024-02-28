package com.Clothing.BackendClothings.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Long orderId;
    int productId;
    int quantity;

    public OrderItem(Long orderId, int productId,int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;

    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}

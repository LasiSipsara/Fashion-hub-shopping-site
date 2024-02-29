package com.Clothing.BackendClothings.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int productId;
    private int quantity;
    private float amount;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name= "customer_id",referencedColumnName = "customer_id")
    private Customer customer;


    public ShoppingCart(){

    }

    public ShoppingCart(int productId, int quantity, float amount, Customer customer){
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
        this.customer = customer;
    }

    public ShoppingCart(int productId, int quantity){
        this.productId = productId;
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return "ShoppingCart{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", user=" + customer +
                '}';
    }
}

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
    private int product_id;
    private int quantity;
    private float amount;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name= "customer_id",referencedColumnName = "customer_id")
    private Customer customer;


    public ShoppingCart(){

    }

    public ShoppingCart(int product_id, int quantity, float amount, Customer customer){
        this.product_id = product_id;
        this.quantity = quantity;
        this.amount = amount;
        this.customer = customer;
    }

    public ShoppingCart(int product_id, int quantity){
        this.product_id = product_id;
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


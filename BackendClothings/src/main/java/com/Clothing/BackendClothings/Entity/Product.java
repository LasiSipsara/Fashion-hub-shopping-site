package com.Clothing.BackendClothings.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String productName;
    private int availableQuantity;
    private float price;
    private String size;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String image;

    private int categoryId;

    @Override

    public String toString(){
        return "Product{"+
                ",id="+productId+
                ",name='"+productName+'\''+
                "availableQuantity="+availableQuantity+
                "price="+price+
                "image='"+image+'\''+
                "size='"+size+'\''+
                "description='"+description+'\''+
                "category="+categoryId+
                "}";


    }



}

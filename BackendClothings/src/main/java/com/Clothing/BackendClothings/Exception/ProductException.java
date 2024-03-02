package com.Clothing.BackendClothings.Exception;

public class ProductException extends Exception {
    public ProductException(String message, Exception e){
        super(message);
    }
}

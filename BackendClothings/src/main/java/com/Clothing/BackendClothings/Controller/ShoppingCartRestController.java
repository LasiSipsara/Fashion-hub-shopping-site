package com.Clothing.BackendClothings.Controller;


import com.Clothing.BackendClothings.Entity.ShoppingCart;
import com.Clothing.BackendClothings.Service.CustomerService;
import com.Clothing.BackendClothings.Service.ProductService;
import com.Clothing.BackendClothings.Service.ShoppingCartService;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/cart")

public class ShoppingCartRestController {

    private ProductService productService;
    private CustomerService customerService;
    private ShoppingCartService shoppingCartService;


    public ShoppingCartRestController(ProductService productService, CustomerService customerService, ShoppingCartService shoppingCartService) {
        this.productService = productService;
        this.customerService = customerService;
        this.shoppingCartService = shoppingCartService;
    }

    private Logger logger = (Logger) LoggerFactory.getLogger(ShoppingCartRestController.class);


    @GetMapping("/test")
    public ResponseEntity<List<ShoppingCart>> getShoppingCartDetailsByUser (@PathVariable long customer_id){
        List<ShoppingCart> cartList = shoppingCartService.getShoppingCartDetailsByUserId(customer_id);
        return ResponseEntity.ok(cartList);
    }
}

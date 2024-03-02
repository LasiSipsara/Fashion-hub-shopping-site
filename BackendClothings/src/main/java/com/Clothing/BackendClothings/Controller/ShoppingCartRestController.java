package com.Clothing.BackendClothings.Controller;


import com.Clothing.BackendClothings.DTO.AddToCartDTO;
import com.Clothing.BackendClothings.DTO.CustomerDto;
import com.Clothing.BackendClothings.Entity.Customer;
import com.Clothing.BackendClothings.Entity.Product;
import com.Clothing.BackendClothings.Entity.ShoppingCart;
import com.Clothing.BackendClothings.Service.CustomerImpl;
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
    public String test(){
        return "Hello World";
    }


    @GetMapping(value = "/{customer_id}")
    public ResponseEntity<List<ShoppingCart>> getShoppingCartDetailsByUser (@PathVariable long customer_id){
        List<ShoppingCart> cartList = shoppingCartService.getShoppingCartDetailsByUserId(customer_id);
        return ResponseEntity.ok(cartList);
    }

    @PostMapping("/addToCart/{customer_id}")
    public String placeOrder(@PathVariable long customer_id, @RequestBody AddToCartDTO addToCartDTO){
        logger.info("Request Payload" + addToCartDTO.toString());
        Customer customer = CustomerService.getCustomer(customer_id);
        Product product = productService.getProductById(addToCartDTO.getProduct_id());
        ShoppingCart existingCart = null;
        existingCart = shoppingCartService.FindShoppingCartByCustomerAndProduct(customer_id,product.getProductId());
        if (existingCart != null){
            int newQuantity = addToCartDTO.getQuantity()+existingCart.getQuantity();
            float newAmount = newQuantity * product.getPrice();
            existingCart.setAmount(newAmount);
            existingCart.setQuantity(newQuantity);
            existingCart = shoppingCartService.saveShoppingCart(existingCart);
            if (existingCart != null){
                return "Can't update the cart";
            } else {
                return "Cart successfully updated";
            }
        }
        else {
            float amount = product.getPrice() * addToCartDTO.getQuantity();

        }




    }





}

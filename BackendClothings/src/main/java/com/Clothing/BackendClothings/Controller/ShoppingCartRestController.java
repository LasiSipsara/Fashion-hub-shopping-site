package com.Clothing.BackendClothings.Controller;


import com.Clothing.BackendClothings.DTO.AddToCartDTO;
import com.Clothing.BackendClothings.DTO.CustomerDto;
import com.Clothing.BackendClothings.Entity.Customer;
import com.Clothing.BackendClothings.Entity.Product;
import com.Clothing.BackendClothings.Entity.ShoppingCart;
import com.Clothing.BackendClothings.Exception.ProductException;
import com.Clothing.BackendClothings.Service.CustomerImpl;
import com.Clothing.BackendClothings.Service.CustomerService;
import com.Clothing.BackendClothings.Service.ProductService;
import com.Clothing.BackendClothings.Service.ShoppingCartService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String placeOrder(@PathVariable long customer_id, @RequestBody AddToCartDTO addToCartDTO) throws ProductException {
        logger.info("Request Payload" + addToCartDTO.toString());
        Customer customer = customerService.getCustomerByCustomerId(customer_id);
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
            ShoppingCart cartItem = new ShoppingCart(addToCartDTO.getProduct_id(),addToCartDTO.getQuantity(), amount, customer);
            if (product.getAvailableQuantity() >= addToCartDTO.getQuantity()) {
                shoppingCartService.saveShoppingCart(cartItem);
                int newQuantity = product.getAvailableQuantity() - addToCartDTO.getQuantity();
                product.setAvailableQuantity(newQuantity);
                product = productService.addNewProduct(product);
                logger.info("Order processed successfully");
                return "Successfully Added to Cart";
            } else {
                return "Not enough available Quantity";
            }
        }
    }

    @PostMapping("/updateShoppingCart")
    public String updateShoppingCartQuantity(@RequestParam int id, @RequestParam int quantity) throws ProductException {
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartDetail(id);

        if (quantity==0){
            shoppingCartService.DeleteShoppingCart(shoppingCart);
            return "";
        }
        else {
            Product product = productService.getProductById(shoppingCart.getProduct_id());
            float newAmount = quantity * product.getPrice();
            if (shoppingCart.getQuantity()>quantity){
                int difference = shoppingCart.getQuantity() - quantity;
                product.setAvailableQuantity(product.getAvailableQuantity()+difference);
                product = productService.addNewProduct(product);
            }
            shoppingCart.setQuantity(quantity);
            shoppingCart.setAmount(newAmount);
            shoppingCart = shoppingCartService.saveShoppingCart(shoppingCart);
            if (shoppingCart == null) {
                return "Can't update the cart";
            } else {
                return "Cart successfully updated";
            }
        }


    }

    @PostMapping("/deleteCartItem")
    public String deleteShoppingCartItem(@RequestParam int id) throws ProductException {
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartDetail(id);
        int quantity = shoppingCart.getQuantity();
        Product product = productService.getProductById(shoppingCart.getProduct_id());
        int newQuantity = quantity + product.getAvailableQuantity();
        product.setAvailableQuantity(newQuantity);
        product = productService.addNewProduct(product);
        shoppingCartService.DeleteShoppingCart(shoppingCart);
        if (shoppingCart == null) {
            return "Can't update the cart";
        } else {
            return "Cart successfully updated";
        }
    }


    @PostMapping(value = "/deleteCart")
    public String deleteShoppingCart(@RequestParam long customer_id){
        List<ShoppingCart> cartList = shoppingCartService.getShoppingCartDetailsByUserId(customer_id);
        try {
            for (ShoppingCart cart : cartList) {
                shoppingCartService.DeleteShoppingCart(cart);
            }
            return "Cart Successfully Removed";
        }
        catch (Exception e){
            return "Can't Remove";
        }
    }

}

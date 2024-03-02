package com.Clothing.BackendClothings.Controller;


import com.Clothing.BackendClothings.Entity.Product;
import com.Clothing.BackendClothings.Exception.ProductException;
import com.Clothing.BackendClothings.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/product")

public class ProductRestController {

  @Autowired
  private ProductService productService;

  @GetMapping("/AllProducts")
  public ResponseEntity<List<Product>> getAllProducts() throws ProductException {
    try {
      List<Product> productList = productService.getAllProducts();
      return new ResponseEntity<>(productList, HttpStatus.OK);
    } catch (ProductException e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/productId")
  public ResponseEntity<Product> getProductById(@RequestParam int id) {
    try {
      Product product = productService.getProductById(id);
      return new ResponseEntity<>(product, HttpStatus.OK);
    } catch (ProductException e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @GetMapping("/search")
  public ResponseEntity<List<Product>> searchProduct(@RequestParam String searchValue) {
    try {
      List<Product> searchProductList = productService.searchProduct(searchValue);
      return new ResponseEntity<>(searchProductList, HttpStatus.OK);

    } catch (ProductException e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  @GetMapping("/ProductCategory")
  public ResponseEntity<List<Product>> getProductByCategory(@RequestParam int categoryId) {
    try {
      List<Product> productList = productService.getProductByCategoryId(categoryId);
      return new ResponseEntity<>(productList, HttpStatus.OK);

    } catch (ProductException e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  @PostMapping("/UpdateQuantity")
  public ResponseEntity<String> updateProductAvailableAmount(@RequestParam int productId, @RequestParam int boughtAmount) {
    try {
      String message = productService.updateProductAvailableAmount(productId, boughtAmount);
      return new ResponseEntity<>(message, HttpStatus.OK);
    } catch (ProductException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }


  //Operations in admin side

  @PostMapping("/AddProduct")

  public ResponseEntity<String> addNewProduct(@RequestBody Product product) {
    try {
      String message = productService.addNewProduct(product);
      return new ResponseEntity<>(message, HttpStatus.OK);
    } catch (ProductException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  @PutMapping("/UpdateProduct")

  public ResponseEntity<String> updateProduct(@RequestParam int productId, @RequestBody Product updatedProduct) {
    try {
      String message = productService.updateProduct(productId, updatedProduct);
      return new ResponseEntity<>(message, HttpStatus.OK);
    } catch (ProductException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }


  @DeleteMapping("/DeleteProduct")
  public ResponseEntity<String> deleteProduct(@RequestParam int deleteProductId) {
    try {
      String message = productService.deleteProduct(deleteProductId);
      return new ResponseEntity<>(message, HttpStatus.OK);

    } catch (ProductException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}




package com.Clothing.BackendClothings.Controller;


import com.Clothing.BackendClothings.Entity.Product;
import com.Clothing.BackendClothings.Service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductRestController {

    @Autowired
    private ProductService productservice;

  @GetMapping("/AllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
     return productservice.getAllProducts();
  }

  @GetMapping("/productId")
    public ResponseEntity<Product> getProductById(@RequestParam int id){
      return productservice.getProductById(id);
  }

  @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String searchValue){
      return productservice.searchProduct(searchValue);
  }

  @GetMapping("/ProductCategory")
    public ResponseEntity<List<Product>> getProductByCategory(@RequestParam int categoryId){
      return productservice.getProductByCategoryId(categoryId);
  }

  @PostMapping("/UpdateQuantity")
   public ResponseEntity<String> updateProductAvailableAmount(@RequestParam int productId,@RequestParam int boughtAmount){
    return  productservice.updateProductAvailableAmount(productId,boughtAmount);
  }


  //Operations in admin side

  @PostMapping("/AddProduct")

  public ResponseEntity<String> addNewProduct(@RequestBody Product product){
    return productservice.addNewProduct(product);
  }



}


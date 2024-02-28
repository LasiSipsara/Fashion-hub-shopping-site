package com.Clothing.BackendClothings.Service;

import com.Clothing.BackendClothings.Entity.Product;
import com.Clothing.BackendClothings.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public ResponseEntity<List<Product>> getAllProducts() {
        try{
          return new ResponseEntity<>(this.productRepository.findAll(), HttpStatus.OK);

        }catch(Exception e){
          e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Product> getProductById(int productId) {
        try {
            Product product = productRepository.getProductById(productId);
            if (product!=null){
                return new ResponseEntity<>(product, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public ResponseEntity<List<Product>> searchProduct(String searchValue) {
        try {
            List<Product> searchProductList = productRepository.searchProductByValue(searchValue);
            if (searchProductList != null) {
                return new ResponseEntity<>(searchProductList, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
           e.printStackTrace();

        }
        return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<List<Product>> getProductByCategoryId(int categoryId) {
        try{
          List<Product> productList=productRepository.getProductByCategoryId(categoryId);
          if(productList!=null){
              return new ResponseEntity<>(productList,HttpStatus.OK);
          }else{
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
        }catch(Exception e){
           e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<String> updateProductAvailableAmount(int productId,int boughtAmount) {

      try{
          Product product=productRepository.getProductById(productId);
          int availableAmount=product.getAvailableQuantity();
          int newQuantity=availableAmount-boughtAmount;
          product.setAvailableQuantity(newQuantity);
          return new ResponseEntity<>(HttpStatus.OK);
      }catch(Exception e){
          e.printStackTrace();
      }
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    //admin side operations
    public ResponseEntity<String> addNewProduct(Product product) {
        try{
            this.productRepository.save(product);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

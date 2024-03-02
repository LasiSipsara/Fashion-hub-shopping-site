package com.Clothing.BackendClothings.Service;

import com.Clothing.BackendClothings.Entity.Product;
import com.Clothing.BackendClothings.Exception.ProductException;
import com.Clothing.BackendClothings.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAllProducts() throws ProductException {
        try{
          List<Product> productList= this.productRepository.findAll();
          if(productList==null){
              return Collections.emptyList();
          }else{
              return productList;
          }
        }catch(Exception e){
         throw  new ProductException("An error occurred while processing ",e);
        }
    }

    public Product getProductById(int productId) throws ProductException {
        try {
            Product product = productRepository.findByProductId(productId);
            if (product!=null){
                return product;
            }else{
                return null;
            }
        } catch (Exception e) {
           throw new ProductException("Error occurred while processing",e);

        }

    }


    public List<Product> searchProduct(String searchValue) throws ProductException {
        try {
            List<Product> searchProductList = productRepository.searchProductByValue(searchValue);
            if (searchProductList != null) {
                return searchProductList;
            }else{
                return Collections.emptyList();
            }
        } catch (Exception e) {
         throw new ProductException("Error occurred while searching",e);
        }

    }

    public List<Product> getProductByCategoryId(int categoryId) throws ProductException {
        try{
          List<Product> productList=productRepository.findByCategoryId(categoryId);
          if(productList!=null){
             return productList;
          }else{
              return Collections.emptyList();
          }
        }catch(Exception e){
          throw new ProductException("Error occurred while processing",e);
        }

    }

    public String updateProductAvailableAmount(int productId,int boughtAmount) throws ProductException {

      try{
          Product product=productRepository.findByProductId(productId);
          if(product==null){
              return "product not found";
          }
          int availableAmount=product.getAvailableQuantity();
          int newQuantity=availableAmount-boughtAmount;
          product.setAvailableQuantity(newQuantity);
          return "successfully updated";
      }catch(Exception e){
          throw new ProductException("Error occurred while updating",e);
      }

    }


    //admin side operations
    public String addNewProduct(Product product) throws ProductException {
        try{
            productRepository.save(product);
            return "Product added successfully";
        }catch(Exception e){
            throw new ProductException("Error occurred while adding new product",e);
        }

    }

    public String updateProduct(int productId, Product updatedProduct) throws ProductException {
        try{
            Product existingProduct= productRepository.findByProductId(productId);
            existingProduct.setProductId(updatedProduct.getProductId());
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setImage(updatedProduct.getImage());
            existingProduct.setSize(updatedProduct.getSize());
            existingProduct.setAvailableQuantity(updatedProduct.getAvailableQuantity());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setCategoryId(updatedProduct.getCategoryId());

            productRepository.save(existingProduct);
            return "Product updated successfully";
        }catch(Exception e){
            throw new ProductException("Error occurred while updating",e);
        }

    }

    public String deleteProduct(int deleteProductId) throws ProductException {
        try{
         productRepository.deleteByProductId(deleteProductId);
         return "Product deleted successfully";

        }catch (Exception e){
           throw new ProductException("Error occurred while deleting",e);
        }

    }
}

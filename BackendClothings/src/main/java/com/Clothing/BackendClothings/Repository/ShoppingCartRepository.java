package com.Clothing.BackendClothings.Repository;


import com.Clothing.BackendClothings.Entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    //new
    public List<ShoppingCart> findAllByUserId(long userId);

    ShoppingCart findByUserIdAndProductId(long customer_id, int product_id);

}
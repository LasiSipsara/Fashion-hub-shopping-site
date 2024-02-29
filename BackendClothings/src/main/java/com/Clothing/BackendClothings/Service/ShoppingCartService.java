package com.Clothing.BackendClothings.Service;


        import com.Clothing.BackendClothings.Entity.ShoppingCart;
        import com.Clothing.BackendClothings.Repository.ProductRepository;
        import com.Clothing.BackendClothings.Repository.ShoppingCartRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private ProductRepository productRepository;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
    }

    public ShoppingCart getShoppingCartDetail(int Id){
        Optional<ShoppingCart> shoppingCart = this.shoppingCartRepository.findById(Id);
        return shoppingCart.isPresent()?shoppingCart.get():null;
    }
    public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart){
        return shoppingCartRepository.save(shoppingCart);
    }
    public String DeleteShoppingCart(ShoppingCart shoppingCart){
        try {
            shoppingCartRepository.delete(shoppingCart);
            return "Deleted shopping cart successfully";
        }
        catch (Exception e){
            return "Can't delete the cart";
        }
    }
    //new
    public List<ShoppingCart> getShoppingCartDetailsByUserId(long userId){
        return shoppingCartRepository.findAllByUserId(userId);
    }

    public ShoppingCart FindShoppingCartByCustomerAndProduct(long customer_id, int product_id){
        return shoppingCartRepository.findByUserIdAndProductId(customer_id,product_id);
    }
}

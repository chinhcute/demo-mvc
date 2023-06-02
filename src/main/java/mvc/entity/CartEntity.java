package mvc.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("session")
public class CartEntity {
    @Autowired
    private List<ProductEntity> cartItems;

    public CartEntity() {
        cartItems = new ArrayList<>();
    }

    public void setCartItems(List<ProductEntity> cartItems) {
        this.cartItems = cartItems;
    }

    public List<ProductEntity> getCartItems() {
        return cartItems;
    }

    public void addToCart(ProductEntity product) {
        cartItems.add(product);
    }

    public void removeFromCart(ProductEntity product) {
        cartItems.remove(product);
    }

    public void clearCart() {
        cartItems.clear();
    }
}

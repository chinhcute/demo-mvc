package mvc.controller;

import mvc.entity.CartEntity;
import mvc.entity.ProductEntity;
import mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("session")
public class ProductController {
    @Autowired
    private CartEntity cartEntity;

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String ShowProduct(Model model) {
        List<ProductEntity> productEntityList = (List<ProductEntity>) productRepository.findAll();
        model.addAttribute("productEntityList", productEntityList);
        return "oder/productList";
    }


    @GetMapping("/cart")
    public String showCart(Model model, HttpServletRequest httpServletRequest) {

        model.addAttribute("cartItems", cartEntity.getCartItems());
        return "oder/cart";
    }


    @RequestMapping(value = "/addToCart/{productId}", method = RequestMethod.GET)
    public String addToCart(@PathVariable int productId, HttpSession httpSession) {
        System.out.println(productId);
        ProductEntity product = productRepository.findById(productId).orElse(null);
        if (product != null) {
//            httpSession.setAttribute("product", product);
            cartEntity.addToCart(product);
            System.out.println(cartEntity.getCartItems());
        }
        return "redirect:/cart";
    }


    @GetMapping("/cart/remove/{productId}")
    public String removeFromCart(@PathVariable int productId) {
        ProductEntity product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            cartEntity.removeFromCart(product);
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/clear")
    public String clearCart() {
        cartEntity.clearCart();
        return "redirect:/cart";
    }


}

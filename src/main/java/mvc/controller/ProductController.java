package mvc.controller;

import mvc.entity.*;
import mvc.repository.CustomerRepository;
import mvc.repository.OrderDetailsRepository;
import mvc.repository.OrderRepository;
import mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
@Scope("session")
public class ProductController {
    @Autowired
    private CartEntity cartEntity;

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderDetailsRepository orderDetailsRepository;
    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String ShowProduct(Model model) {
        List<ProductEntity> productEntityList = (List<ProductEntity>) productRepository.findAll();
        model.addAttribute("productEntityList", productEntityList);
        return "oder/productList";
    }


    @GetMapping("/cart")
    public String showCart(Model model, HttpServletRequest httpServletRequest) {
        System.out.println(cartEntity.getCartItems());
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
    @GetMapping("/cart/checkout")
    public String checkOut(){
        return "/oder/checkOut";
    }

@PostMapping("/cart/check")
public String check(@ModelAttribute Customer customer) {
    Optional<Customer> customerCheck = customerRepository.findByNameAndAddress(customer.getName(), customer.getAddress());
    if (customerCheck.isPresent()) {
        customer = customerCheck.orElse(null);
    } else {
        customerRepository.save(customer);
    }

    List<ProductEntity> productEntityList = cartEntity.getCartItems();

    OrderEntity orderEntity = new OrderEntity();
    orderEntity.setCustomer(customer);

    orderRepository.save(orderEntity);

    for (Iterator<ProductEntity> iterator = productEntityList.iterator(); iterator.hasNext();) {
        ProductEntity product = iterator.next();
        if (!productRepository.existsById(product.getId())){
            iterator.remove();
        } else {
            OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();
            orderDetailsEntity.setProduct(product);
            orderDetailsEntity.setOrder(orderEntity);
            orderDetailsEntity.setQuantity(1);

            orderDetailsRepository.save(orderDetailsEntity);
        }
    }

    cartEntity.clearCart();
    return "redirect:/products";
}

}

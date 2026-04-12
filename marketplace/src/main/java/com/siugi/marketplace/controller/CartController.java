package com.siugi.marketplace.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.siugi.marketplace.domain.CartItems;
import com.siugi.marketplace.domain.Carts;
import com.siugi.marketplace.domain.Products;
import com.siugi.marketplace.repository.CartItemRepository;
import com.siugi.marketplace.repository.ProductRepository;
import com.siugi.marketplace.service.CartItemService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
    private final CartItemService cartItemService;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    public CartController(CartItemService cartItemService, CartItemRepository cartItemRepository, ProductRepository productRepository) {
        this.cartItemService = cartItemService;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }
    
    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Long productId,
                       HttpSession session, Model model) {

        String user = (String) session.getAttribute("loginUser");
        if (user == null) {
            return "redirect:/";
        }
        cartItemService.addCartItem(user, productId);
        return "redirect:/buyer/home";
    }

    @GetMapping("/cart")
    public String cart(HttpSession session, Model model) {
        String user = (String) session.getAttribute("loginUser");
        Carts cart = cartItemService.getCartByUsername(user);
        model.addAttribute("cartItems", cartItemService.getCartItemListByCart(cart));

        List<CartItems> cartItems = cartItemService.getCartItemListByCart(cart);

        int totalPrice = cartItems.stream()
            .mapToInt(item -> item.getProduct().getPrice() * item.getCount() + item.getProduct().getShipping_fee())
            .sum();

        model.addAttribute("totalPrice", totalPrice);
        return "buyer/cart";
    }

    @PostMapping("/cart/remove")
    public String removeToCart(@RequestParam Long id) {
        cartItemService.deleteCartItem(id);
        return "redirect:/cart";
    }

    @PostMapping("/cart/decrease")
    public String decreaseCount(@RequestParam Long id) {      
        cartItemService.decrementCartItemCount(id);
        return "redirect:/cart";
    }

    @PostMapping("/cart/increase")
    public String increaseCount(@RequestParam Long id) {
        cartItemService.incrementCartItemCount(id);
        return "redirect:/cart";
    }
}

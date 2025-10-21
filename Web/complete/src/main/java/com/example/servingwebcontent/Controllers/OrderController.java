package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.entities.Order;
import com.example.services.OrderService;
import com.example.servingwebcontent.exceptions.InsufficientStockException;
import com.example.servingwebcontent.exceptions.ResourceNotFoundException;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.HashMap;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/checkout")
    public String showCheckoutPage(Model model) {
        return "checkout_view";
    }

    @PostMapping("/place")
    public String placeOrder(
            @RequestParam Long userId,
            @RequestParam String shippingAddress,
            Model model) {

        Map<Long, Integer> cartItems = new HashMap<>();
        cartItems.put(1L, 3);
        cartItems.put(2L, 5);

        try {
            Order newOrder = orderService.createOrder(userId, cartItems, shippingAddress);
            return "redirect:/order/success?id=" + newOrder.getId();

        } catch (InsufficientStockException | ResourceNotFoundException e) {
            model.addAttribute("error", e.getMessage());
            return "checkout_view";
        }
    }

    @GetMapping("/success")
    public String showOrderSuccess(@RequestParam Long id, Model model) {
        model.addAttribute("orderId", id);
        return "order_success";
    }
}

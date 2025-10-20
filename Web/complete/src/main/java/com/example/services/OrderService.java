package com.example.services;

import com.example.servingwebcontent.entities.*;
import com.example.servingwebcontent.repositories.*;
import com.example.servingwebcontent.exceptions.InsufficientStockException;
import com.example.servingwebcontent.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Autowired private OrderRepository orderRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private UserRepository userRepository;
    
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    public Order createOrder(Long userId, Map<Long, Integer> cartItems, String shippingAddress) 
            throws InsufficientStockException {
        
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại: " + userId));
        
        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDate.now().atStartOfDay());
        order.setStatus("PENDING");
        order.setShippingAddress(shippingAddress);
        
        double totalAmount = 0.0;
        List<OrderDetail> details = new ArrayList<>();

        for (Map.Entry<Long, Integer> item : cartItems.entrySet()) {
            Long productId = item.getKey();
            int requestedQuantity = item.getValue();
            
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new ResourceNotFoundException("Sản phẩm không tồn tại: " + productId));
            
            if (product.getStock() < requestedQuantity) {
                throw new InsufficientStockException("Sản phẩm " + product.getName() +
                        " không đủ hàng. Chỉ còn: " + product.getStock());
            }

            OrderDetail detail = new OrderDetail();
            detail.setOrder(order);
            detail.setProduct(product);
            detail.setQuantity(requestedQuantity);
            detail.setPrice(product.getPrice());
            
            totalAmount += requestedQuantity * product.getPrice();
            details.add(detail);

            product.setStock(product.getStock() - requestedQuantity);
            productRepository.save(product);
        }

        order.setTotalAmount(totalAmount);
        order.setOrderDetails(details);
        
        return orderRepository.save(order);
    }
}

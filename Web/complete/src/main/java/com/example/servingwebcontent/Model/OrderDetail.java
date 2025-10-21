package com.example.servingwebcontent.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// Đánh dấu lớp này là một Entity.
@Entity
// Chỉ định tên bảng trong cơ sở dữ liệu là "order_details".
@Table(name = "order_details")
public class OrderDetail {

    // Đánh dấu trường 'id' là khóa chính.
    @Id
    // Cấu hình giá trị khóa chính được sinh tự động bởi cơ sở dữ liệu.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Thiết lập mối quan hệ nhiều-một (Many-to-One) với Entity Order.
    // Nhiều chi tiết đơn hàng (OrderDetail) có thể thuộc về một đơn hàng (Order).
    @ManyToOne
    // Chỉ định cột khóa ngoại trong bảng "order_details" là "order_id".
    // Cột này sẽ liên kết đến khóa chính của bảng "orders".
    @JoinColumn(name = "order_id")
    private Order order;

    // Thiết lập mối quan hệ nhiều-một (Many-to-One) với Entity Product.
    // Nhiều chi tiết đơn hàng có thể liên quan đến một sản phẩm.
    @ManyToOne
    // Chỉ định cột khóa ngoại trong bảng "order_details" là "product_id".
    // Cột này sẽ liên kết đến khóa chính của bảng "products".
    @JoinColumn(name = "product_id")
    private Product product;

    // Số lượng sản phẩm trong chi tiết đơn hàng này.
    private int quantity;

    // Giá của sản phẩm tại thời điểm đặt hàng.
    private double price;

    // --- Hàm khởi tạo (Constructors) ---

    /**
     * Hàm khởi tạo không tham số.
     */
    public OrderDetail() {
    }

    // --- Các phương thức Getter và Setter ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

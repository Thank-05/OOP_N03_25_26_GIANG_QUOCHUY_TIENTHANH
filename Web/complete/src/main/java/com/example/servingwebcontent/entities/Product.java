package com.example.servingwebcontent.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Mã sản phẩm (khóa chính)

    @Column(name = "name", nullable = false, length = 255)
    private String name; // Tên sản phẩm

    @Column(name = "description", length = 1000)
    private String description; // Mô tả sản phẩm

    @Column(name = "price")
    private double price; // Đơn giá sản phẩm

    @Column(name = "stock")
    private int stock; // Tồn kho của sản phẩm

    @Column(name = "image")
    private String imageUrl; // Đường dẫn tới hình ảnh sản phẩm
    
    // -- THÊM MỐI QUAN HỆ VỚI CATEGORY TẠI ĐÂY --
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Constructors (hàm khởi tạo)
    public Product() {
        // Constructor rỗng là bắt buộc đối với JPA
    }

    // Getters and Setters
    // ... (các getter/setter cũ) ...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    // Thêm getter và setter cho category
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}


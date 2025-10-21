package com.example.servingwebcontent.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// Đánh dấu lớp này là một Entity.
@Entity
// Chỉ định tên bảng trong cơ sở dữ liệu là "categories".
@Table(name = "categories")
public class Category {

    // Đánh dấu trường 'id' là khóa chính.
    @Id
    // Cấu hình giá trị khóa chính được sinh tự động bởi cơ sở dữ liệu.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Cấu hình cột 'name'.
    // nullable = false: không cho phép giá trị null.
    // unique = true: đảm bảo tên danh mục là duy nhất.
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    // Thiết lập mối quan hệ một-nhiều (One-to-Many) với Entity Product.
    // Một danh mục (Category) có thể có nhiều sản phẩm (Product).
    // mappedBy = "category": chỉ ra rằng mối quan hệ này được quản lý bởi trường 'category' trong lớp Product.
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    // --- Hàm khởi tạo (Constructors) ---
    public Category() {
    }

    // --- Các phương thức Getter và Setter ---

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

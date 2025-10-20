package com.example.servingwebcontent.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Đánh dấu lớp này là một Entity, nó sẽ được ánh xạ tới một bảng trong cơ sở dữ liệu.
@Entity
// Chỉ định tên của bảng trong cơ sở dữ liệu là "users".
@Table(name = "users")
public class User {

    // Đánh dấu trường 'id' là khóa chính của bảng.
    @Id
    // Cấu hình cách sinh giá trị cho khóa chính.
    // GenerationType.IDENTITY có nghĩa là giá trị sẽ được cơ sở dữ liệu tự động tăng.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Cấu hình cột 'username'.
    // unique = true: đảm bảo mỗi giá trị trong cột này là duy nhất.
    // nullable = false: không cho phép giá trị null (phải có dữ liệu).
    @Column(unique = true, nullable = false)
    private String username;

    // Cấu hình cột 'password'.
    // nullable = false: không cho phép giá trị null.
    @Column(nullable = false)
    private String password;

    // Cấu hình cột 'full_name', ánh xạ trường 'fullName' với cột có tên 'full_name' trong CSDL.
    @Column(name = "full_name")
    private String fullName;

    // Trường địa chỉ, sẽ được ánh xạ tới cột có tên 'address'.
    private String address;

    // Trường email, sẽ được ánh xạ tới cột có tên 'email'.
    private String email;

    // Trường số điện thoại, sẽ được ánh xạ tới cột có tên 'phone'.
    private String phone;

    // --- Hàm khởi tạo (Constructors) ---

    /**
     * Hàm khởi tạo không tham số.
     * JPA yêu cầu một hàm khởi tạo không tham số để tạo các đối tượng entity.
     */
    public User() {
    }

    // --- Các phương thức Getter và Setter ---
    // Các phương thức này dùng để truy cập và cập nhật giá trị của các trường.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

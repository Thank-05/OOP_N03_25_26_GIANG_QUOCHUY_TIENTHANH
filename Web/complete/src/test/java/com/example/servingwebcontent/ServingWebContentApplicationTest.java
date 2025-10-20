package com.example.servingwebcontent;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.servingwebcontent.controller.GreetingController;

/**
 * Lớp kiểm thử cho tầng web của ứng dụng, tập trung vào GreetingController.
 * @WebMvcTest chỉ khởi tạo tầng web thay vì toàn bộ context của ứng dụng,
 * giúp kiểm thử nhanh hơn và tập trung hơn.
 */
@WebMvcTest(controllers = GreetingController.class)
public class ServingWebContentApplicationTest {

    /**
     * MockMvc cung cấp một cách để gửi các request HTTP đến controller mà không cần
     * khởi động một server thực sự.
     */
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Kiểm tra trang chủ có trả về nội dung chính xác")
    public void homePage_shouldReturnDefaultMessage() throws Exception {
        // Thực hiện một request GET đến "/" và mong đợi kết quả
        mockMvc.perform(get("/"))
                // Mong đợi mã trạng thái HTTP 200 (OK)
                .andExpect(status().isOk())
                // Mong đợi nội dung của response chứa chuỗi "Get your greeting"
                .andExpect(content().string(containsString("Get your greeting")));
    }

    @Test
    @DisplayName("Kiểm tra lời chào mặc định khi không có tham số name")
    public void greeting_withoutName_shouldReturnDefaultMessage() throws Exception {
        // Thực hiện một request GET đến "/greeting"
        mockMvc.perform(get("/greeting"))
                // Mong đợi mã trạng thái HTTP 200 (OK)
                .andExpect(status().isOk())
                // Mong đợi nội dung response chứa lời chào mặc định "Hello, World!"
                .andExpect(content().string(containsString("Hello, World!")));
    }

    @Test
    @DisplayName("Kiểm tra lời chào được cá nhân hóa khi có tham số name")
    public void greeting_withName_shouldReturnPersonalizedMessage() throws Exception {
        // Thực hiện một request GET đến "/greeting" với tham số "name" là "Greg"
        mockMvc.perform(get("/greeting").param("name", "Greg"))
                // Mong đợi mã trạng thái HTTP 200 (OK)
                .andExpect(status().isOk())
                // Mong đợi nội dung response chứa lời chào được cá nhân hóa "Hello, Greg!"
                .andExpect(content().string(containsString("Hello, Greg!")));
    }
}

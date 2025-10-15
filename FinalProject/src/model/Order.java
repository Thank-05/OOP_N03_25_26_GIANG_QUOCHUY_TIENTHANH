public class Order {
    private int id;
    private int userId;
    private String orderDate;
    private double totalAmount;
    private String status;
    private String shippingAddress;
    public Order(int id, int userId, String orderDate, double totalAmount, String status, String shippingAddress) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
        this.shippingAddress = shippingAddress;
    }

    // Get&Set Attributes
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getOrderDate() { return orderDate; }
    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Methods

    public void updateStatus(String status, String shippingAddress) {
        this.status = status;
        this.shippingAddress = shippingAddress;
    }

}

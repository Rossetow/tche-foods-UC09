package br.com.tchefoods.model;

public class OrderModel {

    private int id;
    private int userId;
    private int productId;
    private int paymentMethodId;
    private String dateTime;

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    private float total;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public float getTotal() {
        return total;
    }
}

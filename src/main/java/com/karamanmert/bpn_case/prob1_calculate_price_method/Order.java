package prob1_calculate_price_method;

import prob1_calculate_price_method.new1.ProductType;

import java.util.List;

public class Order {
    private List<ProductType> products;
    private String customerEmail;
    private String shippingAddress;
    private double price;

    public Order(List<ProductType> products, String customerEmail, String shippingAddress) {
        this.products = products;
        this.customerEmail = customerEmail;
        this.shippingAddress = shippingAddress;
    }

    public List<ProductType> getProducts() {
        return products;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

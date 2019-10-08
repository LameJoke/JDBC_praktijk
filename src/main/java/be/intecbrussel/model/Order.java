package be.intecbrussel.model;

import java.util.Date;

public class Order {

    private int orderId;
    private String status;
    private String date;
    private Customer customer;

    public Order() {
    }

    public Order(String status,String date, Customer customer) {
        this.status = status;
        this.date = date;
        this.customer = customer;
    }

    public Order(int id, String status, String date) {
    }

    public int getOrderId() {
        return orderId;
    }


    public Order setOrderId(int orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Order setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Order setDate(String date) {
        this.date = date;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", customer=" + customer +
                '}';
    }

    public String findByIdOrderString(){
        return "orderId=" + orderId +
                ", status='" + status + '\'' +
                ", date=" + date;
    }
}

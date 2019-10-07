package be.intecbrussel.model;

public class Product {

    private int productId;
    private int code;
    private String name;
    private double price;

    public Product() {

    }
    public Product(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }


    public int getProductId() {
        return productId;
    }

    public Product setProductId(int productId) {
        this.productId = productId;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Product setCode(int code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String findbyIdProductString(){
        return   ", code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price;
    }
}

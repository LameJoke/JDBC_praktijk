package be.intecbrussel.service.interfaces;

import be.intecbrussel.model.Product;

import java.sql.SQLException;

public interface ProductService {

    void createProduct (Product product) throws SQLException;

    void updateProduct(Product product) throws SQLException;

    void deleteProduct (int id) throws SQLException;

    Product getProduct(int id) throws SQLException;
}

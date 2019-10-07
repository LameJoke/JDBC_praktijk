package be.intecbrussel.dao.daoInterfaces;

import be.intecbrussel.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {

    void createProduct (Product product) throws SQLException;

    void updateProduct(Product product) throws SQLException;

    void deleteProduct (int id) throws SQLException;

    Product getProduct(int id) throws SQLException;
}

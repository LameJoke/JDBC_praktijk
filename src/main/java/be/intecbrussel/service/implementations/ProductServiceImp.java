package be.intecbrussel.service.implementations;

import be.intecbrussel.dao.daoImplementations.ProductDaoImpl;
import be.intecbrussel.dao.daoInterfaces.ProductDao;
import be.intecbrussel.model.Product;
import be.intecbrussel.service.interfaces.ProductService;

import java.sql.SQLException;

public class ProductServiceImp implements ProductService{

    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public void createProduct(Product product) throws SQLException {
        productDao.createProduct(product);
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        productDao.updateProduct(product);
    }

    @Override
    public void deleteProduct(int id) throws SQLException {
        productDao.deleteProduct(id);
    }

    @Override
    public Product getProduct(int id) throws SQLException {
        return productDao.getProduct(id);
    }
}

package be.intecbrussel.dao.daoImplementations;

import be.intecbrussel.dao.ConnectionProvider;
import be.intecbrussel.dao.daoInterfaces.ProductDao;
import be.intecbrussel.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDaoImpl implements ProductDao {

    private Connection createConnection(){
        return ConnectionProvider.getInstance().getConnection();
    }

    @Override
    public void createProduct(Product product) throws SQLException {

        try(PreparedStatement preparedStatement = createConnection()
                .prepareStatement("INSERT INTO product(code, name, price) VALUES (?,?,?)")){
            preparedStatement.setInt(1,product.getCode());
            preparedStatement.setString(2,product.getName());
            preparedStatement.setDouble(3,product.getPrice());
            preparedStatement.execute();
        }
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        try(PreparedStatement preparedStatement = createConnection().prepareStatement("UPDATE product SET price WHERE product_id=?")){
            preparedStatement.setDouble(1, product.getPrice());
            preparedStatement.setInt(2,product.getProductId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void deleteProduct(int id) throws SQLException {
        try(PreparedStatement preparedStatement = createConnection().prepareStatement("DELETE FROM product WHERE product_id=?")){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Product getProduct(int id) throws SQLException {
        Product product;
        try(PreparedStatement preparedStatement = createConnection().prepareStatement("SELECT * FROM product WHERE product_id=?")){
            preparedStatement.setInt(1,id);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                product = new Product();
                if(resultSet.next()){
                    product.setProductId(resultSet.getInt("product_id"));
                    product.setCode(resultSet.getInt("code"));
                    product.setName(resultSet.getString("name"));
                    product.setPrice(resultSet.getDouble("price"));
                }
            }
        }
        return product;
    }
}

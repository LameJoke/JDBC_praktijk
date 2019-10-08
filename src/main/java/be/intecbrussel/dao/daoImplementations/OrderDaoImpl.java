package be.intecbrussel.dao.daoImplementations;

import be.intecbrussel.dao.ConnectionProvider;
import be.intecbrussel.dao.daoInterfaces.OrderDao;
import be.intecbrussel.model.Customer;
import be.intecbrussel.model.Order;
import be.intecbrussel.model.OrderItem;
import be.intecbrussel.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private CustomerDaoImpl customerDao = new CustomerDaoImpl();

    private Connection createConnection(){
        return ConnectionProvider.getInstance().getConnection();
    }


    @Override
    public Order createOrder(Order order) throws SQLException {
        try(PreparedStatement statement = createConnection()
                .prepareStatement("INSERT INTO order(status,creation_date, customer_id) " +
                "VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1,order.getStatus());
            statement.setString(2, order.getDate());
            statement.setInt(3,order.getCustomer().getCustomerId());
            statement.execute();

            try(ResultSet resultSet = statement.getGeneratedKeys()){
                if(resultSet.next()){
                    int id = resultSet.getInt(1);
                    return new Order(id, order.getStatus(),order.getDate(),order.getCustomer());
                }else{
                    return null;
                }
            }
        }
    }

    @Override
    public List<Order> readOrderByCustomerId(int customerId) throws SQLException {
        List<Order> orders = new ArrayList<>();
        try(PreparedStatement preparedStatement = createConnection().prepareStatement("SELECT * FROM order WHERE customer_id=?")){
            preparedStatement.setInt(1, customerId);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    Order order = new Order();
                    order.setStatus(resultSet.getString("status"));
                    order.setDate(resultSet.getString("creation_date"));
                    order.setCustomer(customerDao.getCustomer(customerId));
                    orders.add(order);
                }
            }
        }
        return orders;
    }

    @Override
    public void updateOrder(Order order) throws SQLException {
        try(PreparedStatement preparedStatement = createConnection().prepareStatement("UPDATE order SET status=? WHERE order_id=?")){
            preparedStatement.setString(1,order.getStatus());
            preparedStatement.setInt(2,order.getOrderId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void deleteOrder(int orderId) throws SQLException {
        try(PreparedStatement preparedStatement = createConnection().prepareStatement("DELETE FROM order WHERE order_id=?")){
            preparedStatement.setInt(1, orderId);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Order createAndReturnOrder(Order order) throws SQLException {
        try (PreparedStatement preparedStatement = createConnection().prepareStatement("INSERT INTO order(status,creation_date,customer_id)" +
                "VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, order.getStatus());
            preparedStatement.setDate(2,new java.sql.Date(new java.util.Date().getTime()));
            preparedStatement.setInt(3, order.getCustomer().getCustomerId());
            preparedStatement.executeUpdate();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    return new Order(id, order.getStatus(), order.getDate());
                } else {
                    return null;
                }
            }
        }
    }


    @Override
    public Order findById(int orderId) throws SQLException {
       Order order = null;
//       Customer customer;
//       Product product;
        try(PreparedStatement preparedStatement = createConnection().prepareStatement("SELECT * FROM order WHERE order_id=?")){
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                order = new Order();
//                customer = new Customer();
//                product = new Product();
                order.getCustomer().setCustomerId(resultSet.getInt("customer_id"));
                order.setStatus(resultSet.getString(resultSet.getString("status")));
                order.setOrderId(resultSet.getInt(resultSet.getInt("order_id")));

            }
        }
        return order;
    }
}

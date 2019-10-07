package be.intecbrussel.service.interfaces;

import be.intecbrussel.model.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {

    void createOrder (Order order) throws SQLException;

    List<Order> readOrderByCustomerId (int customerId) throws SQLException;

    void updateOrder (Order order) throws SQLException;

    void deleteOrder (int orderId) throws SQLException;

    Order createAndReturnOrder (Order order) throws SQLException;

    Order findById( int orderId) throws SQLException;
}

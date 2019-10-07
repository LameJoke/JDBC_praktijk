package be.intecbrussel.service.interfaces;

import be.intecbrussel.model.OrderItem;

import java.sql.SQLException;

public interface OrderItemService {

    void createOrderItem(OrderItem orderItem) throws SQLException;

    void updateOrderItem (OrderItem orderItem) throws SQLException;

    void deleteOrderItem (OrderItem orderItem) throws SQLException;

    OrderItem createAndReturnOrderItem (OrderItem orderItem) throws SQLException;
}

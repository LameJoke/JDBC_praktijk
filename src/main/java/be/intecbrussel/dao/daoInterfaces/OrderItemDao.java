package be.intecbrussel.dao.daoInterfaces;

import be.intecbrussel.model.OrderItem;

import java.sql.SQLException;
import java.util.List;

public interface OrderItemDao {

    void createOrderItem(OrderItem orderItem) throws SQLException;

    void updateOrderItem (OrderItem orderItem) throws SQLException;

    void deleteOrderItem (OrderItem orderItem) throws SQLException;

    OrderItem createAndReturnOrderItem (OrderItem orderItem) throws SQLException;

}

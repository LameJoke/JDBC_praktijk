package be.intecbrussel.service.implementations;


import be.intecbrussel.dao.daoImplementations.OrderItemDaoImpl;
import be.intecbrussel.dao.daoInterfaces.OrderItemDao;
import be.intecbrussel.model.OrderItem;
import be.intecbrussel.service.interfaces.OrderItemService;

import java.sql.SQLException;

public class OrderItemServiceImp implements OrderItemService {

    private OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Override
    public void createOrderItem(OrderItem orderItem) throws SQLException {
        orderItemDao.createOrderItem(orderItem);
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) throws SQLException {
        orderItemDao.updateOrderItem(orderItem);
    }

    @Override
    public void deleteOrderItem(OrderItem orderItem) throws SQLException {
        orderItemDao.deleteOrderItem(orderItem);
    }

    @Override
    public OrderItem createAndReturnOrderItem(OrderItem orderItem) throws SQLException {
        return orderItemDao.createAndReturnOrderItem(orderItem);
    }
}

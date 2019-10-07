package be.intecbrussel.service.implementations;


import be.intecbrussel.dao.daoImplementations.OrderDaoImpl;
import be.intecbrussel.dao.daoInterfaces.OrderDao;
import be.intecbrussel.model.Order;
import be.intecbrussel.service.interfaces.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImp implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public void createOrder(Order order) throws SQLException {
        orderDao.createOrder(order);
    }

    @Override
    public List<Order> readOrderByCustomerId(int customerId) throws SQLException {
        return orderDao.readOrderByCustomerId(customerId);
    }

    @Override
    public void updateOrder(Order order) throws SQLException {
        orderDao.updateOrder(order);
    }

    @Override
    public void deleteOrder(int orderId) throws SQLException {
        orderDao.deleteOrder(orderId);
    }

    @Override
    public Order createAndReturnOrder(Order order) throws SQLException {
        return orderDao.createAndReturnOrder(order);
    }

    @Override
    public Order findById(int orderId) throws SQLException {
        return orderDao.findById(orderId);
    }
}




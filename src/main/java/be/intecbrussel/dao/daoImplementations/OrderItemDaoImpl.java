package be.intecbrussel.dao.daoImplementations;

import be.intecbrussel.dao.ConnectionProvider;
import be.intecbrussel.dao.daoInterfaces.OrderItemDao;
import be.intecbrussel.model.Order;
import be.intecbrussel.model.OrderItem;

import java.sql.*;

public class OrderItemDaoImpl implements OrderItemDao {

    private OrderDaoImpl orderDao = new OrderDaoImpl();

    private Connection createConnection(){
        return ConnectionProvider.getInstance().getConnection();
    }

    @Override
    public void createOrderItem(OrderItem orderItem) throws SQLException {
        try(PreparedStatement preparedStatement = createConnection()
                .prepareStatement("INSERT INTO order_item(order_id,product_id, quantity) " +
                        "VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setInt(1, orderItem.getOrder().getOrderId());
            preparedStatement.setInt(2,orderItem.getProduct().getProductId());
            preparedStatement.setInt(3,orderItem.getQuantity());
            preparedStatement.execute();
        }
    }

        @Override
    public void updateOrderItem(OrderItem orderItem) throws SQLException {
        try(PreparedStatement preparedStatement = createConnection()
                .prepareStatement("UPDATE order_item SET quantity =? WHERE order_id=?")){
            preparedStatement.setInt(1, orderItem.getQuantity());
            preparedStatement.setInt(2, orderItem.getOrderItemId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void deleteOrderItem(OrderItem orderItem) throws SQLException {
        try(PreparedStatement preparedStatement = createConnection()
                .prepareStatement("DELETE FROM order_item WHERE order_id=?")){
            preparedStatement.setInt(1,orderItem.getOrderItemId());
            preparedStatement.executeUpdate();
        }

    }

    @Override
    public OrderItem createAndReturnOrderItem(OrderItem orderItem) throws SQLException {
        return null;
    }

/*    @Override
    public OrderItem createAndReturnOrderItem(OrderItem orderItem) throws SQLException {
        try(PreparedStatement preparedStatement = createConnection().prepareStatement("INSERT INTO order_item(order_id, product_id, quantity) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setInt(1,orderItem.getOrderItemId());
            preparedStatement.setInt(2,orderItem.getProduct().getProductId());
            preparedStatement.setInt(3,orderItem.getQuantity());
            preparedStatement.executeUpdate();

            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                if(resultSet.next()){
                    int id = resultSet.getInt(1);
                    return  new OrderItem(orderItem.getOrderItemId(),orderItem.getProduct().getProductId(), orderItem.getQuantity());
                }else{
                    return null;
                }
            }
        }

    }*/
}

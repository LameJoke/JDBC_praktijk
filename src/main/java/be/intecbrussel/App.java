package be.intecbrussel;

import be.intecbrussel.model.Customer;
import be.intecbrussel.model.Order;
import be.intecbrussel.model.OrderItem;
import be.intecbrussel.service.implementations.CustomerServiceImp;
import be.intecbrussel.service.implementations.OrderItemServiceImp;
import be.intecbrussel.service.implementations.OrderServiceImp;
import be.intecbrussel.service.interfaces.CustomerService;
import be.intecbrussel.service.interfaces.OrderItemService;
import be.intecbrussel.service.interfaces.OrderService;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) {


        CustomerService customerService = new CustomerServiceImp();
        OrderService orderService = new OrderServiceImp();
        OrderItemService orderItemService = new OrderItemServiceImp();

        Customer cust1 = new Customer("John", "Doe", "john@doe.com", "0123456789", "Sesamestreet 123", "MuppetLand", 3150);
        Customer cust2 = new Customer("Jane", "Doe", "jane@doe.com", "0123456789", "Sesamestreet 123", "MuppetLand", 3150);
        Customer cust3 = new Customer("Jacky", "Doe", "john@doe.com", "0123456789", "Sesamestreet 123", "MuppetLand", 3150);
        Customer cust4 = new Customer("James", "Doe", "john@doe.com", "0123456789", "Sesamestreet 123", "MuppetLand", 3150);

        cust1.getCustomerId();

        OrderItem orderItem1 = new OrderItem();

        Order ord1 = new Order("Ready for take off",cust1);
        Order ord2 = new Order("Getting ready", cust2);

        try {
            customerService.deleteCustomer(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

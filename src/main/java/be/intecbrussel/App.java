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

        Customer cust1 = new Customer("John", "Doe", "john@doe.com", "0123456789", "Sesamestreet 123", "MuppetLand", 3150);
        Customer cust2 = new Customer("Jane", "Doe", "jane@doe.com", "0123456789", "Sesamestreet 123", "MuppetLand", 3150);
        Customer cust3 = new Customer("Jacky", "Doe", "john@doe.com", "0123456789", "Sesamestreet 123", "MuppetLand", 3150);
        Customer cust4 = new Customer("James", "Doe", "john@doe.com", "0123456789", "Sesamestreet 123", "MuppetLand", 3150);

        try {
            customerService.createCustomer(cust1);
            customerService.createCustomer(cust2);
            customerService.createCustomer(cust3);
            customerService.createCustomer(cust4);
        } catch (SQLException e) {
            e.printStackTrace();
        }



        OrderItem orderItem1 = new OrderItem();

        Order ord1 = new Order("Ready for take off",2019/10/07,cust1);


        try {
            orderService.createOrder(ord1);
            orderService.createOrder(ord2);
        } catch (SQLException e) {
            e.printStackTrace();
        }


//        try {
//            customerService.deleteCustomer(1);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

}

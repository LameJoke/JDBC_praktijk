package be.intecbrussel.service.interfaces;

import be.intecbrussel.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {


    void createCustomer(Customer customer) throws SQLException;

    List<Customer> readCustomer() throws SQLException;

    void updateCustomer(Customer customer) throws SQLException;

    void  deleteCustomer (int id) throws SQLException;

    Customer getCustomer (int id) throws SQLException;
}

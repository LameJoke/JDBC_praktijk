package be.intecbrussel.service.implementations;

import be.intecbrussel.dao.daoImplementations.CustomerDaoImpl;
import be.intecbrussel.dao.daoInterfaces.CustomerDao;
import be.intecbrussel.model.Customer;
import be.intecbrussel.service.interfaces.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImp implements CustomerService {

    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public void createCustomer(Customer customer) throws SQLException {
        customerDao.createCustomer(customer);
    }

    @Override
    public List<Customer> readCustomer() throws SQLException {
        return customerDao.readCustomer();
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        customerDao.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(int id) throws SQLException {
        customerDao.deleteCustomer(id);
    }

    @Override
    public Customer getCustomer(int id) throws SQLException {
        return customerDao.getCustomer(id);
    }
}

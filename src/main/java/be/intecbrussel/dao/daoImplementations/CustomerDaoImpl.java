package be.intecbrussel.dao.daoImplementations;

import be.intecbrussel.dao.ConnectionProvider;
import be.intecbrussel.dao.daoInterfaces.CustomerDao;
import be.intecbrussel.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    public Connection createConnection() throws SQLException{
        return ConnectionProvider.getInstance().getConnection();
    }


    @Override
    public void createCustomer(Customer customer) throws SQLException {
        try(PreparedStatement statement = createConnection()
                .prepareStatement("INSERT INTO customer(firstName, lastName, email, phone, address, city, zipcode )" +
                        "VALUES (?,?,?,?,?,?,?)")){
            statement.setString(1,customer.getFirstName());
            statement.setString(2,customer.getLastName());
            statement.setString(3,customer.getEmail());
            statement.setString(4,customer.getPhone());
            statement.setString(5,customer.getAddress());
            statement.setString(6,customer.getCity());
            statement.setInt(7,customer.getZipcode());
            statement.execute();
        }
    }

    @Override
    public List<Customer> readCustomer() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try(PreparedStatement preparedStatement = createConnection().prepareStatement("SELECT * FROM customer")){
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    Customer customer = new Customer();
                    customer.setFirstName(resultSet.getString("firstName"));
                    customer.setLastName(resultSet.getString("lastName"));
                    customer.setEmail(resultSet.getString("email"));
                    customer.setPhone(resultSet.getString("phone"));
                    customer.setAddress(resultSet.getString("address"));
                    customer.setCity(resultSet.getString("city"));
                    customer.setZipcode(resultSet.getInt("zipcode"));
                    customers.add(customer);
                }
            }
        }
        return customers;
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
       try(PreparedStatement preparedStatement = createConnection().prepareStatement("UPDATE customer SET address=? WHERE customer_id=?")){
           preparedStatement.setString(1,customer.getAddress());
           preparedStatement.setInt(2,customer.getCustomerId());
       }
    }

    @Override
    public void deleteCustomer(int id) throws SQLException {
        try(PreparedStatement preparedStatement = createConnection().prepareStatement("DELETE FROM customer WHERE customer_id=?")){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Customer getCustomer(int id) throws SQLException {
        Customer customer;
        try(PreparedStatement preparedStatement = createConnection().prepareStatement("SELECT * FROM customer where customer_id=?")){
            preparedStatement.setInt(1,id);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                customer = new Customer();
                if(resultSet.next()){
                    customer.setCustomerId(resultSet.getInt("customer_id"));
                    customer.setFirstName(resultSet.getString("firstName"));
                    customer.setLastName(resultSet.getString("lastName"));
                    customer.setEmail(resultSet.getString("email"));
                    customer.setPhone(resultSet.getString("phone"));
                    customer.setAddress(resultSet.getString("address"));
                    customer.setCity(resultSet.getString("city"));
                    customer.setZipcode(resultSet.getInt("zipcode"));

                }
            }
        }
        return customer;
    }
}

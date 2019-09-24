package main.repository;

import main.model.Customer;

import java.util.List;

public interface CustomerRepo {

    List<Customer> getAllCustomers();

    Customer getCustomer(Long id);

    void addCustomer(Customer customer);

    void updateCustomer(Customer customer, Long id);

    void deleteCustomer(Long id);
}

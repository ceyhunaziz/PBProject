package main.service;

import main.model.Customer;
import main.repository.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {


    private CustomerRepo customerRepo = new CustomerRepo();

    public List<Customer> getAllCustomers(){
        return customerRepo.getAllCustomers();
    }

    public Customer getCustomer(Long id) {
        return customerRepo.getCustomer(id);
    }

    public void addCustomer(Customer customer) {
        customerRepo.addCustomer(customer);
    }


    public void updateCustomer(Customer customer, Long id) {
        customerRepo.updateCustomer(customer,id);
    }

    public void deleteCustomer(Long id) {
        customerRepo.deleteCustomer(id);
    }
}

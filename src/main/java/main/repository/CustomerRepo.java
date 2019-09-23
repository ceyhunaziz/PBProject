package main.repository;


import main.model.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerRepo {
    List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1L,"Ceyhun"),
            new Customer(2L,"Yusif"),
            new Customer(3L,"Mufasa")
    ));

    public List<Customer> getAllCustomers(){
        return customers;
    }

    public Customer getCustomer(Long id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }


    public void updateCustomer(Customer customer, Long id) {
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId() == id){
                customers.set(i,customer);
            }
        }
    }

    public void deleteCustomer(Long id) {
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId() == id){
                customers.remove(i);
                i--;
            }
        }
    }
}

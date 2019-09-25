package main.repository;

import main.controller.CustomerController;
import main.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
@Profile("dev")
public class CustomerRepoDev implements CustomerRepo {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1L,"Ceyhun Azizov"),
            new Customer(2L,"Simba Shukurov"),
            new Customer(3L,"Mufasa Rashidov")
    ));

    public List<Customer> getAllCustomers(){
        return customers;
    }

    public Customer getCustomer(Long id) {
        logger.info("CustomerRepoDev/getCustomer.start");
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                logger.info("CustomerRepoDev/getCustomer.end");
                return customer;
            }
        }
        logger.info("CustomerRepoDev/getCustomer.end");
        return null;
    }

    public void addCustomer(Customer customer) {
        logger.info("CustomerRepoDev/addCustomer.start");
        customers.add(customer);
        logger.info("CustomerRepoDev/addCustomer.end");
    }


    public void updateCustomer(Customer customer, Long id) {
        logger.info("CustomerRepoDev/updateCustomer.start");
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId().equals(id)){
                customers.set(i,customer);
            }
        }
        logger.info("CustomerRepoDev/updateCustomer.end");
    }

    public void deleteCustomer(Long id) {
        logger.info("CustomerRepoDev/deleteCustomer.start");
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId().equals(id)){
                customers.remove(i);
                i--;
            }
        }
        logger.info("CustomerRepoDev/deleteCustomer.end");
    }
}

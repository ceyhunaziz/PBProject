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
@Profile("prod")
public class CustomerRepoProd implements CustomerRepo {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1L,"Ceyhun"),
            new Customer(2L,"Simba"),
            new Customer(3L,"Mufasa")
    ));


    public List<Customer> getAllCustomers() {
        logger.info("CustomerRepoProd/getAllCustomers.start");
        logger.info("CustomerRepoProd/getAllCustomers.end");
        return customers;
    }

    public Customer getCustomer(Long id) {
        logger.info("CustomerRepoProd/getCustomer.start");
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                logger.info("CustomerRepoProd/getCustomer.end");
                return customer;
            }
        }
        logger.info("CustomerRepoProd/getCustomer.end");
        return null;
    }

    public void addCustomer(Customer customer) {
        logger.info("CustomerRepoProd/addCustomer.start");
        customers.add(customer);
        logger.info("CustomerRepoProd/addCustomer.end");
    }


    public void updateCustomer(Customer customer, Long id) {
        logger.info("CustomerRepoProd/updateCustomer.start");
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId() == id){
                customers.set(i,customer);
            }
        }
        logger.info("CustomerRepoProd/updateCustomer.end");
    }

    public void deleteCustomer(Long id) {
        logger.info("CustomerRepoProd/deleteCustomer.start");
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId() == id){
                customers.remove(i);
                i--;
            }
        }
        logger.info("CustomerRepoProd/deleteCustomer.end");
    }
}

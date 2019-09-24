package main.repository;

import main.controller.CustomerController;
import main.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
@Profile("dev")
public class CustomerRepoDev implements CustomerRepo {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1L,"CeyhunDev"),
            new Customer(2L,"YusifDev"),
            new Customer(3L,"MufasaDev")
    ));

    public List<Customer> getAllCustomers(){
        logger.info("getCustomer.start");
        logger.info("getCustomer.end");
        return customers;
    }

    public Customer getCustomer(Long id) {
        logger.info("getCustomer.start");
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                logger.info("getCustomer.end");
                return customer;
            }
        }
        logger.info("getCustomer.end");
        return null;
    }

    public void addCustomer(Customer customer) {
        logger.info("getCustomer.start");
        customers.add(customer);
        logger.info("getCustomer.end");
    }


    public void updateCustomer(Customer customer, Long id) {
        logger.info("getCustomer.start");
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId() == id){
                customers.set(i,customer);
            }
        }
        logger.info("getCustomer.end");
    }

    public void deleteCustomer(Long id) {
        logger.info("getCustomer.start");
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId() == id){
                customers.remove(i);
                i--;
            }
        }
        logger.info("getCustomer.end");
    }
}

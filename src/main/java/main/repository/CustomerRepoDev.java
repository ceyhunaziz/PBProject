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
            new Customer(2L,"SimbaDev"),
            new Customer(3L,"MufasaDev")
    ));

    public List<Customer> getAllCustomers(){
        logger.info("CustomerRepoDev/getAllCustomers.start");
        logger.info("CustomerRepoDev/getAllCustomers.end");
        return customers;
    }

    public Customer getCustomer(Long id) {
        logger.info("CustomerRepoDev/getCustomer.start");
        for (Customer customer : customers) {
            if (customer.getId() == id) {
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
            if(customers.get(i).getId() == id){
                customers.set(i,customer);
            }
        }
        logger.info("CustomerRepoDev/updateCustomer.end");
    }

    public void deleteCustomer(Long id) {
        logger.info("CustomerRepoDev/deleteCustomer.start");
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId() == id){
                customers.remove(i);
                i--;
            }
        }
        logger.info("CustomerRepoDev/deleteCustomer.end");
    }
}

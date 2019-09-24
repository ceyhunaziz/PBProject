package main.service;

import main.controller.CustomerController;
import main.model.Customer;
import main.repository.CustomerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getAllCustomers(){
        logger.info("getCustomer.start");
        logger.info("getCustomer.end");
        return customerRepo.getAllCustomers();
    }

    public Customer getCustomer(Long id) {
        logger.info("getCustomer.start");
        logger.info("getCustomer.end");
        return customerRepo.getCustomer(id);
    }

    public void addCustomer(Customer customer) {
        logger.info("getCustomer.start");
        customerRepo.addCustomer(customer);
        logger.info("getCustomer.end");
    }


    public void updateCustomer(Customer customer, Long id) {
        logger.info("getCustomer.start");
        customerRepo.updateCustomer(customer,id);
        logger.info("getCustomer.end");
    }

    public void deleteCustomer(Long id) {
        logger.info("getCustomer.start");
        customerRepo.deleteCustomer(id);
        logger.info("getCustomer.end");
    }

}

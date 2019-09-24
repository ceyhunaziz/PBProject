package main.controller;//

import main.model.Customer;
import main.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public List<Customer> getAllCustomers(){
        logger.info("CustomerController/getAllCustomers.start");
        List<Customer> result = customerService.getAllCustomers();
        logger.info("CustomerController/getAllCustomers.end");
        return result;
    }

    @RequestMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable Long id){
        logger.info("CustomerController/getCustomer.start");
        Customer result = customerService.getCustomer(id);
        logger.info("CustomerController/getCustomer.end");
        return result;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customers")
    public void addCustomer(@RequestBody Customer customer){
        logger.info("CustomerController/addCustomer.start");
        customerService.addCustomer(customer);
        logger.info("CustomerController/addCustomer.end");
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/customers/{id}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable Long id){
        logger.info("CustomerController/updateCustomer.start");
        customerService.updateCustomer(customer,id);
        logger.info("CustomerController/updateCustomer.end");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/customers/{id}")
    public void deleteCustomer(@PathVariable Long id){
        logger.info("CustomerController/deleteCustomer.start");
        customerService.deleteCustomer(id);
        logger.info("CustomerController/deleteCustomer.end");
    }
}

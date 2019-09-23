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
        logger.info("getCustomer.start");
        List<Customer> result = customerService.getAllCustomers();
        logger.info("getCustomer.end");
        return result;
    }

    @RequestMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable Long id){
        logger.info("getCustomer.start");
        Customer result = customerService.getCustomer(id);
        logger.info("getCustomer.end");
        return result;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customers")
    public void addCustomer(@RequestBody Customer customer){
        logger.info("getCustomer.start");
        customerService.addCustomer(customer);
        logger.info("getCustomer.end");
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/customers/{id}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable Long id){
        logger.info("getCustomer.start");
        customerService.updateCustomer(customer,id);
        logger.info("getCustomer.end");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/customers/{id}")
    public void deleteCustomer(@PathVariable Long id){
        logger.info("getCustomer.start");
        customerService.deleteCustomer(id);
        logger.info("getCustomer.end");
    }
}

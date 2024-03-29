package main.controller;//

import main.model.Customer;
import main.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/customers")
@Validated
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<Customer> getAllCustomers(){
        logger.info("CustomerController/getAllCustomers.start");
        List<Customer> result = customerService.getAllCustomers();
        logger.info("CustomerController/getAllCustomers.end");
        return result;
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") @Min(1) Long id){
        logger.info("CustomerController/getCustomer.start");
        Customer result = customerService.getCustomer(id);
        logger.info("CustomerController/getCustomer.end");
        return result;
    }

    @PostMapping(value = "/")
    public void addCustomer(@Valid @RequestBody Customer customer){
        logger.info("CustomerController/addCustomer.start");
        customerService.addCustomer(customer);
        logger.info("CustomerController/addCustomer.end");
    }

    @PutMapping(value = "/{id}")
    public void updateCustomer(@Valid @RequestBody Customer customer, @PathVariable("id") @Min(1) Long id){
        logger.info("CustomerController/updateCustomer.start");
        customerService.updateCustomer(customer,id);
        logger.info("CustomerController/updateCustomer.end");
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCustomer(@PathVariable("id") @Min(1) Long id){
        logger.info("CustomerController/deleteCustomer.start");
        customerService.deleteCustomer(id);
        logger.info("CustomerController/deleteCustomer.end");
    }
}

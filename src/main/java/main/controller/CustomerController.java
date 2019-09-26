package main.controller;//

import main.dao.Customer;
import main.model.dto.CustomerDto;
import main.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

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
    public List<CustomerDto> getAllCustomers(){
        logger.info("CustomerController/getAllCustomers.start");
        List<CustomerDto> result = customerService.getAllCustomers();
        logger.info("CustomerController/getAllCustomers.end");
        return result;
    }

    @GetMapping("/{id}")
    public Optional<CustomerDto> getCustomer(@PathVariable("id") @Min(1) Long id){
        logger.info("CustomerController/getCustomer.start");
        Optional<CustomerDto> result = Optional.ofNullable(customerService.getCustomer(id));
        logger.info("CustomerController/getCustomer.end");
        return result;
    }

    @PostMapping(value = "/")
    public Customer addCustomer(@Valid @RequestBody CustomerDto customer){
        logger.info("CustomerController/addCustomer.start");
        Customer result = customerService.addCustomer(customer);
        logger.info("CustomerController/addCustomer.end");
        return result;
    }

    @PutMapping(value = "/{id}")
    public void updateCustomer(@Valid @RequestBody CustomerDto customer, @PathVariable("id") @Min(1) Long id){
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

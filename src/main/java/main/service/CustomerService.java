package main.service;

import main.controller.CustomerController;
import main.dao.Customer;
import main.dao.CustomerRepo;
import main.mapper.Mapper;
import main.model.dto.CustomerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private Mapper mapper = new Mapper();

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<CustomerDto> getAllCustomers(){
        List<CustomerDto> result = mapper.mapperListEntityToDto(customerRepo.findAll());
        logger.info("CustomerService/getAllCustomers.end");
        return result;
    }

    public Customer addCustomer(CustomerDto customer) {
        logger.info("CustomerService/addCustomer.start");
        Customer result = mapper.mapperDtoToEntity(customer);
        customerRepo.save(result);
        logger.info("CustomerService/addCustomer.end");
        return result;
    }

    public CustomerDto getCustomer(Long id) {
        Optional<Customer> result = customerRepo.findById(id);
        logger.info("CustomerService/getCustomer.end");
        return mapper.mapperEntityToDto(result.get());
    }

    public void updateCustomer(CustomerDto customer, Long id) {
        logger.info("CustomerService/updateCustomer.start");
        Customer cust = mapper.mapperDtoToEntity(customer);
        cust.setId(id);
        customerRepo.save(cust);
        logger.info("CustomerService/updateCustomer.end");
    }

    public void deleteCustomer(Long id) {
        logger.info("CustomerService/deleteCustomer.start");
        customerRepo.deleteById(id);
        logger.info("CustomerService/deleteCustomer.end");
    }
}

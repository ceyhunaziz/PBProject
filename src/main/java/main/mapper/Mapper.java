package main.mapper;

import main.dao.Customer;
import main.model.dto.CustomerDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Mapper {
    public Customer  mapperDtoToEntity(CustomerDto customerDto){
        Customer result = new Customer(customerDto.getName());
        return result;
    }

    public List<Customer> mapperListDtoToEntity(List<CustomerDto> customerDtos){
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < customerDtos.size(); i++) {
            customers.add(new Customer(customerDtos.get(i).getName()));
        }
        return customers;
    }

    public CustomerDto mapperEntityToDto(Customer customer){
        CustomerDto result = new CustomerDto(customer.getName());
        return result;
    }

    public List<CustomerDto> mapperListEntityToDto(List<Customer> customers){
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (int i = 0; i < customers.size(); i++) {
            customerDtos.add(new CustomerDto(customers.get(i).getName()));
        }
        return customerDtos;
    }
}

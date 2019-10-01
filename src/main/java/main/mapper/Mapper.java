package main.mapper;

import main.dao.model.CustomerEntity;
import main.model.dto.CustomerDto;

import java.util.ArrayList;
import java.util.List;


public class Mapper {
    public CustomerEntity mapperDtoToEntity(CustomerDto customerDto){
        CustomerEntity result = new CustomerEntity(customerDto.getName());
        return result;
    }

    public List<CustomerEntity> mapperListDtoToEntity(List<CustomerDto> customerDtos){
        List<CustomerEntity> customerEntities = new ArrayList<>();
        for (int i = 0; i < customerDtos.size(); i++) {
            customerEntities.add(new CustomerEntity(customerDtos.get(i).getName()));
        }
        return customerEntities;
    }

    public CustomerDto mapperEntityToDto(CustomerEntity customerEntity){
        CustomerDto result = new CustomerDto(customerEntity.getName());
        return result;
    }

    public List<CustomerDto> mapperListEntityToDto(List<CustomerEntity> customerEntities){
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (int i = 0; i < customerEntities.size(); i++) {
            customerDtos.add(new CustomerDto(customerEntities.get(i).getName()));
        }
        return customerDtos;
    }
}

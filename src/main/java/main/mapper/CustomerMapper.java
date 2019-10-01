package main.mapper;

import main.dao.model.CustomerEntity;
import main.model.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto entityToDto(CustomerEntity customerEntity);
    CustomerEntity dtoToEntity(CustomerDto customerDto);
}

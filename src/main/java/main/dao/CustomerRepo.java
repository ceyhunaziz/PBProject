package main.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepo extends CrudRepository<CustomerEntity,Long> {
    List<CustomerEntity> findAll();

    Optional<CustomerEntity> findById(Long id);
}

package main.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepo extends CrudRepository<Customer,Long> {
    List<Customer> findAll();

    Optional<Customer> findById(Long id);
}

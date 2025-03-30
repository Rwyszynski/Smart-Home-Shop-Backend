package com.kodilla.smarthomeshop.repository;

import org.springframework.data.repository.CrudRepository;
import com.kodilla.smarthomeshop.domain.Product;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Override
    List<Product> findAll();
}

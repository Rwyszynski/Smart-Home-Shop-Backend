package com.kodilla.smarthomeshop.repository;

import org.springframework.data.repository.CrudRepository;
import com.kodilla.smarthomeshop.domain.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Override
    List<Product> findAll();
}

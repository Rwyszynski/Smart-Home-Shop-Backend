package com.kodilla.smarthomeshop.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.kodilla.smarthomeshop.domain.Product;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT c from component c")
    List<Product> findAll(Pageable pageable);

    @Override
    Optional<Product> findById(Long id);

    @Override
    Product save(Product product);

    List<Product> findByType(String type);

    List<Product> findByBrandIgnoreCaseContainingOrModelIgnoreCaseContaining(String brand, String model);

}

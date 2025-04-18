package com.kodilla.smarthomeshop.repository;

import com.kodilla.smarthomeshop.domain.ProductList;
import com.kodilla.smarthomeshop.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProductListRepository extends CrudRepository<ProductList, Long> {

    @Override
    Optional<ProductList> findById(Long id);

    Optional<ProductList> findByUserIdAndIsActiveTrue(User userId);
}

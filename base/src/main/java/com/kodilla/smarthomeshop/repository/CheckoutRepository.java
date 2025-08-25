package com.kodilla.smarthomeshop.repository;

import com.kodilla.smarthomeshop.domain.Checkout;
import com.kodilla.smarthomeshop.domain.Product;
import com.kodilla.smarthomeshop.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CheckoutRepository extends CrudRepository<Checkout, Long> {

    @Query("SELECT c from checkout c")
    List<Checkout> findAll(Pageable pageable);

    @Override
    Optional<Checkout> findById(Long id);

    @Override
    Checkout save(Checkout checkout);

    Optional<Checkout> findByUserAndProductAndIsOrderedFalse(User user, Product product);

    List<Checkout> findByUser(User user);

    List<Checkout> findByIsOrdered(Boolean isOrdered);

    List<Checkout> findAll();
}

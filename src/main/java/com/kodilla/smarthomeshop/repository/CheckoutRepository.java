package com.kodilla.smarthomeshop.repository;

import com.kodilla.smarthomeshop.domain.Checkout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CheckoutRepository extends CrudRepository<Checkout, Long> {

    @Override
    List<Checkout> findAll();

    @Override
    Optional<Checkout> findById(Long id);

    @Override
    Checkout save(Checkout checkout);
}

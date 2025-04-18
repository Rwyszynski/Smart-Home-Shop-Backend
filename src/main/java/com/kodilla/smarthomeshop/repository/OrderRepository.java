package com.kodilla.smarthomeshop.repository;

import com.kodilla.smarthomeshop.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    @Override
    List<Order> findAll();

    @Override
    Optional<Order> findById(Long id);

    @Override
    Order save(Order order);
}

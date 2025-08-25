package com.kodilla.smarthomeshop.repository;

import com.kodilla.smarthomeshop.domain.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query("SELECT o from orders o")
    List<Order> findAll(Pageable pageable);

    @Override
    Optional<Order> findById(Long id);

    @Override
    Order save(Order order);

    @Query("SELECT o FROM orders o WHERE o.userId = :customerId")
    List<Order> findByCustomerId(@Param("customerId") Long customerId);
}

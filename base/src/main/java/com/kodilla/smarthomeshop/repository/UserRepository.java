package com.kodilla.smarthomeshop.repository;

import com.kodilla.smarthomeshop.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    List<User> findAll();

    @Override
    Optional<User> findById(Long id);

    @Override
    User save(User user);

    User findByEmail(String email);

    User findFirstByUserName(String userName);
}

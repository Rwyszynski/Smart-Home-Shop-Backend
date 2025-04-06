package com.kodilla.smarthomeshop.repository;

import com.kodilla.smarthomeshop.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {


    Role findByName(String user);
}

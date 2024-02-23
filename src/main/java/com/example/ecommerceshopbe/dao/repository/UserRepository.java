package com.example.ecommerceshopbe.dao.repository;

import com.example.ecommerceshopbe.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ecommerceshopbe.dao.model.Role;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    User findByRole(Role role);

    List<User> findAllByRole(Role role);

}

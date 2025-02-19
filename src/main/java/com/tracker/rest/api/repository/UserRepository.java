package com.tracker.rest.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tracker.rest.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // -----------
    boolean existsByUserName(String userName);

    boolean existsByUserEmail(String userEmail);

    Optional<User> findByUserEmailAndUserPassword(String userEmail, String userPassword);

    // Optional<User> findByUserEmail(String userEmail);

    void deleteByUserName(String userName);
}

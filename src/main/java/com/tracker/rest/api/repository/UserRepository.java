package com.tracker.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tracker.rest.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // -----------
    boolean existsByUserName(String userName);

    boolean existsByUserEmail(String userEmail);

    void deleteByUserName(String userName);
}

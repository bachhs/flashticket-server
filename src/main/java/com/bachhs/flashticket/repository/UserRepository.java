package com.bachhs.flashticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bachhs.flashticket.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    Boolean existsByEmail(String email);
}

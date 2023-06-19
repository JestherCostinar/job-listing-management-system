package com.jesthercostinar.joblisting.repository;

import com.jesthercostinar.joblisting.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

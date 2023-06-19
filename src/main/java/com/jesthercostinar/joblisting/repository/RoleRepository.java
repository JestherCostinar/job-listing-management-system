package com.jesthercostinar.joblisting.repository;

import com.jesthercostinar.joblisting.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

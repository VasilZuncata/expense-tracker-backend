package com.example.expensetracker.repository;

import com.example.expensetracker.entity.Role;
import com.example.expensetracker.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}

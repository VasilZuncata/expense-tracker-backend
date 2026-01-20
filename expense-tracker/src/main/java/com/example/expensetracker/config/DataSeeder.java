package com.example.expensetracker.config;

import org.springframework.stereotype.Component;

import com.example.expensetracker.entity.Role;
import com.example.expensetracker.entity.RoleName;
import com.example.expensetracker.repository.RoleRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DataSeeder {

    private final RoleRepository roleRepository;

    public DataSeeder(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void seedRoles() {
        if (roleRepository.count() == 0) {
            roleRepository.save(new Role(RoleName.USER));
            roleRepository.save(new Role(RoleName.ADMIN));
        }
    }
}

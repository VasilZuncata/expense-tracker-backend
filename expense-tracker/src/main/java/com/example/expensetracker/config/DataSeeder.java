package com.example.expensetracker.config;

import com.example.expensetracker.entity.Role;
import com.example.expensetracker.entity.RoleName;
import com.example.expensetracker.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public DataSeeder(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        roleRepository.findByName(RoleName.USER).orElseGet(() -> {
            Role r = new Role();
            r.setName(RoleName.USER);
            return roleRepository.save(r);
        });
    }
}

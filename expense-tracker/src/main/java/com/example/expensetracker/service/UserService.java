package com.example.expensetracker.service;

import org.springframework.stereotype.Service;

import com.example.expensetracker.dto.UserCreateRequest;
import com.example.expensetracker.entity.Role;
import com.example.expensetracker.entity.RoleName;
import com.example.expensetracker.entity.User;
import com.example.expensetracker.mapper.UserMapper;
import com.example.expensetracker.repository.RoleRepository;
import com.example.expensetracker.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User createUser(UserCreateRequest req) {
        User user = UserMapper.toEntity(req);

        Role role = roleRepository
                .findByName(RoleName.USER)
                .orElseThrow(() -> new RuntimeException("Role USER not found"));

        user.getRoles().add(role);

        return userRepository.save(user);
    }
}

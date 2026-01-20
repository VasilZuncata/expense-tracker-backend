package com.example.expensetracker.service;

import com.example.expensetracker.dto.UserCreateRequest;
import com.example.expensetracker.dto.UserResponse;
import com.example.expensetracker.entity.Role;
import com.example.expensetracker.entity.RoleName;
import com.example.expensetracker.entity.User;
import com.example.expensetracker.mapper.UserMapper;
import com.example.expensetracker.repository.RoleRepository;
import com.example.expensetracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.expensetracker.entity.RoleName;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserResponse createUser(UserCreateRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        User user = UserMapper.toEntity(request);

        // ✅ double-safety: roles да не е null
        if (user.getRoles() == null) {
            user.setRoles(new HashSet<>());
        }

        // ✅ default role USER
        Role userRole = roleRepository.findByName(RoleName.USER)

                .orElseThrow(() -> new RuntimeException("Role USER not found. Seed it first."));

        user.getRoles().add(userRole);

        User saved = userRepository.save(user);
        return UserMapper.toResponse(saved);
    }
}

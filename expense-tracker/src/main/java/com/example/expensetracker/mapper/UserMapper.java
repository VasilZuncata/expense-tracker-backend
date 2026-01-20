package com.example.expensetracker.mapper;

import com.example.expensetracker.dto.UserCreateRequest;
import com.example.expensetracker.dto.UserResponse;
import com.example.expensetracker.entity.User;

import java.util.stream.Collectors;

public class UserMapper {

    private UserMapper() {}

    public static User toEntity(UserCreateRequest req) {
        User u = new User();
        u.setUsername(req.getUsername());
        u.setEmail(req.getEmail());
        u.setPassword(req.getPassword());
        return u;
    }

    public static UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .roles(
                        user.getRoles()
                                .stream()
                                .map(r -> r.getName().name())
                                .collect(Collectors.toSet())
                )
                .build();
    }
}

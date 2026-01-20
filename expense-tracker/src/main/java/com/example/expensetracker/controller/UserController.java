package com.example.expensetracker.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expensetracker.dto.UserCreateRequest;
import com.example.expensetracker.dto.UserResponse;
import com.example.expensetracker.entity.User;
import com.example.expensetracker.mapper.UserMapper;
import com.example.expensetracker.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponse create(@RequestBody UserCreateRequest req) {
        User user = userService.createUser(req);   // service връща Entity
        return UserMapper.toResponse(user);         // mapper -> DTO
    }
}

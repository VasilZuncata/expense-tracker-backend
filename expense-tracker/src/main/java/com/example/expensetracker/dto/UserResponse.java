package com.example.expensetracker.dto;

import java.util.Set;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    private Long id;
    private String username;
    private String email;

    // ⬇️ ВАЖНО: String, не RoleName
    private Set<String> roles;
}

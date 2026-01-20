package com.example.expensetracker.dto;

import java.util.Set;

import com.example.expensetracker.entity.RoleName;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String username;
    private String email;

   
    private Set<RoleName> roles;
}

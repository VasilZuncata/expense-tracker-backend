package com.example.expensetracker.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.service.ExpenseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    public Expense create(
            @RequestParam Long userId,
            @RequestParam Long categoryId,
            @RequestParam BigDecimal amount
    ) {
        return expenseService.createExpense(userId, categoryId, amount);
    }

    @GetMapping("/user/{userId}")
    public List<Expense> byUser(@PathVariable Long userId) {
        return expenseService.getExpensesByUser(userId);
    }
}

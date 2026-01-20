package com.example.expensetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.expensetracker.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // ✅ ЗАДЪЛЖИТЕЛНО @Query (точки)
    @Query("SELECT e FROM Expense e WHERE e.user.id = :userId ORDER BY e.createdAt DESC")
    List<Expense> findAllByUserId(Long userId);

    @Query("SELECT e FROM Expense e WHERE e.category.name = :categoryName")
    List<Expense> findByCategoryName(String categoryName);
}

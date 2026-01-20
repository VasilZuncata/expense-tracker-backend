package com.example.expensetracker.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.expensetracker.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // ✅ @Query 1 – разходи по потребител
    @Query("SELECT e FROM Expense e WHERE e.user.id = :userId ORDER BY e.createdAt DESC")
    List<Expense> findAllByUserId(@Param("userId") Long userId);

    // ✅ @Query 2 – разходи по категория
    @Query("SELECT e FROM Expense e WHERE e.category.name = :categoryName")
    List<Expense> findByCategoryName(@Param("categoryName") String categoryName);

    // 🔥 BONUS @Query – разходи над сума
    @Query("SELECT e FROM Expense e WHERE e.amount > :amount")
    List<Expense> findExpensesWithAmountGreaterThan(@Param("amount") BigDecimal amount);
}

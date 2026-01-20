package com.example.expensetracker.service;

import org.springframework.stereotype.Service;

import com.example.expensetracker.dto.TagCreateRequest;
import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.entity.Tag;
import com.example.expensetracker.repository.ExpenseRepository;
import com.example.expensetracker.repository.TagRepository;

@Service
public class TagService {

    private final TagRepository tagRepository;
    private final ExpenseRepository expenseRepository;

    public TagService(TagRepository tagRepository, ExpenseRepository expenseRepository) {
        this.tagRepository = tagRepository;
        this.expenseRepository = expenseRepository;
    }

    public Tag create(TagCreateRequest request) {
        Tag tag = new Tag();
        tag.setName(request.getName());
        return tagRepository.save(tag);
    }

    // 🔥 ТОЗИ МЕТОД ЛИПСВАШЕ
    public void addTagToExpense(Long expenseId, String tagName) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        Tag tag = tagRepository.findByName(tagName)
                .orElseGet(() -> {
                    Tag newTag = new Tag();
                    newTag.setName(tagName);
                    return tagRepository.save(newTag);
                });

        expense.getTags().add(tag);
        expenseRepository.save(expense);
    }
}

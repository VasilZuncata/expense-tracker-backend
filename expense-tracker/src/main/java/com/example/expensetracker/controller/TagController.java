package com.example.expensetracker.controller;

import com.example.expensetracker.dto.TagCreateRequest;
import com.example.expensetracker.entity.Tag;
import com.example.expensetracker.service.TagService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tags")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public Tag create(@RequestBody TagCreateRequest request) {
        return tagService.create(request);
    }

    @PostMapping("/expense/{expenseId}")
    public void addTagToExpense(
            @PathVariable Long expenseId,
            @RequestParam String tagName
    ) {
        tagService.addTagToExpense(expenseId, tagName);
    }
}

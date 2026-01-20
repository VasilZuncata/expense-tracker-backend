package com.example.expensetracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expensetracker.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByName(String name);
}

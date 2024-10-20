package com.example.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myproject.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}

package com.example.myproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myproject.model.Author;
import com.example.myproject.repository.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Optional<Author> findById(Long authId) {
        return authorRepository.findById(authId);
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public void deleteById(Long authId) {
        authorRepository.deleteById(authId);
    }
}



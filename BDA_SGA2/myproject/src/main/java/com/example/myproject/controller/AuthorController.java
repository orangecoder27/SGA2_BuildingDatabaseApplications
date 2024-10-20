package com.example.myproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myproject.model.Author;
import com.example.myproject.repository.AuthorRepository;

@RestController
@RequestMapping("/api/authors")

public class AuthorController {

    private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/{authId}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long authId) {
        return authorRepository.findById(authId)
                .map(author -> ResponseEntity.ok().body(author))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        try {
            System.out.println("Creating book: " + author);
            logger.info("Creating book: {}", author);
            return authorRepository.save(author);
        } catch (Exception e) {
            logger.error("Error creating author", e);
            throw e; // Rethrow the exception after logging
        }
    }

    @PutMapping("/{authId}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long authId, @RequestBody Author authorDetails) {
        return authorRepository.findById(authId)
                .map(author -> {
                    // Use the title from bookDetails if it's not empty, otherwise retain the current title
                    if (authorDetails.getName() != null && !authorDetails.getName().isEmpty()) {
                        author.setName(authorDetails.getName());
                    }
                    ;
                    if (authorDetails.getCountry() != null && !authorDetails.getCountry().isEmpty()) {
                        author.setCountry(authorDetails.getCountry());
                    }
                    ;
                    if (authorDetails.getPublisher() != null && !authorDetails.getPublisher().isEmpty()) {
                        author.setPublisher(authorDetails.getPublisher());
                    }
                    ;

                    Author updatedAuthor = authorRepository.save(author);
                    return ResponseEntity.ok().body(updatedAuthor);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{authId}")
    public ResponseEntity<Object> deleteAuthor(@PathVariable Long authId) {
        return authorRepository.findById(authId)
                .map(author -> {
                    authorRepository.delete(author);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}




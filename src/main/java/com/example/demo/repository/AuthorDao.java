package com.example.demo.repository;

import com.example.demo.bean.Author;

import java.util.List;
import java.util.Optional;

/**
 * Author Mikorn vietnam
 * Created on 21-Mar-19.
 */

public class AuthorDao {
    private List<Author> authors;

    public AuthorDao(List<Author> authors) {
        this.authors = authors;
    }

    public Optional<Author> getAuthor (String id) {
        return authors.stream()
                .filter(author -> id.equals(author.getId()))
                .findFirst();
    }
}

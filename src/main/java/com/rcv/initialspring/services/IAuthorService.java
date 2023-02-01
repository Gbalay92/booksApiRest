package com.rcv.initialspring.services;

import java.util.List;

import com.rcv.initialspring.models.Author;

public interface IAuthorService {

    List<Author> findAll();

    Author saveAuthor(Author author);

    Author findAuthorById(Long id);

    Author updateAuthorById(Author author);

    void deleteAuthorById(Long id);
}

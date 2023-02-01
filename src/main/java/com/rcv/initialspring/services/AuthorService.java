package com.rcv.initialspring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcv.initialspring.models.Author;
import com.rcv.initialspring.repositories.AuthorRepository;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    AuthorRepository authorsRepo;

    @Override
    public List<Author> findAll() {
        return authorsRepo.findAll();
    }

    @Override
    public Author saveAuthor(Author author) {
        authorsRepo.save(author);
        return author;
    }

    @Override
    public Author findAuthorById(Long id) {
        Optional op = authorsRepo.findById(id);
        if (op.isPresent()) {
            return (Author) op.get();
        }
        return null;
    }

    @Override
    public Author updateAuthorById(Author author) {
        Optional op = authorsRepo.findById(author.getId());
        if (op.isPresent()) {
            return authorsRepo.save(author);
        }
        return null;
    }

    @Override
    public void deleteAuthorById(Long id) {
        authorsRepo.deleteById(id);
    }
}

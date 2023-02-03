package com.rcv.initialspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcv.initialspring.models.Author;
import com.rcv.initialspring.services.IAuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    IAuthorService authorService;

    @GetMapping("/")
    public List<Author> getAllAuthors() {
        return authorService.findAll();
    }

    @PostMapping("/")
    public Author saveAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }

    @GetMapping("/{id}") // de base la variable es String, hay que especificar en el metodo el tipo
    public Author getAuthorbyId(@PathVariable("id") Long id) {
        return authorService.findAuthorById(id);
    }

    @PutMapping("/")
    public Author updateAuthorById(@RequestBody Author author) {
        return authorService.updateAuthorById(author);
    }

    @DeleteMapping("/{id}")
    public String deleteAuthorById(@PathVariable Long id) {
        try {
            authorService.deleteAuthorById(id);
        } catch (EmptyResultDataAccessException e) {
            return "autor no encontrado";
        }

        return "autor borrado";
    }

    @PostMapping("/authorList")
    public List<Author> saveAuthorList(@RequestBody List<Author> authorList) {
        Iterable<Author> authors = authorList;
        return authorService.saveAuthorList(authors);
    }

}

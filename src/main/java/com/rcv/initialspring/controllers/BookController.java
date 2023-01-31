package com.rcv.initialspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcv.initialspring.models.Book;
import com.rcv.initialspring.repositories.BooksRepository;
import com.rcv.initialspring.services.IBookService;

@RestController
@RequestMapping("/")
public class BookController {

    @Autowired
    IBookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks(BooksRepository repository) {
        return bookService.findAll();
    }

    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }
}

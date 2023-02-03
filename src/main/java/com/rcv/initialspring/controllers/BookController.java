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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rcv.initialspring.models.Book;
import com.rcv.initialspring.repositories.BooksRepository;
import com.rcv.initialspring.services.IBookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    IBookService bookService;

    @GetMapping("/")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @PostMapping("/")
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/{id}") // de base la variable es String, hay que especificar en el metodo el tipo
    public Book getBookbyId(@PathVariable("id") Long id) {
        return bookService.findBookById(id);
    }

    @GetMapping("/example") // objeto example, es un objeto que contiene otro Object(book)
    public List<Book> getQueryParams(@RequestParam String category, int publisher) {
        Book book = new Book();
        book.setCategory(category);
        book.setPublisher(publisher);
        return bookService.finByExample(book);
    }

    @PutMapping("/")
    public Book updateBookById(@RequestBody Book book) {
        return bookService.updateBookById(book);
    }

    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable Long id) {
        try {
            bookService.deleteBookById(id);
        } catch (EmptyResultDataAccessException e) {
            return "autor no encontrado";
        }

        return "autor borrado";
    }

}

package com.rcv.initialspring.services;

import java.util.List;

import com.rcv.initialspring.models.Book;

public interface IBookService {

    List<Book> findAll();

    Book saveBook(Book book);

    Book findBookById(Long id);

    Book updateBookById(Book book);

    void deleteBookById(Long id);

    List<Book> finByExample(Book book);
}

package com.rcv.initialspring.services;

import java.util.List;

import com.rcv.initialspring.models.Book;

public interface IBookService {

    List<Book> findAll();

    Book saveBook(Book book);
}

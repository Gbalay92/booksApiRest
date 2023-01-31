package com.rcv.initialspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcv.initialspring.models.Book;
import com.rcv.initialspring.repositories.BooksRepository;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    BooksRepository booksRepo;

    @Override
    public List<Book> findAll() {
        return booksRepo.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        booksRepo.save(book);
        return book;
    }

}

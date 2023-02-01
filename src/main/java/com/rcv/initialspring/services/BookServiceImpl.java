package com.rcv.initialspring.services;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Book findBookById(Long id) {
        Optional op = booksRepo.findById(id);
        if (op.isPresent()) {
            return (Book) op.get();
        }
        return null;
    }

    @Override
    public Book updateBookById(Book book) {
        Optional op = booksRepo.findById(book.getId());
        if (op.isPresent()) {
            return booksRepo.save(book);
        }
        return null;
    }

    @Override
    public void deleteBookById(Long id) {
        booksRepo.deleteById(id);
    }
}

package com.rcv.initialspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rcv.initialspring.models.Book;

public interface BooksRepository extends JpaRepository<Book, Long> {

}

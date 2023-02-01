package com.rcv.initialspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rcv.initialspring.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
package com.example.bookapi.repository;

import com.example.bookapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepositoryIfs extends JpaRepository<Book, Long> {
}
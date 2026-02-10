package com.example.bookapi.service;

import com.example.bookapi.entity.Book;
import com.example.bookapi.repository.BookRepositoryIfs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepositoryIfs bookRepository;

    public BookService(BookRepositoryIfs bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 전체 조회
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    };

    // 특정 id 조회
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    // 도서 추가 1개
    public Book save(Book book) {
        return bookRepository.save(book);
    }
//    // 도서 추가 배열
//    public List<Book> saveAll(List<Book> books) {
//        return bookRepository.saveAll(books);
//    }

    // 도서 수정
    public Book putById(Long id, Book putBook) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book != null) {
            // 기존 book에 putBook 덮어쓰기
            book.setTitle(putBook.getTitle());
            book.setAuthor(putBook.getAuthor());
            book.setIsbn(putBook.getIsbn());
            book.setPublishedDate(putBook.getPublishedDate());
            return bookRepository.save(book);
        }
        return null;
    }

    // 도서 삭제
    public Book deleteById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book != null) {
            bookRepository.delete(book);
            // return 삭제내역
            return book;
        }
        return null;
    }
}

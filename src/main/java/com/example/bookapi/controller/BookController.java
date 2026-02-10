package com.example.bookapi.controller;

import com.example.bookapi.entity.Book;
import com.example.bookapi.repository.BookRepositoryIfs;
import com.example.bookapi.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 전체 조회
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    // 특정 id 조회
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    // 도서 추가
    @PostMapping("/books")
    public Book postBooks(@RequestBody Book requestBook) {
        return bookService.save(requestBook);
    }
//    // 도서 배열로 추가
//    @PostMapping("/books")
//    public List<Book> postBooks(@RequestBody List<Book> requestBook) {
//        return bookService.saveAll(requestBook);
//    }

    // 도서 정보 수정
    @PutMapping("books/{id}")
    public Book putBook(@PathVariable Long id, @RequestBody Book requestBook) {
        return bookService.putById(id, requestBook);
    }
//
    // 도서 삭제
    @DeleteMapping("/books/{id}")
    public Book deleteBook(@PathVariable Long id) {
        return bookService.deleteById(id);
    }
}

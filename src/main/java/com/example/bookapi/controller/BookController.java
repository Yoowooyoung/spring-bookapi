package com.example.bookapi.controller;

import com.example.bookapi.entity.Book;
import com.example.bookapi.repository.BookRepositoryIfs;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {


    private final BookRepositoryIfs bookRepository;

    public BookController(BookRepositoryIfs bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 전체 조회
    @GetMapping("/books")
    public List<Book> findAll() {
        List<Book> books = bookRepository.findAll(); // DB에서 전체 데이터 가져오기
        books.forEach(System.out::println);
        return books;
    }

    // 특정 id 조회
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    // 도서 목록 추가
    @PostMapping("/books")
    public List<Book> postBook(@RequestBody List<Book> requestBooks) {

        return bookRepository.saveAll(requestBooks);
    }

    // 도서 목록 수정
    @PutMapping("/books/{id}") // 경로에 / 를 꼭 확인하세요!
    public Book editBook(@PathVariable Long id, @RequestBody Book requestBook) {

        // 1. DB에서 기존 데이터를 먼저 찾습니다.
        Book book = bookRepository.findById(id).orElse(null);

        if (book != null) {
            // 2. 중요! 사용자가 보낸 새로운 데이터(requestBook)로 기존 데이터를 덮어씁니다.
            book.setTitle(requestBook.getTitle());
            // 만약 다른 필드(author 등)가 있다면 그것도 여기서 변경해줘야 합니다.

            // 3. 내용이 바뀐 객체를 저장합니다.
            return bookRepository.save(book);
        }

        return null; // 혹은 에러 메시지
    }

    // 도서 삭제
    @DeleteMapping("/books/{id}")
    public Book deleteBook(@PathVariable Long id) {

        Book book = bookRepository.findById(id).orElse(null);

        if(book != null) {
            bookRepository.deleteById(id);
        }
        return book;
    }
}

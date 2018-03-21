package info.kzthink.springjpahibernateredis.controller;

import info.kzthink.springjpahibernateredis.model.Book;
import info.kzthink.springjpahibernateredis.service.MongoDBReactiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MongoDBReactiveController {

    private final MongoDBReactiveService reactiveService;

    @GetMapping("/Books")
    public Flux<Book> getAllBooks() {
        return reactiveService.findAllBooks();
    }

    @GetMapping("/Books/{id}")
    public Mono<ResponseEntity<Book>> getBookById(
            @PathVariable(value = "id") String bookId) {
        return reactiveService.getBookById(bookId);
    }

    @PostMapping("/Books")
    public Mono<Book> createTweets(@Valid @RequestBody Book book) {
        return reactiveService.save(book);
    }

    @PutMapping("/Books/{id}")
    public Mono<ResponseEntity<Book>> updateBook(
            @PathVariable(value = "id") String bookId, @Valid @RequestBody Book book) {
        return reactiveService.updateBook(bookId, book);
    }

    @DeleteMapping("/Books/{id}")
    public Mono<ResponseEntity<Void>> deleteBook(
            @PathVariable(value = "id") String bookId) {
        return reactiveService.deleteBook(bookId);
    }

    // Books are Sent to the client as Server Sent Events
    @GetMapping(value = "/stream/Books", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Book> streamAllTweets() {
        return reactiveService.findAllBooks();
    }

}
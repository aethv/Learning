package info.kzthink.springjpahibernateredis.service;

import info.kzthink.springjpahibernateredis.model.Book;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MongoDBReactiveService {

    Flux<Book> findAllBooks();

    Mono<Book> save(Book book);

    Mono<ResponseEntity<Book>> getBookById(String bookId);

    Mono<ResponseEntity<Book>> updateBook(String bookId, Book book);

    Mono<ResponseEntity<Void>> deleteBook(String bookId);
}

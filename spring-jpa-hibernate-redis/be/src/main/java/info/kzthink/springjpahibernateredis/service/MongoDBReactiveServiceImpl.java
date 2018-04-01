package info.kzthink.springjpahibernateredis.service;

import javax.validation.Valid;

import info.kzthink.springjpahibernateredis.model.Book;
import info.kzthink.springjpahibernateredis.repository.BookReactiveRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class MongoDBReactiveServiceImpl implements MongoDBReactiveService {

    private final BookReactiveRepository reactiveRepository;

    @Override
    public Flux<Book> findAllBooks() {
        return reactiveRepository.findAll();
    }

    @Override
    public Mono<Book> save(Book book) {
        return reactiveRepository.save(book);
    }

    @Override
    public Mono<ResponseEntity<Book>> getBookById(String bookId) {
        return reactiveRepository.findById(bookId).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Override
    public Mono<ResponseEntity<Book>> updateBook(String bookId, @Valid Book book) {
        return reactiveRepository.findById(bookId).flatMap(existingBook -> {
            existingBook.setText(book.getText());
            return reactiveRepository.save(existingBook);
        }).map(updatedTweet -> new ResponseEntity<>(updatedTweet, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteBook(String bookId) {
        return reactiveRepository.findById(bookId)
                .flatMap(existingBook -> reactiveRepository.delete(existingBook)
                        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
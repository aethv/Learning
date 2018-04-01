package info.kzthink.springjpahibernateredis.repository;

import info.kzthink.springjpahibernateredis.model.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BookReactiveRepository extends ReactiveMongoRepository<Book, String> {

}
package info.kzthink.springjpahibernateredis.repository;

import info.kzthink.springjpahibernateredis.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String>{

    Book findByTitle(String title);

    /**
     * <p>findById.</p>
     *
     * @param id a {@link java.lang.String} object.
     * @return a {@link java.util.Optional} object.
     */
    Optional<Book> findById(String id);
}

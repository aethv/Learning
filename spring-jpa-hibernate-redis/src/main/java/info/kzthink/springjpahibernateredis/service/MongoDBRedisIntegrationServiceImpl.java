package info.kzthink.springjpahibernateredis.service;

import info.kzthink.springjpahibernateredis.model.Book;
import info.kzthink.springjpahibernateredis.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class MongoDBRedisIntegrationServiceImpl implements MongoDBRedisIntegrationService {

    private final BookRepository repository;
    private final MongoTemplate mongoTemplate;

    /** {@inheritDoc} */
    @Override
    public Long count() {
        return this.repository.count();
    }

    /** {@inheritDoc} */
    @Override
    public Book save(Book book) {
        log.info("Saving book :{}", book);
        return this.repository.save(book);
    }

    /** {@inheritDoc} */
    @Override
    public Book findBookByTitle(String title) {
        log.info("Finding Book by Title :{}", title);
        return this.repository.findByTitle(title);
    }

    /** {@inheritDoc} */
    @Override
    public Book updateByTitle(String title, String author) {
        log.info("Updating Book Author by Title :{} with {}", title, author);
        final Query query = new Query(Criteria.where("title").is(title));
        final Update update = new Update().set("author", author);
        return this.mongoTemplate.findAndModify(query, update,
                new FindAndModifyOptions().returnNew(true).upsert(false), Book.class);
    }

    /** {@inheritDoc} */
    @Override
    public void deleteBook(String id) {
        log.info("deleting Books by id :{}", id);
        this.repository.deleteById(id);
    }

    /** {@inheritDoc} */
    @Override
    public void deleteAllCache() {
        log.info("Deleting Cache");
    }

    /** {@inheritDoc} */
    @Override
    public void deleteAllCollections() {
        this.repository.deleteAll();
    }

    @Override
    public void saveAllBooks(List<Book> bookList) {
        this.repository.saveAll(bookList);
    }

}
package info.kzthink.springjpahibernateredis.service;

import info.kzthink.springjpahibernateredis.model.Book;

import java.util.List;

public interface MongoDBRedisIntegrationService {

    Long count();

    Book save(Book book);

    Book findBookByTitle(String title);

    Book updateByTitle(String title, String author);

    void deleteBook(String id);

    void deleteAllCache();

    void deleteAllCollections();

    void saveAllBooks(List<Book> bookList);
}

package info.kzthink.springjpahibernateredis.controller;

import info.kzthink.springjpahibernateredis.model.Book;
import info.kzthink.springjpahibernateredis.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WebController {

    @Autowired
    BookRepository repository;

    @Autowired
    MongoTemplate mongoTemplate;

    @PostMapping("/post")
    public Book saveBook(Book book){
        return repository.save(book);
    }

    @GetMapping("/book/{title}")
    public Book findBookByTitle(@PathVariable String title){
        Book insertedBook = repository.findByTitle(title);
        return insertedBook;
    }
}

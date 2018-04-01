package info.kzthink.springjpahibernateredis.repository;

import info.kzthink.springjpahibernateredis.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {

}
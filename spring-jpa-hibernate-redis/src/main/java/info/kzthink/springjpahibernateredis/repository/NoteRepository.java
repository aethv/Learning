package info.kzthink.springjpahibernateredis.repository;

import info.kzthink.springjpahibernateredis.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<Note, Long> {

    List<Note> findByTitle(String title);

    List<Note> findByContent(String content);

    @Query("{domain:'?0'}")
    Note findCustomByTitle(String title);

    @Query("{domain: { $regex: ?0} }")
    List<Note> findCustomByRegExTitle(String title);
}

package info.kzthink.dbservice.repository;

import info.kzthink.dbservice.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {
    List<Quote> findByUsername(String username);
}

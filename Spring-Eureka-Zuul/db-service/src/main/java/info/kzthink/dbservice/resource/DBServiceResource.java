package info.kzthink.dbservice.resource;

import info.kzthink.dbservice.model.Quote;
import info.kzthink.dbservice.model.Quotes;
import info.kzthink.dbservice.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DBServiceResource {

    @Autowired
    private QuoteRepository quoteRepository;

    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username") String username) {
        return getQuoteByUsername(username);
    }

    @PostMapping("/add")
    public List<String> add(@RequestBody final Quotes quotes) {
        quotes.getQuotes()
                .stream()
                .map(quote -> new Quote(quotes.getUsername(), quote))
                .forEach(quote -> quoteRepository.save(quote));

        return getQuoteByUsername(quotes.getUsername());
    }

    private List<String> getQuoteByUsername(@PathVariable("username") String username) {
        return quoteRepository.findByUsername(username)
            .stream()
            .map(Quote::getQuote)
            .collect(Collectors.toList());
    }

    @PostMapping("delete/{username}")
    public List<String> delete(@PathVariable("username") String username) {
        List<Quote> quotes = quoteRepository.findByUsername(username);
        quotes.stream().forEach(q -> quoteRepository.delete(q));

        return getQuoteByUsername(username);
    }
}

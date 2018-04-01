package info.kzthink.springjpahibernateredis.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "domain")
@Data
public class Domain {

    @Id
    private long id;

    @Indexed(unique = true)
    private String domain;

    private boolean displayAds;

    //getters and setters
}

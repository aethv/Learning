package info.kzthink.springjpahibernateredis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Document(collection = "todos")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
@Data
@ToString
public class Todo {

    @Id
    private String id;

    @NotBlank
    @Size(max=100)
    @Indexed(unique = true)
    private String title;

    private Boolean completed = false;

    private Date createdAt = new Date();
}

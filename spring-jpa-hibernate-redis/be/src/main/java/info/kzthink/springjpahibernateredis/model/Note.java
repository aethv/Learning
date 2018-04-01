package info.kzthink.springjpahibernateredis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@RedisHash("Note")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Document
public class Note implements Serializable {

    @Id
    private Long id;

    @Indexed(unique = true)
    private String title;

    @NotBlank
    private String content;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}

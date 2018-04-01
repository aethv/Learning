package info.kzthink.springjpahibernateredis.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Data
@Document
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Book")
public class Book implements Serializable{

    @Id
    private String id;
    @Indexed
    @NotBlank
    @Size(max = 140)
    private String title;
    private String author;
    private String text;
    @Version
    private int version;
}

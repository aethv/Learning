package info.kzthink.dbservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Quotes {

    private String username;

    private List<String> quotes;
}

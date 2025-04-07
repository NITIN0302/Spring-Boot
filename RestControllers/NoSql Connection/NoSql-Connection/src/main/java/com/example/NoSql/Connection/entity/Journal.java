package com.example.NoSql.Connection.entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "journal")
@Getter
@Setter
public class Journal {
    @Id
    private String id;

    private String name;

    private String email;

}

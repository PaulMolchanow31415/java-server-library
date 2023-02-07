package my.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookEntity {
    private String title;
    private String author;
    private String publisher;
    private String yearPub;
    private String kind;
}

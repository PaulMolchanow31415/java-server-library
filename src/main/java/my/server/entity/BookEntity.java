package my.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
//import javafx.constratints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "books")
public class BookEntity {
    @Column(name = "book_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Book_id;
//    @NotBlank
    private String title;
//    @NotBlank
    private String author;
    private String publisher;
    private String yearPub;
    private String kind;
}

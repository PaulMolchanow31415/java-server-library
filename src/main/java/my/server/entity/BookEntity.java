package my.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "books")
public class BookEntity {
    @Column(name = "book_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Заголовок не должен быть пустым или содержать только пробелы")
    @Size(min = 4, max = 255, message = "Размер должен быть между 3 и 32 символами")
    private String title;

    // FIXME
    @OneToOne
//    @JoinColumn(name = "author")
    private AuthorEntity author;

    // FIXME
    @ManyToOne
//    @JoinColumn(name = "publisher")
    private PublisherEntity publisher;

    // FIXME to LocalDate @Positive @PastOrPresent
    @Pattern(regexp = "^\\d{4}", message = "В дате издательства может быть только 4 цифры")
    private String yearPub;

    @NotBlank(message = "Жанр книги не должен быть пустым или содержать только пробелы")
    @Size(min = 2, max = 32, message = "Размер должен быть между 2 и 32 символами")
    private String kind;
}

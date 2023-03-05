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
@Table(name = "book")
public class BookEntity {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Заголовок не должен быть пустым или содержать только пробелы")
    @Size(min = 4, max = 255, message = "Размер должен быть между 3 и 255 символами")
    private String title;
    @Size(min = 4, max = 255, message = "Размер должен быть между 3 и 255 символами")
    private String origin;
    @Pattern(regexp = "^\\d{4}$", message = "В дате издательства может быть только 4 цифры")
    private String yearPub;
    @NotBlank(message = "Раздел книги не должен быть пустым или содержать только пробелы")
    @Size(min = 2, max = 32, message = "Размер должен быть между 2 и 32 символами")
    private String section;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publishing;
}

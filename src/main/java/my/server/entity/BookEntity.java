package my.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @Size(min = 3, max = 255, message = "Размер от 3 до 255 символов")
    private String title;
    @NotBlank(message = "Раздел книги не должен быть пустым или содержать только пробелы")
    @Size(min = 3, max = 255, message = "Размер от 3 до 255 символов")
    private String section;
    @Size(min = 3, max = 255, message = "Размер от 3 до 255 символов")
    private String origin;
    @Pattern(regexp = "^\\d{4}$", message = "В году издательства может быть только 4 цифры")
    private String yearPub;
    @NotNull
    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "author_id")
    private AuthorEntity author;
    @NotNull
    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisher;
}

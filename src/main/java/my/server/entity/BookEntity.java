package my.server.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
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
    @Pattern(regexp = "^\\d{4}$", message = "В году издательства может быть только 4 цифры")
    private String yearPub;
    @Column(length = 1000)
    @Size(min = 3, max = 1000, message = "Размер происхождения от 3 до 1000 символов")
    private String origin;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookEntity book)) return false;
        return Objects.equals(id, book.id)
                && Objects.equals(title, book.title)
                && Objects.equals(section, book.section)
                && Objects.equals(yearPub, book.yearPub)
                && Objects.equals(origin, book.origin)
                && Objects.equals(author, book.author)
                && Objects.equals(publisher, book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, section, yearPub, origin, author, publisher);
    }
}

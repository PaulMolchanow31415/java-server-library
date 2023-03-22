package my.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "publisher")
public class PublisherEntity {
    @Id
    @Column(name = "publisher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Название не должено быть пустым или содержать только пробелы")
    @Size(min = 3, max = 255, message = "Длина названия должена быть в диапазоне от 3 и 255 символов")
    private String name;
    @Size(min = 3, max = 255, message = "Длина названия города должена быть в диапазоне от 3 и 255 символов")
    private String city;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher", orphanRemoval = true)
    @ToString.Exclude
    private Set<BookEntity> publishedBooks = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PublisherEntity publisher)) return false;
        return Objects.equals(name, publisher.name)
                && Objects.equals(city, publisher.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city);
    }
}

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
    @Column(length = 1000)
    @Size(min = 3, max = 1000, message = "Размер информации об издателе от 3 до 1000 символов")
    private String info;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher", orphanRemoval = true)
    @ToString.Exclude
    private Set<BookEntity> publishedBooks = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PublisherEntity that)) return false;
        return Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(city, that.city)
                && Objects.equals(info, that.info)
                && Objects.equals(publishedBooks, that.publishedBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, info, publishedBooks);
    }
}

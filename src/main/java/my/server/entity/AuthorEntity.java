package my.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
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
@Table(name = "author")
public class AuthorEntity {
    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 32, message = "Имя автора должно содержать от 2 до 32 символов")
    @Pattern(regexp = "^[A-Z|А-Я][a-z|а-я]{2,32}$", message = "Некорректное имя автора")
    private String name;
    @Size(min = 2, max = 32, message = "Фамилия автора должна содержать от 2 до 32 символов")
    @Pattern(regexp = "^[A-Z|А-Я][a-z|а-я]{2,32}$", message = "Некорректная фамилия автора")
    private String surname;
    @Size(min = 2, max = 32, message = "Отчество автора должно содержать от 2 до 32 символов")
    @Pattern(regexp = "^[A-Z|А-Я][a-z|а-я]{2,32}$", message = "Некорректное отчество автора")
    private String patronymic;
    @Column(length = 1000)
    @Size(min = 3, max = 1000, message = "Размер информации об авторе от 3 до 1000 символов")
    private String info;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", orphanRemoval = true)
    @ToString.Exclude
    private Set<BookEntity> writtenBooks = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorEntity that)) return false;
        return Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(surname, that.surname)
                && Objects.equals(patronymic, that.patronymic)
                && Objects.equals(info, that.info)
                && Objects.equals(writtenBooks, that.writtenBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, info, writtenBooks);
    }
}
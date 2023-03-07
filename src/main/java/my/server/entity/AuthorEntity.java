package my.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
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
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<BookEntity> writtenBooks;
}
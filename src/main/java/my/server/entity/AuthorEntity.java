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
    @NotBlank(message = "Имя не должено быть пустым или содержать только пробелы")
    @Size(min = 3, max = 100, message = "Длина имени должена быть в диапазоне от 3 и 100 символов")
    @Pattern(regexp = "[A-Z|А-Я][a-z|а-я]{2,10}", message = "Некорректное имя автора")
    private String name;
    @NotBlank(message = "Длина фамилии должена быть в диапазоне от 3 и 100 символов")
    @Size(min = 3, max = 100, message = "Размер должен быть между 3 и 32 символами")
    @Pattern(regexp = "[A-Z|А-Я][a-z|а-я]{2,10}", message = "Некорректная фамилия автора")
    private String surname;
    @NotBlank(message = "Длина отчества должена быть в диапазоне от 3 и 100 символов")
    @Size(min = 3, max = 100, message = "Размер должен быть между 3 и 32 символами")
    @Pattern(regexp = "[A-Z|А-Я][a-z|а-я]{2,10}", message = "Некорректная фамилия автора")
    private String patronymic;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<BookEntity> writtenBooks;
}
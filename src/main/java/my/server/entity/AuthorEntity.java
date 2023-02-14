package my.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "author")
public class AuthorEntity {
    @Column(name = "author_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Имя автора не должно быть пустым или содержать только пробелы")
    @Size(min = 2, max = 255, message = "Размер должен быть между 2 и 64 символами")
    @Pattern(regexp = "[A-Z|А-Я][a-z|а-я]{2,10}", message = "Некорректное имя автора")
    private String name;

    @NotBlank(message = "Фамилия автора не должна быть пустой или содержать только пробелы")
    @Size(min = 2, max = 255, message = "Размер должен быть между 2 и 64 символами")
    @Pattern(regexp = "[A-Z|А-Я][a-z|а-я]{2,10}", message = "Некорректная фамилия автора")
    private String surname;
}

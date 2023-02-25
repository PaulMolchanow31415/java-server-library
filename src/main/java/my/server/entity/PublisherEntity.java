package my.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "publisher")
public class PublisherEntity {
    @Id
    @Column(name = "publisher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Название не должено быть пустым или содержать только пробелы")
    @Size(min = 3, max = 100, message = "Длина названия должена быть в диапазоне от 3 и 100 символов")
    private String name;

    @Size(min = 3, max = 100, message = "Длина названия города должена быть в диапазоне от 3 и 100 символов")
    private String city;
}

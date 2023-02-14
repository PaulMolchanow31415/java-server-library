package my.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "publisher")
public class PublisherEntity {
    @Id
    @Column(name = "publisher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Название издательства не должено быть пустым или содержать только пробелы")
    @Size(min = 2, max = 255, message = "Размер должен быть между 2 и 64 символами")
    private String name;

    @NotBlank(message = "Название города издательства не должено быть пустым или содержать только пробелы")
    @Size(min = 2, max = 255, message = "Размер должен быть между 2 и 64 символами")
    private String city;
}

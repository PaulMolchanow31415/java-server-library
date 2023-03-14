package my.server.repositories;

import my.server.entity.AuthorEntity;
import my.server.entity.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {
    @Query("""
            select a from AuthorEntity a
            where a.name like ?1
            or a.surname like ?1
            or a.patronymic like ?1
            """)
    Iterable<AuthorEntity> find(String sought);
}

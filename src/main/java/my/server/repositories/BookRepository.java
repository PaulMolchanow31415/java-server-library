package my.server.repositories;

import my.server.entity.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
    @Query("""
            select b from BookEntity b
            where b.title like ?1
            or b.section like ?1
            or b.origin like ?1
            or b.yearPub like ?1
            or b.author.name like ?1
            or b.author.surname like ?1
            or b.author.patronymic like ?1
            or b.publisher.name like ?1
            or b.publisher.city like ?1
            """)
    Iterable<BookEntity> find(String sought);
}

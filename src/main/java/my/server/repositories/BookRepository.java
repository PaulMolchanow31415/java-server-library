package my.server.repositories;

import my.server.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
    Iterable<BookEntity> findBookEntitiesByTitle(String title);
    Iterable<BookEntity> findBookEntitiesByAuthor(String name);
    Iterable<BookEntity> findBookEntitiesByPublisher(String publisher);
    Iterable<BookEntity> findBookEntitiesByYearPub(String year);
    Iterable<BookEntity> findBookEntitiesByKind(String kind);
}

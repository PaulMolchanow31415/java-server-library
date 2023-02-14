package my.server.repositories;

import my.server.entity.AuthorEntity;
import my.server.entity.BookEntity;
import my.server.entity.PublisherEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
    Iterable<BookEntity> findBookEntitiesByTitle(String title);
    Iterable<BookEntity> findBookEntitiesByAuthor(AuthorEntity author);
    Iterable<BookEntity> findBookEntitiesByPublisher(PublisherEntity publisher);
    Iterable<BookEntity> findBookEntitiesByYearPub(String year);
    Iterable<BookEntity> findBookEntitiesByKind(String kind);
}

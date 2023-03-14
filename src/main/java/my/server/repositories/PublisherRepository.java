package my.server.repositories;

import my.server.entity.BookEntity;
import my.server.entity.PublisherEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<PublisherEntity, Long> {
    @Query("""
            select p from PublisherEntity p
            where p.name like ?1
            or p.city like ?1
            """)
    Iterable<PublisherEntity> find(String sought);
}

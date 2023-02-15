package my.server.repositories;

import my.server.entity.PublisherEntity;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<PublisherEntity, Long> {
    @Override
    void delete(PublisherEntity entity);

    @Override
    void deleteById(Long aLong);

    PublisherEntity findPublisherEntityById(long id);
}

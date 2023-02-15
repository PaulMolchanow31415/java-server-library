package my.server.repositories;

import my.server.entity.AuthorEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {
    @Override
    void delete(AuthorEntity entity);

    @Override
    void deleteById(Long aLong);

    AuthorEntity findAuthorEntityById(long id);
}

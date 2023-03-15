package my.server.service;

import my.server.entity.AuthorEntity;
import my.server.repositories.AuthorEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends AbstractService<AuthorEntity, AuthorEntityRepository> {
    public AuthorService(AuthorEntityRepository repository) {
        super(repository);
    }
}

package my.server.service;

import my.server.entity.AuthorEntity;
import my.server.exception.ValidationException;
import my.server.repositories.AuthorRepository;
import my.server.utils.ValidationUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public void save(AuthorEntity author) throws ValidationException {
        ValidationUtils.validateAuthor(author);
        repository.save(author);
    }

    public Iterable<AuthorEntity> find(String sought) {
        return repository.find(sought);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Iterable<AuthorEntity> getAll() {
        return repository.findAll();
    }
}

package my.server.service;

import my.server.entity.PublisherEntity;
import my.server.exception.ValidationException;
import my.server.repositories.PublisherRepository;
import my.server.utils.ValidationUtils;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    private final PublisherRepository repository;

    public PublisherService(PublisherRepository repository) {
        this.repository = repository;
    }

    public void save(PublisherEntity publisher) throws ValidationException {
        ValidationUtils.validatePublisher(publisher);
        repository.save(publisher);
    }

    public Iterable<PublisherEntity> find(String sought) {
        return repository.find(sought);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Iterable<PublisherEntity> getAll() {
        return repository.findAll();
    }
}

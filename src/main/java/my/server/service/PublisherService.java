package my.server.service;

import my.server.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    private final PublisherRepository repository;

    public PublisherService(PublisherRepository repository) {
        this.repository = repository;
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}

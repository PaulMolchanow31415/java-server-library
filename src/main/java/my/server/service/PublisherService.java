package my.server.service;

import my.server.entity.PublisherEntity;
import my.server.repositories.PublisherEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherService extends BaseService<PublisherEntity, PublisherEntityRepository> {
    public PublisherService(PublisherEntityRepository repository) {
        super(repository);
    }
}

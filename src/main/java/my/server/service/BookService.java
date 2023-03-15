package my.server.service;

import my.server.entity.BookEntity;
import my.server.repositories.BookEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService extends BaseService<BookEntity, BookEntityRepository> {
    public BookService(BookEntityRepository repository) {
        super(repository);
    }
}

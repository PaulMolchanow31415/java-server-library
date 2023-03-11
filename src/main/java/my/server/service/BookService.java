package my.server.service;

import my.server.entity.BookEntity;
import my.server.exception.ValidationException;
import my.server.repositories.BookRepository;
import my.server.utils.ValidationUtils;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void save(BookEntity book) throws ValidationException {
        ValidationUtils.validateBook(book);
        repository.save(book);
    }

    public Iterable<BookEntity> find(String sought) {
        return repository.find(sought);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Iterable<BookEntity> getAll() {
        return repository.findAll();
    }
}

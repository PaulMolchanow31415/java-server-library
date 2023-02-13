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
    public void delete(Long id) { repository.deleteById(id); }
    public Iterable<BookEntity> getAll() { return repository.findAll(); }
    public Iterable<BookEntity> getBooksByTitle(String title) { return repository.findBookEntitiesByTitle(title); }
    public Iterable<BookEntity> getBooksByAuthor(String name) { return repository.findBookEntitiesByAuthor(name); }
    public Iterable<BookEntity> getBooksByPublisher(String publisher) { return repository.findBookEntitiesByPublisher(publisher); }
    public Iterable<BookEntity> getBooksByYearPub(String year) { return repository.findBookEntitiesByYearPub(year); }
    public Iterable<BookEntity> getBooksByKind(String kind) { return repository.findBookEntitiesByKind(kind); }
}

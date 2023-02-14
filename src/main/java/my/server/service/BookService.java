package my.server.service;

import my.server.entity.AuthorEntity;
import my.server.entity.BookEntity;
import my.server.entity.PublisherEntity;
import my.server.exception.BookNotFoundException;
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
    public Iterable<BookEntity> getAll() throws BookNotFoundException {
        Iterable<BookEntity> books = repository.findAll();
        if (!books.iterator().hasNext()) throw new BookNotFoundException("База пуста");
        return books;
    }
    public Iterable<BookEntity> getBooksByTitle(String title) throws BookNotFoundException {
        Iterable<BookEntity> books = repository.findBookEntitiesByTitle(title);
        if (!books.iterator().hasNext()) throw new BookNotFoundException("Книга с таким автором не найдена");
        return books;
    }
    public Iterable<BookEntity> getBooksByAuthor(AuthorEntity author) {
        return repository.findBookEntitiesByAuthor(author);
    }
    public Iterable<BookEntity> getBooksByPublisher(PublisherEntity publisher) {
        return repository.findBookEntitiesByPublisher(publisher);
    }
    public Iterable<BookEntity> getBooksByYearPub(String year) {
        return repository.findBookEntitiesByYearPub(year);
    }
    public Iterable<BookEntity> getBooksByKind(String kind) {
        return repository.findBookEntitiesByKind(kind);
    }
}

package my.server.service;

import my.server.entity.BookEntity;
import my.server.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository repo;
    public BookService(BookRepository repo) {
        this.repo = repo;
    }
    public void save(BookEntity book) { repo.save(book); }
    public void delete(Long id) { repo.deleteById(id); }
    public Iterable<BookEntity> getAll() { return repo.findAll(); }
}

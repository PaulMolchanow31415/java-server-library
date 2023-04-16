package my.server.service;

import my.server.exception.ValidationException;
import my.server.repositories.EntityRepository;
import my.server.utils.ValidationUtils;
import org.springframework.data.repository.CrudRepository;

/**
 * {@code AbstractService}
 * @param <T> тип данных с которыми работает сервис
 * @param <R> интерфейс-репозиторий который работает с сущностями из таблицы BOOKS
 * @see BookService
 * @see AuthorService
 * @see PublisherService
 * @author Павел Молчанов
 * */
public abstract class AbstractService
        <T, R extends CrudRepository<T, Long> & EntityRepository<T>> {
    protected final R repository;

    public AbstractService(R repository) {
        this.repository = repository;
    }

    public void save(T t) throws ValidationException, ClassNotFoundException {
        ValidationUtils.validate(t);
        repository.save(t);
    }

    /**
     * @param id - уникальный номер сущности
     * @param removable - строка-запрос для удаления сущности
     * @throws IllegalArgumentException если для параметра {@code <T>} нет обработчика-валидатора
     * */
    public void delete(Long id, String removable) throws IllegalArgumentException {
        if (id != null) {
            repository.deleteById(id);
        } else if (removable != null) {
            repository.deleteByParam(removable);
        } else {
            throw new IllegalArgumentException("Поля не заполнены");
        }
    }

    public Iterable<T> getAll() {
        return repository.findAll();
    }

    public Iterable<T> findAll(String sought) {
        return repository.findAllByParam(sought);
    }
}

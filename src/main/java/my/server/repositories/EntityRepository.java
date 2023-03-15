package my.server.repositories;

public interface EntityRepository<E> {
    Iterable<E> findAllByParam(String sought);

    void deleteByParam(String removed);
}

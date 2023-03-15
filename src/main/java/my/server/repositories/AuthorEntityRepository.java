package my.server.repositories;

import my.server.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.beans.Transient;

public interface AuthorEntityRepository
        extends JpaRepository<AuthorEntity, Long>, EntityRepository<AuthorEntity> {
    @Query("""
            select a from AuthorEntity a
            where a.name like ?1
            or a.surname like ?1
            or a.patronymic like ?1
            """)
    Iterable<AuthorEntity> findAllByParam(String sought);

    @Transient(value = false)
    @Modifying(clearAutomatically = true)
    @Query("""
            delete from AuthorEntity a
            where a.name like ?1
            or a.surname like ?1
            or a.patronymic like ?1
            """)
    void deleteByParam(String removed);
}

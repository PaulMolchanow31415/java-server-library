package my.server.repositories;

import my.server.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.beans.Transient;

public interface BookEntityRepository
        extends JpaRepository<BookEntity, Long>, EntityRepository<BookEntity> {
    @Query("""
            select b from BookEntity b
            where b.title like ?1
            or b.section like ?1
            or b.origin like ?1
            or b.yearPub like ?1
            or b.author.name like ?1
            or b.author.surname like ?1
            or b.author.patronymic like ?1
            or b.publisher.name like ?1
            or b.publisher.city like ?1
            """)
    Iterable<BookEntity> findAllByParam(String sought);

    @Transient(value = false)
    @Modifying
    @Query("""
            delete from BookEntity b
            where b.title like ?1
            or b.section like ?1
            or b.origin like ?1
            or b.yearPub like ?1
            or b.author.name like ?1
            or b.author.surname like ?1
            or b.author.patronymic like ?1
            or b.publisher.name like ?1
            or b.publisher.city like ?1
            """)
    void deleteByParam(String removable);
}

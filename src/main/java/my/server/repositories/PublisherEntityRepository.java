package my.server.repositories;

import my.server.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PublisherEntityRepository
        extends JpaRepository<PublisherEntity, Long>, EntityRepository<PublisherEntity> {
    @Query("""
            select p from PublisherEntity p
            where p.name like ?1
            or p.city like ?1
            """)
    Iterable<PublisherEntity> findAllByParam(String sought);

    @Modifying
    @Transactional
    @Query("""
            delete from PublisherEntity p
            where p.name like ?1
            or p.city like ?1
            """)
    void deleteByParam(String removed);
}

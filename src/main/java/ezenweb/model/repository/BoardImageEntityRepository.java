package ezenweb.model.repository;

import ezenweb.model.entity.BoardEntity;
import ezenweb.model.entity.BoardImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardImageEntityRepository
        extends JpaRepository<BoardImageEntity, Integer > {

}

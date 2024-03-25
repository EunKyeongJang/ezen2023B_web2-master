package ezenweb.model.repository;

import ezenweb.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberEntityRepository extends JpaRepository<MemberEntity, Integer> {

}
/*
    - 리포지토리 만드는 방법
    1. @Repository : Autowired 하려고
    2. extend JpaRepository<조작할 엔티티, pk의 필드 타입>

    - 리포지토리를 이용한 CRUD
    1. .save(엔티티)       : 해당 엔티티 객체를 테이블에 삽입

 */

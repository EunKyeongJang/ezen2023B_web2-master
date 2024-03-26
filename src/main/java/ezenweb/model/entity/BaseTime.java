package ezenweb.model.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;

@MappedSuperclass   //
@EntityListeners(AuditingEntityListener.class)  //언제수정할지 감시하는 용도
public class BaseTime {

    //1. 레코드 / 엔티티 등록날짜
    @CreatedDate    //default now
    public LocalDateTime cdate;

    //2. 레코드 / 엔티티 수정날짜
    @LastModifiedDate   //마지막 수정날짜
    public LocalDateTime udate;
}
/*
    상속 : 여러곳에서 공텅적인 멤버들
 */
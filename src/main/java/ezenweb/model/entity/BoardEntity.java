package ezenweb.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity // 해당 클래스와 연동DB내 테이블과 매핑/연결 ( ORM )
@Table(name="board")
@Setter
@NoArgsConstructor@AllArgsConstructor
@Builder
public class BoardEntity { // 테이블
    @Id // PK(unique + not null)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private int bno;        // 게시물번호 PK

    @Column(name="title", length=10, nullable=true)
    private String btitle; // 게시물제목

    @Column(columnDefinition = "longtext")
    private String btitle2;

    private boolean f0;

    private byte f1;
    private short f2;
    private long f3;

    private char f4;

    private float f5;
    private double f6;

    private Date f7;
    private LocalDateTime f8;
}
/*
    create table BoardEntitiy(
        bno int ,
        btitle varchar(255)
    )
*/

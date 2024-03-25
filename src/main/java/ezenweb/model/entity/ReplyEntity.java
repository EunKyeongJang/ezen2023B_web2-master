package ezenweb.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="reply")
@Getter
@Setter
@Builder
@ToString
public class ReplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rno;
    private String rcontent;

    //단방향 : fk 필드
    @JoinColumn(name="bno_fk")  //fk 필드명
    @ManyToOne  //해당 필드 참조
    private BoardEntity boardEntity;

    //단방향 : fk 필드
    @JoinColumn(name="mno_fk")  //fk 필드명
    @ManyToOne  //해당 필드 참조
    private MemberEntity memberEntity;

}

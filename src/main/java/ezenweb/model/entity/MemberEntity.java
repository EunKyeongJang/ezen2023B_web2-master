package ezenweb.model.entity;

import ezenweb.model.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="member")
@Getter @Setter
@Builder
@ToString
public class MemberEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private int mno;

    @Column(length=50, unique = true)                   //varchar(50) unique
    private String memail;

    @Column(length=30)                                  //varchar(30)
    private String mpassword;

    @Column(length=20)                                  //carchar(20)
    private String mname;

    @Column(name="mrol")              //varchar(255), not null
    @ColumnDefault("'user'")    //문자'', 숫자
    private String mrol;

    //양방향 : 게시물fk  @OneToMany(mappedBy = "해당 테이블의 fk 자바필드명")
    @OneToMany(mappedBy = "memberEntity")
    @ToString.Exclude
    @Builder.Default    //빌더패턴 사용해서 객체 생성 시 해당필드의 초기값을 빌더 초기값으로 사용
    private List<BoardEntity> boardEntityList=new ArrayList<>();

    //양방향 : 댓글fk
    @OneToMany(mappedBy = "memberEntity")
    @ToString.Exclude   //해당 객체 호출 시 해당 필드는 호출하지 않는다.
    @Builder.Default
    private List<ReplyEntity> replyEntitieList=new ArrayList<>();
    
    // - 엔티티를 dto로 변환하는 메소드
    public MemberDto toDto(){
        return MemberDto.builder()
                .mno(this.mno)
                .mname(this.mname)
                .memail(this.memail)
                .mrol(this.mrol)
                .build();
    }//m end
}//c end

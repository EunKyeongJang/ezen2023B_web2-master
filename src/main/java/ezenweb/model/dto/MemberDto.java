package ezenweb.model.dto;

import ezenweb.model.entity.BoardEntity;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.entity.ReplyEntity;
import jakarta.persistence.AttributeNode;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberDto {
    private int mno;
    private String memail;
    private String mpassword;
    private String mname;
    private String mrol;
    
    //- 엔티티로 변환하는 메소드
    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .mno(this.mno)
                .mname(this.mname)
                .mpassword(this.mpassword)
                .memail(this.memail)
                .mrol(this.mrol)
                .build();
        //this : 해당 메소드를 호출한 인스턴스
    }//m end
}//c end

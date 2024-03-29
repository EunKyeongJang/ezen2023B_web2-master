package ezenweb.model.dto;

import ezenweb.model.entity.MemberEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
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

package ezenweb.model.dto;

import ezenweb.model.entity.BaseTime;
import ezenweb.model.entity.BoardEntity;
import ezenweb.model.entity.BoardImageEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@SuperBuilder
public class BoardDto extends BaseTimeDto {
    private int bno;
    private String bcontent;
    private int bview;
    private int mno_fk;     //(memberEntity) 회원 번호
    private String memail;  //(memberEntity) 회원 이메일

    //1. 출력용 게시물 이미지 필드 (왜?? 파일 이름만 여러개출력하면 되니까) spring --> js
    private List<String> bimgList=new ArrayList<>();
    //2. 등록용 게시물 이미지 필드 js - multipart/Form : byte -> spring
        //MultipartFile : 대용량 바이트를 받아줌
    private List<MultipartFile> uploadlist=new ArrayList<>();

    //글쓰기
    public BoardEntity toEntity(){

        return BoardEntity.builder()
                .bcontent(this.bcontent)
                .build();
    }
}

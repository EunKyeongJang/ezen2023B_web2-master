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
@Builder
public class PageDto {
    private int page;               //현재페이지
    private int count;              //총 페이지 수
    private List<Object> data;    //본문 내용들
}

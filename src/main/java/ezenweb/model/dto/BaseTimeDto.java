package ezenweb.model.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
public class BaseTimeDto {
    private LocalDateTime cdate;    //작성일
    private LocalDateTime udate;    //
}

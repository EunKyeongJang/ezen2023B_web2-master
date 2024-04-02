package ezenweb.model.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="boardimage")
@Getter
@Setter
@Builder
@ToString
public class BoardImageEntity extends BaseTime{
    @Id
    private String bimage;  //파일명 (중복 없다 -- 유저는 다수, 서버는 하나) //식별 가능

    @JoinColumn(name = "bno_fk")
    @ManyToOne
    private BoardEntity boardEntity;
}

package ezenweb.model.entity;

import ezenweb.model.dto.BoardDto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "board")
@AllArgsConstructor@NoArgsConstructor
@Getter @Setter@Builder@ToString
public class BoardEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;

    @Column(columnDefinition = "longtext")
    private String bcontent;

    @ColumnDefault("0")
    private int bview;

    //단방향 : fk필드
    @JoinColumn(name="mno_fk")  //fk 필드명
    @ManyToOne
    private MemberEntity memberEntity;

    //양방향 : 게시물fk
    @OneToMany(mappedBy = "boardEntity", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @Builder.Default
    private List<ReplyEntity> replyEntitieList=new ArrayList<>();

    //양방향 : boardimage
    @OneToMany(mappedBy = "boardEntity", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @Builder.Default
    private List<BoardImageEntity> boardImageEntityList=new ArrayList<>();

    // - 게시물 출력
    public BoardDto toDto(){
        return  BoardDto.builder()
                .bno( this.bno )
                .bcontent( this.bcontent )
                .bview( this.bview )
                .mno_fk( memberEntity.getMno() )
                .memail( memberEntity.getMemail() )
                .cdate(this.getCdate())
                .udate(this.getUdate())
                .bimgList(this.boardImageEntityList.stream().map(
                        (imgEntity)->{ return imgEntity.getBimage();}
                ).collect(Collectors.toList()))
                .build();
    }
}
/*
    create table BoardEntitiy(
        bno int ,
        btitle varchar(255)
    )


    //    @Column(name = "title", length = 10 , nullable = false , unique = true )
//    private String btitle; // 게시물제목
//
//    @Column(columnDefinition = "longtext")
//    private String btitle2;
//
//    @Column(columnDefinition = "date")
//    private String btitle3;
//
//    private boolean 필드0;
//
//    private byte 필드1;
//    private short 필드2;
//    private long 필드3;
//
//    private char 필드4;
//
//    private double 필드5;
//    private float 필드6;
//
//    private Date 필드7;
//    private LocalDateTime 필드8;
//
//    @Column( columnDefinition = "unsigned int(11)" )
//    private int 필드9;


*/
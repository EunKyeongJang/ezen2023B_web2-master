package ezenweb.service;

import ezenweb.model.entity.BoardEntity;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.entity.ReplyEntity;
import ezenweb.model.repository.BoardEntityRepository;
import ezenweb.model.repository.MemberEntityRepository;
import ezenweb.model.repository.ReplyEntityRepositiry;
import jakarta.transaction.Transactional;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class BoardService {
    // * 리포지토리 객체
    @Autowired private BoardEntityRepository boardEntityRepository;
    @Autowired private MemberEntityRepository memberEntityRepository;
    @Autowired private ReplyEntityRepositiry replyEntityRepository;
    // 1. C
    @Transactional
    public boolean postBoard(){
        // ========== 테스트 ==========
        //1. 회원가입
            //1. 엔티티 객체 생성
        MemberEntity memberEntity=MemberEntity.builder()
                .memail("qwe@qwe.com")
                .mpassword("1234")
                .mname("유재석")
                .build();
            //2. 엔티티 조작 : 해당 엔티티를 db에 저장할 수 있도록 조작
        MemberEntity saveMemberEntity = memberEntityRepository.save(memberEntity);

        //2. 회원가입된 회원으로 글쓰기
            //1. 엔티티 객체 생성
        BoardEntity boardEntity=BoardEntity.builder()
                .bcontent("게시물 글입니다.")
                .build();
            //2. **** 글쓰기 [fk 대입]
        boardEntity.setMemberEntity(saveMemberEntity);  //회원 엔티티 대입 시 db에서는 pk만 저장
            //3. 해당 엔티티를 db에 저장할 수 있도록 조작
        BoardEntity saveBoardEntity= boardEntityRepository.save(boardEntity);

        //3. 해당 글에 댓글 작성
            //1. 엔티티 객체 생성
        ReplyEntity replyEntity=ReplyEntity.builder()
                .rcontent("댓글입니다.")
                .build();
            //2. ***** [fk 대입1 작성자]
        replyEntity.setMemberEntity(saveMemberEntity);
            //3. ***** [fk 대입2 게시물번호]
        replyEntity.setBoardEntity(saveBoardEntity);


        return false;
    }
    // 2. R
    @Transactional
    public List<Object> getBoard(){
        // 1. 리포지토리를 이용한 모든 엔티티( 테이블에 매핑 하기전 엔티티 )를 호출
        List<BoardEntity> result = boardEntityRepository.findAll();
        System.out.println("result = " + result);
        return null;
    }
    // 3. U
    @Transactional
    public boolean putBoard(){
        BoardEntity boardEntity = boardEntityRepository.findById( 1 ).get();
        boardEntity.setBcontent("JPA수정테스트중");
        return false;
    }
    // 4. D
    @Transactional
    public boolean deleteBoard(){
        boardEntityRepository.deleteById( 1 );
        return false;
    }
}

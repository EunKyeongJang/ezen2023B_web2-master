package ezenweb.service;

import ezenweb.model.dto.BoardDto;
import ezenweb.model.dto.MemberDto;
import ezenweb.model.dto.PageDto;
import ezenweb.model.entity.BoardEntity;
import ezenweb.model.entity.BoardImageEntity;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.entity.ReplyEntity;
import ezenweb.model.repository.BoardEntityRepository;
import ezenweb.model.repository.BoardImageEntityRepository;
import ezenweb.model.repository.MemberEntityRepository;
import ezenweb.model.repository.ReplyEntityRepositiry;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoardService {
    // * 리포지토리 객체
    @Autowired private BoardEntityRepository boardEntityRepository;
    @Autowired private MemberEntityRepository memberEntityRepository;
    @Autowired private ReplyEntityRepositiry replyEntityRepository;
    @Autowired private BoardImageEntityRepository boardImageEntityRepository;
    @Autowired private MemberService memberService;
    @Autowired private FileService fileService;
    // 1. C
    @Transactional
    public boolean postBoard(BoardDto boardDto){
        // ========== 테스트 ==========
        MemberDto loginDto=memberService.doLoginInfo();
        if(loginDto==null){
            System.out.println("로그인dto없음1");
            return false;
        }
        //1. 로그인된 회원 엔티티 찾기
        Optional<MemberEntity> optionalMemberEntity= memberEntityRepository.findById(loginDto.getMno());

        //2. 찾은 엔티티가 존재하지 않으면 실패
        if(!optionalMemberEntity.isPresent()){
            System.out.println("로그인dto없음2");
            return false;
        }

        //3.
        MemberEntity memberEntity=optionalMemberEntity.get();


            //글쓰기
        BoardEntity saveBoard=boardEntityRepository.save(boardDto.toEntity());

        fileService.fileUpload(boardDto.getUploadlist()).forEach((f)->{
            BoardImageEntity boardImageEntity=BoardImageEntity.builder()
                    .bimage(f)
                    .boardEntity(saveBoard)
                    .build();

            BoardImageEntity boardImage=boardImageEntityRepository.save(boardImageEntity);
        });
            //FK 대입
        if(saveBoard.getBno() >= 1){//글쓰기를 성공했으면
            saveBoard.setMemberEntity(memberEntity);
            return true;
        }
        return false;

    }
    // 2. R
    @Transactional
    public PageDto getBoard(int page, int view){

        //========================== 1 =============================
        /*
        // 1. 리포지토리를 이용한 모든 엔티티( 테이블에 매핑 하기전 엔티티 )를 호출
        List<BoardEntity> result = boardEntityRepository.findAll();
        //2. Entity ====> Dto 변환한다.
        List<BoardDto> boardDtoList=new ArrayList<>();
            //1. 꺼내온 entity를 순회한다.
        for(int i=0; i<result.size(); i++){
            //2. 하나식 entity를 꺼낸다.
            BoardEntity boardEntity=result.get(i);
            //3. 해당 엔티티를 dto로 변환한다.
            BoardDto boardDto=boardEntity.toDto();
                //----게시물 안에 게시물 사진
                List<String> bimgList=new ArrayList<>();
                for(int j=0; j<boardEntity.getBoardImageEntityList().size(); j++){
                    BoardImageEntity boardImageEntity=boardEntity.getBoardImageEntityList().get(i);
                    String bimg=boardImageEntity.getBimage();
                    bimgList.add(bimg);
                }
                boardDto.setBimgList(bimgList);
            //4. 변환된 dto를 리스트에 담는다.
            boardDtoList.add(boardDto);
        }
        System.out.println("result = " + result);
        return boardDtoList;
        */
        //==========================================================

        //1. 인터페이스 이용한 페이징처리
            //pageable은 page 순서 0부터 시작하기 때문에 page가 1페이지일때 0페이지 변환하기 위해 -1
        Pageable pageable=PageRequest.of(page-1, view);

            //1. 페이징 처리된 게시물
        Page<BoardEntity> boardEntityPage=boardEntityRepository.findAll(pageable);
        
            //--List 아닌 Page 타입일때 List 동일한 메소드 사용하고 추가기능
                //1. 전체 페이지수
        System.out.println("boardEntityPage.getTotalPages() = " + boardEntityPage.getTotalPages());
        int count=boardEntityPage.getTotalPages();
                //2. 전체 게시물수
        System.out.println("boardEntityPage.getTotalElements() = " + boardEntityPage.getTotalElements());

            //2. 엔티티를 dto 변환
        List<Object> data = boardEntityPage.stream().map((boardEntity)->{
            return boardEntity.toDto();
        }).collect(Collectors.toList());

        //2. 페이지 dto 반환 값 구성
        PageDto pageDto= PageDto.builder()
                .data(data) //페이징처리된 레코드들을 대입
                .page(page) //현재 페이지 수
                .count(count)    //전체 페이지 수
                .build();
        return pageDto;
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
    public boolean deleteBoard(int bno, int mno_fk){
        MemberDto loginDto=memberService.doLoginInfo();
        if(loginDto==null){
            System.out.println("로그인dto없음1");
            return false;
        }
        if (mno_fk == loginDto.getMno()) {
            boardEntityRepository.deleteById(bno);
            return true;
        }
        return false;
    }//m end
}

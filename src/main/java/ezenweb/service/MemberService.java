package ezenweb.service;

import ezenweb.model.dto.BoardDto;
import ezenweb.model.dto.MemberDto;
import ezenweb.model.entity.BoardEntity;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.repository.MemberEntityRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MemberService{
    @Autowired
    MemberEntityRepository memberEntityRepository;
    @Autowired
    private HttpServletRequest request;

    //1. 회원가입
    public int doSignupPost(MemberDto memberDto){
        System.out.println("MemberService.doSignupPost");
        System.out.println("memberDto = " + memberDto);

        //== dao아닌 엔티티를 이용해 레코드 저장하는 방법
        //1. 엔티티를 만든다.
        //2. 리포지토리를 통한 엔티티를 저장한다. (엔티티 저장 성공 시 매핑된 엔티티 반환)
        MemberEntity savedEntity = memberEntityRepository.save(memberDto.toEntity());
        //3. 엔티티가 생성이 되었는지 확인(pk)
        if(savedEntity.getMno()>0){
            return 1;
        }
        return 0;
    }//m end

    //2. 로그인(세션저장)
    public boolean doLoginPost(MemberDto memberDto){
        //1.
        //MemberEntity result1=memberEntityRepository.findByMemailAndMpassword()
        //2.
        //3.
        MemberEntity result3=memberEntityRepository.findByLoginSQL(
                memberDto.getMemail(), memberDto.getMpassword()
        );
        System.out.println("result3 = " + result3);

        if(result3==null){  //로그인 실패
            return false;
        }
        //세션부여
        request.getSession().setAttribute("loginInfo", result3.toDto());    //*회원번호(1),시큐리티(권한)

        return true;
    }//m end

    //3. 로그아웃
    public boolean doLogoutGet(){
        request.getSession().setAttribute("loginInfo",null);

        return true;
    }//m end

    //4. 현재 로그인된 회원정보 호출(세션 값 반환/호출)
    public MemberDto doLoginInfo(){
        Object object = request.getSession().getAttribute("loginInfo");
        if(object!=null){
            return (MemberDto)object;   //강제 형변환
        }//if end
        return null;
    }//m end


    //5. 아이디==memail 중복검사
    public boolean getFindMemail(String memail){
        System.out.println("MemberService.getMemail");
        //1. 모든 엔티티에서 해당 필드의 값을 찾는다.
        List<MemberEntity> memberEntityList= memberEntityRepository.findAll();
        for(int i=0; i<memberEntityList.size(); i++){
            MemberEntity memberEntity=memberEntityList.get(i);
            if(memberEntity.getMemail().equals(memail)){
                System.out.println("memberEntity = " + memberEntity);
            }
        }

        //2. 특정 필드의 조건으로 레코드/엔티티 검색
        MemberEntity result1=memberEntityRepository.findByMemail(memail);
        System.out.println("result1 = " + result1);

        //3. 특정 필드의 조건으로 존재여부 검색
        boolean result2=memberEntityRepository.existsByMemail(memail);
        System.out.println("result2 = " + result2);

        //4. 직저 native SQL 지원
        MemberEntity result3=memberEntityRepository.findByMemailSQL(memail);
        System.out.println("result3 = " + result3);

        return false;

    }//m end

    //6. (로그인) 내가쓴글
    public List<Map<Object, Object>> findByMyBoardList(){

        //1. 세션에서 로그인된 회원번호 찾는다.
        MemberDto loginDto= doLoginInfo();
        //2. 확인
        if(loginDto==null){
            return null;
        }

        //================ 1. 양방향일때 =================
            //1. 로그인된 회원번호를 이용한 엔티티 찾기
        /*Optional<MemberEntity> optionalMemberEntity= memberEntityRepository.findById(loginDto.getMno());
            //2. 만약에 엔티티가 존재하면
        if(optionalMemberEntity.isPresent()){   //findById의 결과에 엔티티 존재하면
            //3. Optional 에서 엔티티 꺼내기
            MemberEntity memberEntity=optionalMemberEntity.get();
            //4. 내가쓴 글
            List<BoardEntity> result1=memberEntity.getBoardEntityList();
            System.out.println("result1 = " + result1);
            //내가쓴글 엔티티 리스트를 ----> 내가쓴 글 Dto 리스트로 변환
            List<BoardDto> boardDtoList=new ArrayList<>();
            result1.forEach((entity)->{
                boardDtoList.add(entity.toDto());
            });
            return boardDtoList;
            //내가 쓴 댓글
            //memberEntity.getReplyEntitieList();
        }
        else{
            return null;
        }*/

        //================ 2. 단방향일때 =================
        List<Map<Object, Object>> result2=memberEntityRepository.findByMyBoardSQL(loginDto.getMno());
        return result2;


    }//m end

}//c end
/*
    Optional클래스
        - 해당 객체가 null일수도 있고 아닐 수 있다.
        - 검색결과가 없을경우 null 반환될 때 패키징
        - 메소드
 */

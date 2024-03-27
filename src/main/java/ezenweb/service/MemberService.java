package ezenweb.service;

import ezenweb.model.dto.MemberDto;
import ezenweb.model.entity.BaseTime;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.repository.MemberEntityRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService{
    @Autowired
    MemberEntityRepository memberEntityRepository;
    @Autowired
    HttpServletRequest request;

    //1. 회원가입
    public boolean doSignupPost(MemberDto memberDto){
        System.out.println("MemberService.doSignupPost");
        System.out.println("memberDto = " + memberDto);
        //== dao아닌 엔티티를 이용해 레코드 저장하는 방법
        //1. 엔티티를 만든다.
        //2. 리포지토리를 통한 엔티티를 저장한다. (엔티티 저장 성공 시 매핑된 엔티티 반환)
        MemberEntity savedEntity = memberEntityRepository.save(memberDto.toEntity());
        //3. 엔티티가 생성이 되었는지 확인(pk)
        if(savedEntity.getMno()>0){
            return true;
        }
        return false;
    }//m end

    //2. 로그인
    public boolean doLoginPost(MemberDto memberDto){
        System.out.println("MemberService.doLoginPost");
        System.out.println("memberDto = " + memberDto);
        //1. 리포토리를 통한 모든 회원 엔티티 호출
        List<MemberEntity> memberEntityList = memberEntityRepository.findAll();
        //2. dto와 동일한 아이디/패스워드 찾는다.
        for(int i=0 ;i<memberEntityList.size(); i++) {
            MemberEntity m=memberEntityList.get(i);
            //3. 만약에 아이디가 동일하면 (엔티티와 dto)
            if (m.getMemail().equals(memberDto.getMemail())) {
                //4. 만약에 비밀번호가 동일하면
                if (m.getMpassword().equals(memberDto.getMpassword())) {
                    //5. 세션 저장
                    request.getSession().setAttribute("loginInfo", memberDto);
                    return true;
                }//if1 end
            }//if2 end
        }//for end

        return false;
    }//m end

    //3. 로그아웃
    public boolean doLogoutGet(){
        request.getSession().setAttribute("loginInfo",null);

        return true;
    }//m end

    //4. 현재 로그인된 회원정보 호출(세션 값 반환/호출)
    public MemberDto doLogininfo(){
        Object object = request.getSession().getAttribute("loginInfo");
        if(object!=null){
            return (MemberDto)object;   //강제 형변환
        }//if end
        return null;
    }//m end

}//c end

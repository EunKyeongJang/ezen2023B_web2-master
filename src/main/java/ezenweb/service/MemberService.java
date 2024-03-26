package ezenweb.service;

import ezenweb.model.dto.MemberDto;
import ezenweb.model.entity.BaseTime;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.repository.MemberEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService{
    @Autowired
    MemberEntityRepository memberEntityRepository;

    public boolean doSignupPost(MemberDto memberDto){
        System.out.println("MemberService.doSignupPost");
        System.out.println("memberDto = " + memberDto);
        //== dao아닌 엔티티를 이용해 레코드 저장하는 방법
        //1. 엔티티를 만든다.
        //2. 리포지토리를 통한 엔티티를 저장한다.
        memberEntityRepository.save(memberDto.toEntity());

        return false;
    }//m end
}//c end

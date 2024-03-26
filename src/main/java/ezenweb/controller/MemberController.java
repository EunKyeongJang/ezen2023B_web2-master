package ezenweb.controller;

import ezenweb.model.dto.MemberDto;
import ezenweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@CrossOrigin("http://localhost:3000")  //요청 근원지를 교차 허용 # "*" 넣으면 아무거나 다 들어감
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping("/signup/post.do")
    public boolean doSignupPost(@RequestBody MemberDto memberDto){
        System.out.println("memail = " + memberDto);

        return memberService.doSignupPost(memberDto);
    }//m end
}//c end

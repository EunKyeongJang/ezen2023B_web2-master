package ezenweb.controller;

import ezenweb.model.dto.MemberDto;
import ezenweb.service.MemberService;
import lombok.Getter;
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

    //1. 회원가입
    @PostMapping("/signup/post.do")
    public boolean doSignupPost(@RequestBody MemberDto memberDto){
        System.out.println("memail = " + memberDto);

        return memberService.doSignupPost(memberDto);
    }//m end

    //2. 로그인
    @PostMapping("/login/post.do")
    public boolean doLoginPost(MemberDto memberDto){
        System.out.println("MemberController.doLoginPost");

        return memberService.doLoginPost(memberDto);
    }

    //3. 로그아웃
    @GetMapping("/logout/get.do")
    public boolean doLogoutGet(){
        System.out.println("MemberController.doLogoutGet");

        return memberService.doLogoutGet();
    }

    @GetMapping("/login/info/get.do")
    public MemberDto doLoginInfo(){
        return memberService.doLogininfo();
    }

}//c end

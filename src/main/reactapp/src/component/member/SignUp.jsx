import { useState } from "react";
import axios from 'axios';  //axios 라이브러리 호출

export default function SignUp(props){
    //1. 상태변수
    const [memail, setMemail] = useState('');
    const [mpassword, setMpassword] = useState('');
    const [mname, setMname] = useState('');

    //2. memail 수정함수
    const onChangeMemail=(e) =>{
        setMemail(e.target.value);
    }

    //3. 전송 함수
    const onSignUp=(e) => {
        console.log(memail);
        console.log(mpassword);
        console.log(mname);

        /*
            Contenttype : application/json
            axios.HTTP메소드명(url).then(응답매개변수 => {응답로직})
        */
        let info = {
        memail : memail,
        mpassword : mpassword,
        mname : mname}

        //localhost:80 생략 시 localhost:3000으로 들어감
        //contentType : json
        axios.post("/member/signup/post.do",info)
        .then(response => { console.log(response)
            if(response.data==1){
                alert("회원가입 성공");
                window.location.href="/member/login";
            }
            else if(response.data==2){
                alert("아이디 중복");
            }
            else{
                alert("회원가입 실패");
            }
        } )
        .catch(error => {console.log(error);})
    }

    return(<>
        <form>
            아이디 : <input 
                value={memail} 
                type="text"
                onChange={onChangeMemail} /> <br/>
            패스워드 : <input 
                type="password" 
                value={mpassword}
                onChange={(e)=>setMpassword(e.target.value)} /><br/>
            이름 : <input 
                type="text" 
                value={mname} 
                onChange={(e)=>setMname(e.target.value)}/><br/>

            <button type="button" onClick={onSignUp}>회원가입</button>
        </form>
    </>);
}
import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";


export default function Header(props){
    //0. 로그인정보 state 변수
    const [loginInfo, setLoginInfo] = useState('');

    //컴포넌트 생성 시 axios를 실행해서 로그인회원정보 호출
    //1. 컴포넌트가 실행될 때 1번 axios 요청보내서 회원정보 가져온다.
    useEffect(()=>{
        axios.get('/member/login/info/get.do')
        .then(r=>{console.log(r)
            setLoginInfo(r.data);
        })
        .catch(e=>{})
    }, []);

    return(<>
        <div>
            {loginInfo && <span>{loginInfo.memail}님</span>}
            <ul>
                <li><Link to="/">홈</Link></li>
                <li><Link to="/member/signup">회원가입</Link></li>
                <li><Link to="/member/login">로그인</Link></li>
            </ul>
        </div>
    </>)
};
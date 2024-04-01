import axios from "axios";
import { useContext, useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { LoginInfoContext } from "../Index";

export default function Header(props){
    
    const {loginInfo, setLoginInfo} = useContext(LoginInfoContext);

    //컴포넌트 생성 시 axios를 실행해서 로그인회원정보 호출
    //1. 컴포넌트가 실행될 때 1번 axios 요청보내서 회원정보 가져온다.
    useEffect(()=>{
        axios.get('/member/login/info/get.do')
        .then(r=>{console.log(r)
            setLoginInfo(r.data);
        })
        .catch(e=>{console.log(e);})
    }, []);

    //2. 로그아웃
    const onLogOut=()=>{
        
        console.log(loginInfo);
        setLoginInfo('');
    }

    return(<>
        <div>
            {loginInfo && <span>{loginInfo.memail}님</span>}
            <ul>
                <li><Link to="/">홈</Link></li>
                <li><Link to="/member/signup">회원가입</Link></li>
                <li><Link to="/member/login">로그인</Link></li>
                <li><button onClick={onLogOut} type="button">로그아웃</button></li>
                <li><Link to="/board/write">글쓰기</Link></li>
                <li><Link to="/board">글보기</Link></li>
            </ul>
        </div>
    </>);
};
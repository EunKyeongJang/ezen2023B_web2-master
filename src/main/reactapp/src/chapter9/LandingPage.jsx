import { useState } from "react"
import ToolBar from "./ToolBar";

export default function LandingPage(props){
    //1. state 상태변수
    const [isLoggedIn, setIsLoggedIn]=useState(false);
    console.log(isLoggedIn);

    //2. 로그인 클릭함수
    //어차피 컴포넌트는 불변성이기 때문에 그냥 const 사용
    const onClickLogin = ()=>{
        setIsLoggedIn(true);
    }
    //3. 로그아웃 클릭 함수
    const onClickLogout=()=>{
        setIsLoggedIn(false);
    }

    return(<>       
        <div>
            <ToolBar 
            isLoggedIn={isLoggedIn}
            onClickLogin={onClickLogin}
            onClickLogout={onClickLogout}
            />
            <div>소플과 함께하는 리액트 공부</div>
        </div>
    </>)
}
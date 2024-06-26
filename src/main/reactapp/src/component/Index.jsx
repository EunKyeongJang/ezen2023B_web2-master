import { BrowserRouter, Route, Routes, useSearchParams } from "react-router-dom";
import Header from "./layout/Header";
import Footer from "./layout/Footer";
import Home from "./layout/Home";
import SignUp from "./member/SignUp";
import Login from "./member/Login";
import Logout from "./member/Logout";
import React, { useState } from "react";
import BoardWrite from "./board/BoardWrite";
import Board from "./board/Board";
import Chatting from "./chat/Chatting";

// ============= 컨텍스트 만들기 ===============
//1. React.createContext(초기값) 이용한 컨텍스트 선언 //import React from
export const LoginInfoContext=React.createContext('');

//2. Provider컴포넌트 이용한 해당 컨테스트를 사용한 컴포넌트들을 감싼다.
//3. 컨텍스트를 사용한 컴포넌트를 호출한다. 
    //외부에서 해당 컨텍스트를 사용할 수 있도록 export한다.

export default function Index(props){
    //0. 로그인정보 state 변수
    const [loginInfo, setLoginInfo]=useState('');

    return(<>
    <LoginInfoContext.Provider value={{loginInfo, setLoginInfo}}>
        <BrowserRouter>
            <div id="wrap">
                <Header />
                    <Routes>
                        <Route path="/" element={<Home />} />
                        <Route path="/member/signup" element={<SignUp />} />
                        <Route path="/member/login" element={<Login />} />
                        <Route path="/board/write" element={<BoardWrite />} />
                        <Route path="/board" element={<Board />} />
                        <Route path="/chat" element={<Chatting />} />
                    </Routes>
                <Footer />
            </div>
        </BrowserRouter>
    </LoginInfoContext.Provider>
    </>);
}
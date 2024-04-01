import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

// * 내가 만든 컴포넌트 import(가져오기) 호출
// import 컴포넌트명from 컴포넌트파일경로;
import JSX선언 from './chapter3/1_JSX선언';

// chapter3 실습 
import Book from './chapter3/Book';
import Library from './chapter3/Library';

// chapter4 실습 
import Clock from './chapter4/Clock';

//chapter5 실습
import CommentList from "./chapter5/CommentList";

//chapter7 예제
import Counter from "./chapter7/Counter";

// chapter8 예제/실습
import ConfirmButton from './chapter8/ConfirmButton';

//chapter9 예재실습
import LandingPage from './chapter9/LandingPage';

//chapter7 Counter2 실습
import Counter2 from './chapter7/Counter2';

//chapter10 AttendanceBook 실습
import AttendanceBook from './chapter10/AttendanceBook';

//chapter11 AttendanceBook 실습
import NameForm from './chapter11/NameForm';

//chapter11 SignUp 실습
//import SignUp from './chapter11/SignUp';

//component SignUp 실습
import SignUp from './component/member/SignUp';

//chapter0 Axios컴포넌트 실습
import Axios컴포넌트 from './chapter0/Axios컴포넌트';

//chapter0 Route 실습
import Route컴포넌트 from './chapter0/Route컴포넌트';

//web2 라우터 컴포넌트
import Index from './component/Index';

//chapter12 Calculator
import Calculator from './chapter12/Calculator';

//chapter13 ProfileCard
import ProfileCard from './chapter13/ProfileCard';

//chapter14 DarkOrLight
import DarkOrLight from './chapter14/DarkOrLight';

const root = ReactDOM.createRoot(document.querySelector('#root'));
root.render( 
    // <CommentList/>
    // <Counter />
    // <UseStateList />
    //<ConfirmButton />
    //<LandingPage />
    //<Counter2/>
    //<AttendanceBook />s
    //<NameForm />
    //<SignUp />
    //<SignUp />
    //<Axios컴포넌트 />
    //<Route컴포넌트 />
    <Index />
    //<Calculator />
    //<ProfileCard />
    //<DarkOrLight/>
);

// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//   //오류에대한 유효성검사 : <React.StrictMode> 이거 넣으면 한번 더 실행됨
//   <React.StrictMode>  
//     <CommentList />
//   </React.StrictMode>
// );
// root.render( // !!!!!!!여기가 렌더링 되는 곳이에요
//   <React.StrictMode> //유효성검사 해주는부분
//     {/* <App /> */}
//     {/* <JSX선언 /> */}
//     {/* <Book /> */}
//     <Library />
//   </React.StrictMode>
// );
//1. setInterval(함수(), 밀리초) : 밀리초 마다 해당함수 실행
// setInterval(()=>{
//   root.render(<Clock/>);
// },1000);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();

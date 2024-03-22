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
import UseStateList from "./chapter7/UseStateList";
const root=ReactDOM.createRoot(document.getElementById("root"));
root.render(
  //<Counter />
  <UseStateList />
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

import { useState } from "react";

export default function Counter(props){
    //1. 일반변수
    let countValue=0;
    //2. 함수
    function 클릭함수(){
        countValue++;    //변수값 1증가
        console.log("함수안 : "+countValue);
    }

    console.log("컴포넌트안(컴포넌트가 생성될 떄 1번만 실행됨) : "+countValue);

    //3. 상태관리 변수 : state 값의 변화가(set~~) 있으면 해당 컴포넌트 재호출/렌더링
        //1. import{usestate} from "react";
        //2. useState("초기값");
            //반환 : 배열
            //[0] : 초기값 또는 값
            //[1] : state의 set 함수(state 값을 변경할 때 사용되는 함수)
    let 상태관리변수=useState("훅이란 무엇인가");
    console.log(상태관리변수);
    console.log(상태관리변수[0]);
    console.log(상태관리변수[1]);

    const [count, setCount]=useState(0);

    const [inputValue1, setInputValue1]=useState('');
    function inputValue1update(e){  //e : event         
        //방법1. document.querySelector(".class").value;
        //방법2. object.value; : 본인의 값을 가져옴
        //방법3. e.target.value; : 이벤트가 발생한 본인의 값을 가져옴
        console.log(e);                 //e : 이벤트가 발생한 결과물 객체
        console.log(e.target);          //e.target : 이벤트를 발생시킨 발생시킨 주체자(마크업)==this
        console.log(e.target.value);    //e.target.value : 이벤트를 발생시킨 주체자의 value
        setInputValue1(e.target.value); //state 변경함수인 set 함수를 호출해서 값 대입 = 재렌더링 = 재 컴포넌트호출
    }


    return(<>
            <div>
                {/*컴포넌트 불변성으로 인해 count는 증가하지 않는다.*/}
                <p>p.215 일반 변수 : 총 {countValue}번 클릭 했습니다.</p>
                <button type="button" onClick={()=>{countValue++;}}>
                    클릭
                </button>
            </div>

            <div>
                <p>p.216 state 변수 : 총 {count}번 클릭 했습니다.</p>
                <button type="button" onClick={()=>{setCount(count+1);}}>
                    클릭
                </button>
            </div>

            <div>
                <input type="text" /> <br/>
                <input type="text" value={inputValue1} /> <br/>
                <input type="text" value={inputValue1} onChange={inputValue1update} /> <br/>
            </div>
    </>
    );
}
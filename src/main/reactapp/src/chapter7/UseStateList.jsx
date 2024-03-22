import { useState } from "react";

export default function UseStateList(props){

    //2. 포인트 상태 관리 변수
        //1. input 입력된 값을 저장하는 상태관리변수
    let [pointInput, setPointInput]=useState('');
        //2. input 입력된 값들을 저장하는 리스트 상태관리변수
    let [pointList, setPointList]=useState([]);

    //1. 등록버튼 클릭 시 
    function 등록(e){
        console.log("등록함수 실행");

        //===== 고전방식 =====
        //1. 
        //let value=document.querySelector('.pointInput').value;
        //2. 
        //console.log(value);

        //===== 리액트 방식 =====        
        pointList.push(pointInput);
        setPointList([...pointList]);    
        //재렌더링x => set값이 바뀔때 = 주소값이 바뀔때 이기 때문에 배열로 받는 setPointList는 주소값 변경이 일어나지 않는다.
        //방안1. 새로운 배열을 만든다.
            //1. map 사용
            //let 새로운배열 = pointList.map((result)=>{return result;})
            //2. 반복문 사용
            //3. ...연산자 : 데이터 복사
            //setPointList([...pointList]);

    };//f end

    //3. 
    function 입력변경(e){
        setPointInput(e.target.value);   //재렌더링
    }


    return(
      <>
        <div>
            <div>
                <input 
                    value={pointInput} 
                    className="pointInput" 
                    type="text"
                    onChange={입력변경}/>
                <button type="button" onClick={등록}>등록</button>
            </div>
            <div>
                <div> 
                    {
                        pointList.map((point)=>{
                            return(<div> {point} </div>)
                        })
                    }    
                </div>
            </div>
        </div>
      </>  
    );
}
//2. onChange={입력변경}
//1. onChange={(e)=>{setPoint(e.target.value);}}
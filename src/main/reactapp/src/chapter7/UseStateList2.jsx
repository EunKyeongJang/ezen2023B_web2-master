import { useState } from "react";

export default function UseStateList(props){

    //1. 등록버튼 클릭 시 
    function 등록(e){
        console.log("등록함수 실행");

        //===== 고전방식 =====
        //1. 
        let value1=document.querySelector('.pointInput').value;
        //2. 
        console.log(value1);

        //===== 리액트 방식 =====


    };//f end

    return(
      <>
        <div>
            <div>
                <input className="pointInput" type="text"/>
                <button type="button" onClick={등록}>등록</button>
            </div>
            <div>
                <div> 87 </div>
                <div> 91 </div>
            </div>
        </div>
      </>  
    );
}
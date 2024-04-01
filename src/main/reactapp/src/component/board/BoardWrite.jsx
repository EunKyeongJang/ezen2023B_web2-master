import axios from "axios";
import { useRef } from "react";

//글쓰기 페이지
export default function BoardWrite(props){
    const contentRef=useRef('');

    let writeBoard=()=>{
        let boardWriteForm=document.querySelector("#boardWriteForm");
        const boardWriteFormData=new FormData(boardWriteForm);
            console.log(boardWriteFormData);

        axios.post("/board/post.do",boardWriteFormData)
        .then((response)=>{
            console.log(response);
            if(response.data){
                alert("게시물 등록 성공");
            }
            else{
                alert("게시물 등록 실패");
            }
        })
        .catch((error)=>{console.log(error);})
    }

    return(<>
    <form id="boardWriteForm">
        <textarea 
                class="bcontent" 
                name="bcontent" 
                ref={contentRef}
                />
        
    </form>
        <button type="button" onClick={writeBoard}>게시물 등록</button>
        
    </>);
}
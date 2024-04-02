import axios from "axios";
import { useRef, useState } from "react";

//글쓰기 페이지
export default function BoardWrite(props){
    const contentRef=useRef('');
    const [file, setFile]=useState([]);

    let writeBoard=()=>{
        //const boardWriteFormData=new FormData(contentRef.current);
        //console.log(boardWriteFormData);

        axios.post("/board/post.do",contentRef.current) //axios contentType : multipart/form, or json
        .then((response)=>{
            console.log(response);
            if(response.data){
                alert("게시물 등록 성공");
                window.location.href="/board";
            }
            else{
                alert("게시물 등록 실패");
            }
        })
        .catch((error)=>{console.log(error);})
    }
    

    return(<>
    <form id="boardWriteForm" ref={contentRef}>
        <textarea 
                className="bcontent" 
                name="bcontent" />
        <input type="file" 
                multiple accept="image/*" 
                name="uploadlist"
                onChange={(e)=>{                    
                    setFile(e.target.files);
        }} />
        
    </form>
        <button type="button" onClick={writeBoard}>게시물 등록</button>
        
    </>);
}
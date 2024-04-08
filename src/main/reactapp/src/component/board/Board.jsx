import axios from "axios";
import { useEffect, useState } from "react";
import MediaCard from "./MediaCard";
import { Pagination } from "@mui/material";

export default function Board(props){
    //1. useState 변수
    const [pageDto,setPageDto]=useState({
        page : 1, count : 0, data : []
    });
    //- 현재 페이지를 관리하는 state
    const [page, setPage]=useState(1);

    //2. 
    useEffect(()=>{
        const info={page : pageDto.page, view : 4};

        axios.get('/board/get.do',{params : info})
        .then(r=>{console.log(r);
            console.log(r.data);
            setPageDto(r.data);
        })
        .catch(e=>{console.log(e);})
    }, [pageDto.page]);
    
    const handleChange = (event, value) => {
        pageDto.page=value;
        setPage({...pageDto});
      };

    //게시물 삭제 메소드    
    let deleteBoard=(event,bno,mno_fk)=>{
        axios.delete(`/board/delete.do?bno=${bno}&mno_fk=${mno_fk}`)
        .then((response)=>{
            console.log(response);
            if(response.data){
                alert("삭제되었습니다.");
                //1. get방식
                window.location.href="/board";
                //2. 라우터 방식(useNavigate 훅 필요)
                
                //3. useState set
                //navigator("/board");
            }
            else{
                alert("로그인정보가 일치하지 않습니다.");
            }
        })
        .catch((error)=>{
            console.log(error);
            alert("삭제 실패");
        })
    }


    return(<>
        <div style={{display : "flex"}}>
            {
                pageDto.data.map((result)=>{      
                    console.log("start map");     
                    return(       
                        <MediaCard board={result}
                                deleteBoard={deleteBoard} />
                    );
                })
            }
        </div>
        <Pagination count={pageDto.count} 
                    page={pageDto.page} 
                    onChange={handleChange} />
    </>);
}
//count : The total page     : 총 페이지 수
//page : The current page    : 현재 페이지
//onChange : CallBack fired when the page is changed
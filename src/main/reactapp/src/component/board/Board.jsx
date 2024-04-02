import axios from "axios";
import { useEffect, useState } from "react";
import MediaCard from "./MediaCard";

export default function Board(props){
    //1. useState 변수
    const [boardList,setBoardList]=useState([]);

    //2. 
    useEffect(()=>{
        axios.get('/board/get.do')
        .then(r=>{console.log(r);
            setBoardList(r.data);
        })
        .catch(e=>{console.log(e);})
    }, []);

    return(<>
        <div style={{display : "flex"}}>
            {
                boardList.map((result)=>{      
                    console.log("start map");     
                    return(       
                        <MediaCard board={result} />
                    );
                })
            }
        </div>
    </>);
}
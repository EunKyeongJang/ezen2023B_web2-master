import axios from "axios";
import { useEffect, useState } from "react";

export default function Board(props){
    const [boardList,setBoardList]=useState([]);

    useEffect(()=>{
        axios.get('/board/get.do')
        .then(r=>{console.log(r);
            setBoardList(r.data);
        })
        .catch(e=>{console.log(e);})
    }, []);

    return(<>
        <table>
            {boardList.map((result)=>{
                return(<>                  
            <tr>                
                <td>{result.bcontent}</td>
                <td>{result.memail}</td>
            </tr>  
                </>);
            })}
        </table>
    </>);
}
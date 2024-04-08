import { useRef, useState } from "react";

export default function Chatting(props){

    //1. 해당 컴포넌트가 렌더링 될 때 소켓은 재렌더링 방지 useRef
        //useRef(초기값) : {current : 값}
        //- 해당 컴포넌트가 렌더링 될 때 참조값을 고정할 수 있다.
    let clientSocket=useRef(null);
    //2. Ref 참조가 없으면
    if(!clientSocket.current){
        console.log("채팅 실행");
        //========= (클라이언트) 웹소켓 구현 ==========
            //1. new WebSocket(서버 소켓 url);
        clientSocket.current=new WebSocket('ws://192.168.17.80:80/chat');
            //+확인
        console.log(clientSocket);
        //onclose //onerror //onmessage //onopen : WebSocket 객체 내 포함된 메소드들
            //2. 각 메소드 정의 
                //- 1. 클라이언트 소켓이 close 되었을 때 콜백함수 정의
        clientSocket.current.onclose=(e)=>{console.log(e); console.log("서버소켓 닫힘");}
                //- 2. 클라이언트 소켓이 error 발생했을때 콜백함수 정의(*error 이미 발생하고 실행됨)
        clientSocket.current.onerror=(e)=>{console.log(e); console.log("서버소켓 에러");}
                //- 3. 클라이언트 소켓이 message 받았을때 콜백함수 정의
        clientSocket.current.onmessage=(e)=>{
            console.log(e); 
            console.log("서버소켓 메시지"); 
            alert("서버에게 메시지 도착"); 
            //setState
            msgList.push(e.data);
            setMsgList([...msgList]);
        }
                //- 4. 클라이언트 소켓이 open 발생했을때 콜백함수 정의
        clientSocket.current.onopen=(e)=>{console.log(e); console.log("서버소켓 연결 성공");}
    }

   

        
        //3. 서버 소켓으로부터 메시지 받기
    // clientSocket.onmessage=(받은이벤트)=>{
    //     console.log(받은이벤트);
    // }
        //4. 서버소켓으로부터 연결 종료
    //clientSocket.close();
    //===========================================

    const onSend=()=>{
        //2. 연결된 서버소켓에게 메시지 보내기
        clientSocket.current.send(msgInput);    //입력받은 데이터를 서버소켓에게 보내기
    }

    //- 채팅 내용 입력창
    const [msgInput,setMsgInput]=useState('');
    //- 채팅창의 내용물들
    const [msgList, setMsgList] = useState([]);

    return(<>
    <div>
        <h3> 채팅방 </h3>
        <div>
            {
                msgList.map((msg)=>{
                    return(<>
                        <div>{msg}</div>
                    </>);
                })
            }
        </div>
        <textarea value={msgInput} onChange={(e)=>{setMsgInput(e.target.value)}}></textarea>
        <button type="button" onClick={onSend}>전송</button>
    </div>
    
    </>);
}
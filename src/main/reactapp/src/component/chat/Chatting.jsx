export default function Chatting(props){
    console.log("채팅 실행");
    //========= (클라이언트) 웹소켓 구현 ==========
        //1. new WebSocket(서버 소켓 url);
    let clientSocket=new WebSocket('ws://localhost:80/chat');
        //+확인
    console.log(clientSocket);
    //onclose //onerror //onmessage //onopen : WebSocket 객체 내 포함된 메소드들
        //2. 각 메소드 정의 
            //- 1. 클라이언트 소켓이 close 되었을 때 콜백함수 정의
    clientSocket.onclose=(e)=>{console.log(e);}
            //- 2. 클라이언트 소켓이 error 발생했을때 콜백함수 정의(*error 이미 발생하고 실행됨)
    clientSocket.onerror=(e)=>{console.log(e);}
            //- 3. 클라이언트 소켓이 message 받았을때 콜백함수 정의
    clientSocket.onmessage=(e)=>{console.log(e);}
            //- 4. 클라이언트 소켓이 open 발생했을때 콜백함수 정의
    clientSocket.onopen=(e)=>{console.log(e);}

        //2. 연결된 서버소켓에게 메시지 보내기
    clientSocket.send('서버소켓 안녕');
        //3. 서버 소켓으로부터 메시지 받기
    clientSocket.onmessage=(받은이벤트)=>{
        console.log(받은이벤트);
    }
        //4. 서버소켓으로부터 연결 종료
    //clientSocket.close();
    //===========================================

    return(<>
    <div>
        <h3> 채팅방 </h3>
    </div>
    
    </>);
}
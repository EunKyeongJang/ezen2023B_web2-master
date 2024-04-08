package ezenweb.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Component  //rest를 사용하지 않을거라서 controller x
public class ChatSocket extends TextWebSocketHandler {

    //0. 접속 성공한 session들을 모아두기 (접속명단)
    private List<WebSocketSession> 접속명단=new Vector<>();  
        //ArayList(비동기화) vs Vector(동기화) >> 다량의 접속이 들어올경우 순차적으로 처리하기 위해 vector 사용

    //클라이언트의 소켓이 (서버소켓)접속 성공했을때 실행되는 메소드 (session : 클라이언트의 소켓 정보)
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        //연결 상태를 저장하기 위해 session저장  //Established : 정착되다
        System.out.println("session = " + session);
        //1. 접속한 세션 정보를 리스트에 담기
        접속명단.add(session);
        System.out.println(" 접속명단 = " + 접속명단);
    }//m end

    //2. 클라이언트로부터 메세지를 받았을 때 (session : 메시지를 보낸 클라이언트의 소켓, message : 내용물)
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("session = " + session + ", message = " + message);
        System.out.println("message.getPayload() = " + message.getPayload());   //클라이언트가 보내온 내용물
        //1. 접속명단의 클라이언트 소켓들에게 메시지 보내기
        for(WebSocketSession 각클라이언트소켓 : 접속명단){
            각클라이언트소켓.sendMessage(message);
        }//for end
    }//m end

    //3. 클라이언트 소켓과 접속 종료 되었을때 (session : 접속이 종료된 클라이언트 소켓 정보)
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        접속명단.remove(session);
    }//m end
}//c end

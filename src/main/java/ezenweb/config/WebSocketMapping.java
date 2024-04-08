package ezenweb.config;

import ezenweb.controller.ChatSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import java.net.Socket;

@Configuration  //스프링 컨테이너에 설정 객체(bean등록)
@EnableWebSocket    //웹소켓 매핑
public class WebSocketMapping implements WebSocketConfigurer {
                //*스프링 버전에 따라  라이브러리 이름 다를 수 있음
                //*spring2.x : WebSocketConfigurer  spring2.x : WebSocketConfiguration
    @Autowired private ChatSocket socket;   //채팅관련 서버 소켓
    //1. 웹 소켓 매핑 등록
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //- ws로 요청된 url들을 어디로 핸들러 할껀지 설정
        registry.addHandler(socket, "/chat");

    }
}//c end

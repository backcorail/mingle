package com.project.mingle.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

//웹소켓 환경설정
// @EnableWebSocketMessageBroker로 webSocket관련 설절을 작동시킨다.
// 그리고 WebSocketMessageBrokerConfigurer를 implements하여 오버라이딩하여야 한다.
@Configuration 
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		//해당주소를 구독하고 있는 클라이언트에게 메시지 전달
		config.enableSimpleBroker("/topic","queue");
		
		//클라이언트가 보낸 메시지를 받을 prefix
		config.setApplicationDestinationPrefixes("/app");
	}
	// socketjs cdn 주소
	// https://cdnjs.com/libraries/sockjs-client
	// stomjs cdn 주소
	// https://cdnjs.com/libraries/stomp.js
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// socketjs가 연결할 주소
		// socketjs를 이용하여 웹소켓 통신을 할 수 있도록 설정
		// 주소 : ws//localhost:9090/home/chat
		registry.addEndpoint("/chat").withSockJS();
	}
}

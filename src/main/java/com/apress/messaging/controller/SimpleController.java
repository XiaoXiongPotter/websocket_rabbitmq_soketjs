package com.apress.messaging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apress.messaging.domain.ChatMessage;
import com.apress.messaging.domain.IndentHint;

@Controller
//@RequestMapping("/")
public class SimpleController {
	
	@Autowired
	private SimpMessagingTemplate template;
	
	/*@RequestMapping(value="/chat-room/{user}")
	public void chatRoom(@PathVariable("user")String user,ChatMessage message) {
		System.out.println("web的user:"+user);
		template.convertAndSend("/topic/chat/"+user,message);
	}*/
	
	/*
	@MessageMapping("${dgs.ws.mapping}")
	@SendTo("/topic/chat")
	public ChatMessage chatRoom(ChatMessage message) {
		return message;
	}
	*/

	//本段落有用，为index.html中不使用代理用的
//	@MessageMapping("${dgs.ws.mapping-chat}/{room}")
//	@SendTo("/topic/chat/{room}")
//	public String directChatRoom(@DestinationVariable("room")String room,String chatMessage) {
//		System.out.println("chat/{room}:"+room+" message:"+chatMessage);
//		return chatMessage;
//	}
	

	//本段落为使用rabbitmq代理使用
	@MessageMapping("${dgs.ws.mapping-chat}/{room}")
	@SendTo("/exchange/topicExchange/closedPlace")
	public String send(@DestinationVariable("room")String room,String chatMessage) {
		System.out.println("chat/{room}:"+room+" message:"+chatMessage);
		return chatMessage;
	}
	
	/*@MessageMapping("${dgs.ws.mapping-indent}/{user}")
	@SendTo("/topic/indent/{user}")
	public IndentHint processIndentHint(@DestinationVariable("user")String user,IndentHint hint) {
		System.out.println("web的user:"+user);
		return hint;
	}*/
	
	/*
	@MessageMapping("${dgs.ws.mapping}")
	@SendTo("/topic/chat")
	public String directChatRoom(String message) {
		System.out.println("message:"+message);
		return message;
	}
		
	/* Enable for a dynamic destination */
	/*
	@MessageMapping("${dgs.ws.mapping}/{room}")
	@SendTo("/topic/chat-room/{user}")
	public ChatMessage directChatRoom(@DestinationVariable("room")String room
			,@DestinationVariable("user")String user,ChatMessage message) {
		return message;
	}
	*/
}

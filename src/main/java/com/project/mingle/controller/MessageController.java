package com.project.mingle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.mingle.service.ChatService;
import com.project.mingle.vo.ChatVO;
import com.project.mingle.vo.RequestVO;
import com.project.mingle.vo.ResellVO;
import com.project.mingle.vo.RoomVO;
import java.util.stream.Collectors; 

@Controller
public class MessageController {

    @Autowired
    private ChatService chatService;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatVO sendMessage(ChatVO message) throws Exception {
        // 메시지를 데이터베이스에 저장
        chatService.saveMessage(message);
        return message;
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }

    // AJAX를 통해 저장된 메시지를 불러오는 엔드포인트
    @GetMapping("/load-messages")
    @ResponseBody
    public List<ChatVO> loadMessages() {
        // 저장된 모든 메시지를 불러옴
        return chatService.chatList();
    }
    
    @PostMapping("/createRoom")
    @Transactional(rollbackFor={RuntimeException.class, SQLException.class})
    public ModelAndView createRoom(@RequestBody Map<String, String> requestData) {
    	ModelAndView mav = new ModelAndView();
        String seller = requestData.get("seller");
        String buyer = requestData.get("buyer");
        int item_no = Integer.parseInt(requestData.get("item_no"));
        if(buyer == "") {
        	System.out.println("구매희망자 로그인 안함->로그인 페이지로");
        	mav.setViewName("/mingle/user/login_joinForm");
        	return mav;
        }
        else if((seller.equals(buyer))) {
        	System.out.println("판매자와 구매자 동일\n seller : "+seller+" buyer : "+buyer);
        	mav.setViewName("/resell");
        	return mav;
        }
        //기존 구매 신청된 물품인지 확인(추가구현)
        
        System.out.println("백엔드 접근 성공");
        // Room 생성 로직 추가
        RoomVO room = new RoomVO();
        room.setItem_no(item_no);
        chatService.createRoom(room); // 서비스에서 room 생성 후 room_no 반환
        int room_no = room.getRoom_no();
        System.out.println("방 생성, 방번호 : "+ room_no);
        
        RoomVO room2 = new RoomVO();
        room2.setRoom_no(room_no);
        room2.setUser_id(seller);
        chatService.insertRoomMember(room2);
        
        RoomVO room3 = new RoomVO();
        room3.setRoom_no(room_no);
        room3.setUser_id(buyer);
        chatService.insertRoomMember(room3);
        
        mav.addObject("room_no", room_no);
        mav.addObject("item_no", item_no);
        mav.setViewName("/resell/write_result");
        
        return mav;
    }
    //룸리스트 불러오기
    @GetMapping("/load-room")
    @ResponseBody
	public Map<String, Object> roomList(String userId) {
    	List<RoomVO> rvo = chatService.roomList(userId);
    	// item_no들만 추출하여 List로 변환
        List<Integer> itemNoList = rvo.stream()
                                      .map(RoomVO::getItem_no)  // RoomVO의 getItem_no() 메서드를 호출
                                      .collect(Collectors.toList());  // 결과를 리스트로 변환
        
        // 결과를 Map에 담아서 반환
        Map<String, Object> response = new HashMap<>();
        response.put("rooms", rvo);
        if(rvo.isEmpty()) {
        	response.put("msg", "이웃과 소통을 시작하세요!!");
        }
        System.out.println("룸리스트 불러오기 성공!!!");
        
        return response;
	}
    //선택된 룸 데이터 처리
    @GetMapping("/showChat/{room_no}")
    @ResponseBody  // 이 부분 추가
	public Map<String, Object> roomData(@PathVariable("room_no") int room_no) {
		//원글선택
		List<RoomVO> vo = chatService.selectRoomData(room_no);
		//첨부파일 
		Map<String, Object> response = new HashMap<>();
        if(vo.isEmpty()) {
        	response.put("msg", "채팅을 시작하세요!!");
        }else {
        	response.put("cvo", vo);
        }
        System.out.println(vo);
        System.out.println("("+room_no+")룸데이터 불러오기 성공!!!");
        return response;
	}
}

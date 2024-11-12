package com.project.mingle.service;

import java.util.List;

import com.project.mingle.vo.ChatVO;
import com.project.mingle.vo.ResellVO;
import com.project.mingle.vo.RoomVO;

public interface ChatService {
	public int saveMessage(ChatVO cvo);
	public List<ChatVO> chatList();
	public int createRoom(RoomVO room);//구매 매칭 후 채팅방 생성
	public void insertRoomMember(RoomVO room);//채팅방 멤버 설정
	public List<RoomVO> roomList(String userId);
	public List<RoomVO> selectRoomData(int room_no);//룸 데이터 불러오기(채팅, 상대방 등)
}

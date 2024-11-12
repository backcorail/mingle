package com.project.mingle.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.project.mingle.mapper.ChatMapper;
import com.project.mingle.vo.ChatVO;
import com.project.mingle.vo.RoomVO;

@Service
public class ChatServiceImpl implements ChatService {
    @Inject
    ChatMapper mapper;

    @Override
    public int saveMessage(ChatVO cvo) {
        return mapper.saveMessage(cvo);
    }

    @Override
    public List<ChatVO> chatList() {
        return mapper.chatList();
    }
    @Override
    public int createRoom(RoomVO room) {
        mapper.createRoom(room);  // 방 생성

        Long createdRoomNo = (long) room.getRoom_no();  // 자동 생성된 room_no를 가져옴
        System.out.println("생성된 방 번호: " + createdRoomNo);

        // 필요에 따라 room_no를 활용한 추가 로직
        return createdRoomNo != null ? 1 : 0;  // 성공적으로 room_no가 생성되었는지 확인 가능
    }

	@Override
	public void insertRoomMember(RoomVO room) {
		mapper.insertRoomMember(room);
	}

	@Override
	public List<RoomVO> roomList(String userId) {
		return mapper.roomList(userId);
	}

	@Override
	public List<RoomVO> selectRoomData(int room_no) {
		return mapper.selectRoomData(room_no);
	}
}

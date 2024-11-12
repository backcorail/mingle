package com.project.mingle.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.project.mingle.vo.ChatVO;
import com.project.mingle.vo.ResellVO;
import com.project.mingle.vo.RoomVO;

@Mapper
public interface ChatMapper {
    public int saveMessage(ChatVO cvo);
    public List<ChatVO> chatList();
    public int createRoom(RoomVO room);//구매 매칭 후 채팅방 생성
    public void insertRoomMember(RoomVO room);//채팅방 멤버 설정
    public List<RoomVO> roomList(String userId);//룸리스트 가져오기(갱신)
    public List<RoomVO> selectRoomData(int room_no);//룸 데이터 불러오기(채팅, 상대방 등)
}

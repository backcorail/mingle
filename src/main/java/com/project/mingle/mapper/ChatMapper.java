package com.project.mingle.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.project.mingle.vo.ChatVO;

@Mapper
public interface ChatMapper {
    public int saveMessage(ChatVO cvo);
    public List<ChatVO> chatList();
}

package com.project.mingle.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.project.mingle.mapper.ChatMapper;
import com.project.mingle.vo.ChatVO;

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
}

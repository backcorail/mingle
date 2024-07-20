package com.project.mingle.service;

import java.util.List;

import com.project.mingle.vo.ChatVO;

public interface ChatService {
	public int saveMessage(ChatVO cvo);
	public List<ChatVO> chatList();
}

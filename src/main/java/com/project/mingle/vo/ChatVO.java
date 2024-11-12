package com.project.mingle.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatVO {
    private int chat_no;
    private String user_id;  // 데이터베이스의 user_id 필드와 일치하도록 수정
    private String message;  // 데이터베이스의 chat_message 필드와 일치하도록 수정
    private int room_no;
}

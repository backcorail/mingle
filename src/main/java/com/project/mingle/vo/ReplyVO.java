package com.project.mingle.vo;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyVO {
    private String userid; // 유저 닉네임
    private String comment; 
    private String styleno; // 게시글 번호
    private int replyno;
	private int no;
	private int style_likes_no; // 좋아요 수
}
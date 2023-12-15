package com.project.mingle.vo;

import lombok.Data;

@Data
public class Comment {
	private String user_id; // 유저 닉네임
    private String style_reply_comment; 
    private String styleno; // 게시글 번호
    private int replyno;
	private int no;
	private int style_likes_no; // 좋아요 수
	private String user_img;
	private String user_nick;
	
}

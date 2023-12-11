package com.project.mingle.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestVO {
	
	//글쓰기 관련 변수 목록
	private int request_no;
	private String user_id;//유저 아이디
	private int request_type;//글 종류 1->요청 2->질문
	private String request_name;//글 제목	
	private String request_comment;//글내용
	private String request_writedate;//작성일자
}

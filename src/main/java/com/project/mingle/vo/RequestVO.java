package com.project.mingle.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestVO {
	// 페이지 관련 변수 목록
	private int nowPage = 1; // 현재페이지
	private int totalRecord; // 레코드 수
	private int onePageRecord = 16; // 한 페이지 레코드 수
	private int totalPage; // 총 페이지
	private int onePageCount = 5; // 출력할 페이지 수
	private int startPage = 1; // 처음 시작 페이지
	private int offsetPoint; // 데이터 시작 부분
	
	//글쓰기 관련 변수 목록
	private int request_no;
	private String user_id;//유저 아이디
	private String user_nick;//유저 닉네임
	private int request_type;//글 종류 1->요청 2->질문
	private String request_name;//글 제목	
	private String request_comment;//글내용
	private String request_writedate;//작성일자
	private String user_img;//유저이미지
	
	//댓글 관련 변수
	private int request_reply_no;
	private String request_reply_comment;
	private String request_reply_writedate;
	
	//이미지 파일 업로드
	private String request_datafile_dataname;//첨부파일명
}

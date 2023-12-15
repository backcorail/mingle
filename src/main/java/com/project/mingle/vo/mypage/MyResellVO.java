package com.project.mingle.vo.mypage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyResellVO implements MyActInfo{
//	private int type=1; // 
	
	//10개
	// 데이터 관련 변수 목록(resell 테이블)
	private int resell_no; // 리셀 게시글 고유번호
	private String resell_name; // 게시글 이름
	private String resell_seller; // 판매자 아이디 => userid
	private String resell_buyer; // 구매자 아이디
	private int item_no; // 구매자 아이디
	private String resell_comment; // 글 내용
	private double item_price; // 글 내용
	private String resell_addr; // 지역 주소
	private String resell_writedate; // 게시된 날짜
	private int resell_likes;
	private String item_file_name;
	
	@Override
	public String getSelldone() {
		// TODO Auto-generated method stub
		return getResell_buyer();
	}
	
	
	@Override
	public String getImg() {
		// TODO Auto-generated method stub
		return getItem_file_name();
	}
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "리셀";
	}
	@Override
	public int getNo() {
		// TODO Auto-generated method stub
		return getResell_no();
	}
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return getResell_name();
	}
	@Override
	public String getContents() {
		// TODO Auto-generated method stub
		return getResell_comment();
	}
	@Override
	public String getWriteDate() {
		// TODO Auto-generated method stub
		return getResell_writedate();
	}

}
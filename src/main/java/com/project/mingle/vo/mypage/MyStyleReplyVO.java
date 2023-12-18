package com.project.mingle.vo.mypage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyStyleReplyVO implements MyActInfo{
	// 6개
	//기본 데이터
	private int style_reply_no;// 스타일 리플 글번호
	private int style_no;// 스타일 글번호
	private String user_id; //작성자
	
	private String style_reply_comment;
	private String style_reply_writedate;//작성일자
	
	//추가 데이터
	private String  style_name; // 스타일제목	
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
//		return "MyStyleVO";
		return "스타일";
	}
	@Override
	public String getTitle() { //스타일보드의 제목
		// TODO Auto-generated method stub
		return getStyle_name();
	}
	@Override
	public String getContents() { //스타일 댓글 내용
		// TODO Auto-generated method stub
		return getStyle_reply_comment();
	}
	@Override
	public String getWriteDate() { //댓글 작성일자.
		// TODO Auto-generated method stub
		return getStyle_reply_writedate();
	}
	@Override
	public int getNo() { //댓글테이블 넘버.
		// TODO Auto-generated method stub
		return getStyle_reply_no();
	}
	@Override
	public String getImg() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getSelldone() {
		// TODO Auto-generated method stub
		return null;
	}

}
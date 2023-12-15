package com.project.mingle.vo.mypage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyStyleVO implements MyActInfo{
//	private int type=3; //
	// 7개
	private int style_no;// 스타일 글번호
	private String style_name;//리셀 제목
	private String style_img;//게시글 이미지
    private String user_id; //작성자
    private String style_writedate;//작성일자
    private int resell_no;//리셀 글번호 - 태그상품 위해서
    private int style_likes; // 좋아요 수
	@Override
	public String getType() {
		// TODO Auto-generated method stub
//		return "MyStyleVO";
		return "스타일";
	}
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return getStyle_name();
	}
	@Override
	public String getContents() {
		// TODO Auto-generated method stub
		return "임시데이터";
	}
	@Override
	public String getWriteDate() {
		// TODO Auto-generated method stub
		return getStyle_writedate();
	}
	@Override
	public int getNo() {
		// TODO Auto-generated method stub
		return getStyle_no();
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
package com.project.mingle.vo;

import lombok.Data;

@Data
public class StyleVO {

	private String item_image;	
    private String item_name;
    private String item_price; // 아이템 가격
    private String item_postdate;
    private int ktotalRecord; // 크림 총 레코드수
    private int ktotalPage; // 크림 총 페이지
    
    private String style_image;//게시글 이미지
    private String user_id;
    private String style_writedate;//작성일자
    private int resell_no;//리셀 글번호 - 태그상품 위해서
    private String style_name;//리셀 제목
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

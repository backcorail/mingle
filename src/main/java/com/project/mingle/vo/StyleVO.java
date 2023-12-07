package com.project.mingle.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StyleVO {
	
	private int onepagerecord = 32; // 페이지당 개수
	private String item_image;	// 아이템 사진
    private String item_name;  // 아이템 이름
    private String item_price; // 아이템 가격
    private String item_postdate; // 아이템 작성 일자
    private int style_likes_check; // 좋아요 체크 
    
    
    
    
    private int tabs;
    
    private int ktotalRecord; // 크림 총 레코드수
    private int ktotalPage; // 크림 총 페이지
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

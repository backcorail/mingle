package com.project.mingle.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodyTestVO {
	private String weather;		//날씨
	private int situation;
	private int itemSlide = 10;	//슬라이드의 아이템 수
	private int gender;
	private int detail;
	
	
	private String item_name;	//아이템 이름
	private String item_image;	//아이템 이미지
	private int item_no;		//아이템 번호
	private int item_detail;	//아이템 디테일
	private int item_category;	//성별
	
	private int user_gender=0;	//유저 성별  
	
}

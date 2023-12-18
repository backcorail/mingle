package com.project.mingle.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminVO {
	private String searchWord;
	
	private int offsetPoint;	//데이터 시작 부분
	private int onePageRecord = 200; //한페이지 레코드 수
	
	private int item_no; //아이템 고유 번호
	private int item_category;
	private int item_detail;
	private String item_image;	
	private String item_file_name;	
    private String item_name;
    private String item_price; // 아이템 가격
    private String item_postdate;
    
    private int ktotalRecord; // 크림 총 레코드수
    private int ktotalPage; // 크림 총 페이지
}

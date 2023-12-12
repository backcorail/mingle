package com.project.mingle.vo;

import lombok.Data;

@Data
public class ResellItemVO {
	//이미지 파일 업로드
	private int item_no;//아이템 번호
	private String item_name;//아이템명
	private int item_price;//아이템 가격
	private int item_category;//아이템 카테고리
	private int item_detail;//아이템 세부 카테고리
	private String item_seller;//아이템 판매자
	private String item_postdate;//아이템 게시일
}

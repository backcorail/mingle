package com.project.mingle.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResellVO {
	
	// 페이지 관련 변수 목록
	private int nowPage = 1; // 현재페이지
	private int totalRecord; // 레코드 수
	private int onePageRecord = 16; // 한 페이지 레코드 수
	private int totalPage; // 총 페이지
	private int onePageCount = 5; // 출력할 페이지 수
	private int startPage = 1; // 처음 시작 페이지
	private int offsetPoint; // 데이터 시작 부분
	
	// 데이터 관련 변수 목록
	private int resell_no; // 리셀 게시글 고유번호
	private String resell_name; // 게시글 이름
	private int resell_seller; // 판매자 고유 번호
	private String resell_writedate; // 게시된 날짜
	//private int item_price;
	
	// 크림 관련 변수 목록
	private String item_image;	
    private String item_name;
    private String item_price; // 아이템 가격
    private String item_postdate;
    private int ktotalRecord; // 크림 총 레코드수
    private int ktotalPage; // 크림 총 페이지
    
    
	
	public void setTotalPage() {
		// 총 페이지 수
		totalPage = (int)Math.ceil(this.totalRecord / (double)onePageRecord);
	}
	
	public void setKtotalPage() {
		ktotalPage = (int)Math.ceil(this.ktotalRecord / (double)onePageRecord);
	}
	
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
		
		// 해당페이지 위치를 계산
		offsetPoint = (nowPage-1)*onePageRecord;
		
		// 시작페이지 : 현재페이지 번호가 바뀔때
		startPage = (nowPage-1)/onePageCount*onePageCount+1;
	}
	
	public void setOffsetPoint() {
		offsetPoint = (nowPage-1)*onePageRecord;
		startPage = (nowPage-1)/onePageCount * onePageCount +1;
	}
}
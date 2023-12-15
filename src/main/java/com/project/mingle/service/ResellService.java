package com.project.mingle.service;

import java.util.List;

import com.project.mingle.vo.ResellVO;

public interface ResellService {
	public int resell_totalRecord(ResellVO rVO); // 총 레코드수 계산
	public int kream_totalRecord(ResellVO rVO); // 크림 데이터 총 레코드수 계산
	public List<ResellVO> resell_boardData(ResellVO rVO); // 데이터 가져오기
	public List<ResellVO> kreamData(ResellVO rVO); // 크림 데이터 가져오기
	
	public ResellVO resell_select(int no); // 보드 데이터 가져오기
	public ResellVO item_select(int no); // 아이템 데이터 가져오기
	public List<String> image_select(int no); // 이미지 데이터 가져오기
	public ResellVO user_select(String id); // 유저 데이터 가져오기
	
	public int resell_insert(ResellVO rVO); // 게시글 작성
	public int item_insert(ResellVO rVO); // 아이템 입력
	public int image_insert(List<ResellVO> list); // 이미지 데이터 넣기
	
	public int resell_update(ResellVO rVO); // 게시글 수정
	public int item_update(ResellVO rVO); // 아이템 수정
	public int image_update(List<ResellVO> list); // 이미지 수정
	
	public int resell_delete(int no); // 게시글 삭제
	public int item_delete(int no); // 아이템 삭제
	public int image_delete(int no); // 이미지 삭제
	
	public int resell_buyer(ResellVO rVO); // 구매자 등록
	public int item_buyer(ResellVO rVO); // 구매자 등록
}

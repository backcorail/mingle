package com.project.mingle.service;

import java.util.List;

import com.project.mingle.vo.ResellVO;

public interface ResellService {
	public int resell_totalRecord(ResellVO rVO); // 총 레코드수 계산
	public int kream_totalRecord(ResellVO rVO); // 크림 데이터 총 레코드수 계산
	public List<ResellVO> resell_boardData(ResellVO rVO); // 데이터 가져오기
	public List<ResellVO> kreamData(ResellVO rVO); // 크림 데이터 가져오기
	
	public ResellVO boardData(int no); // 보드 데이터 가져오기
	public ResellVO itemData(int no); // 아이템 데이터 가져오기
	public List<String> imageData(int no); // 이미지 데이터 가져오기
	public ResellVO userData(String id); // 유저 데이터 가져오기

	public int item_insert(ResellVO rVO); // 아이템 입력
	public int resell_insert(ResellVO rVO); // 리셀 글 작성
	public int item_file_insert(List<ResellVO> list); //아이템 사진 넣기
}

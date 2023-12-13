package com.project.mingle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.mingle.vo.ResellVO;

@Mapper
public interface ResellMapper {
	public int resell_totalRecord(ResellVO rVO); // 총 레코드수 계산
	public int kream_totalRecord(ResellVO rVO); // 크림 데이터 총 레코드수 계산
	public List<ResellVO> resell_boardData(ResellVO rVO); // 데이터 가져오기
	public List<ResellVO> kreamData(ResellVO rVO); // 크림 데이터 가져오기
	
	public ResellVO boardData(int no); // 보드 데이터 가져오기
	public ResellVO itemData(int no); // 아이템 데이터 가져오기
	public List<String> imageData(int no); // 이미지 데이터 가져오기
	public ResellVO userData(String id); // 유저 데이터 가져오기
	
	public int item_insert(ResellVO rVO); // 아이템 입력
	public int resell_insert(ResellVO rVO); // 게시글 작성
	public int item_file_insert(List<ResellVO> list); // 이미지 데이터 넣기
	
	public int item_update(ResellVO rVO); // 아이템 수정
	public int resell_update(ResellVO rVO); // 게시글 수정
	public int item_file_update(List<ResellVO> list); // 이미지 수정
}
 
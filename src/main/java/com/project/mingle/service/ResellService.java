package com.project.mingle.service;

import java.io.IOException;
import java.util.List;

import com.project.mingle.vo.ItemFileVO;
import com.project.mingle.vo.ResellItemVO;
import com.project.mingle.vo.ResellVO;

public interface ResellService {
	public int resell_totalRecord(ResellVO rVO); // 총 레코드수 계산
	public int kream_totalRecord(ResellVO rVO); // 크림 데이터 총 레코드수 계산
	public List<ResellVO> resell_boardData(ResellVO rVO); // 데이터 가져오기
	public List<ResellVO> kreamData(ResellVO rVO); // 크림 데이터 가져오기
	public int itemInsert(ResellItemVO rivo);//아이템 입력
	public int resellInsert(ResellVO rvo);//글 작성
	public int itemFileInsert(List<ItemFileVO> list);//아이템 사진 입력
}

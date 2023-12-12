package com.project.mingle.service;

import java.io.IOException;
import java.util.List;

import com.project.mingle.vo.ResellVO;

public interface ResellService {
	public int resell_totalRecord(ResellVO rVO); // 총 레코드수 계산
	public int kream_totalRecord(ResellVO rVO); // 크림 데이터 총 레코드수 계산
	public List<ResellVO> resell_boardData(ResellVO rVO); // 데이터 가져오기
	public List<ResellVO> kreamData(ResellVO rVO); // 크림 데이터 가져오기
	public ResellVO boardData(int no); // 보드 데이터 가져오기
}

package com.project.mingle.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.mingle.mapper.ResellMapper;
import com.project.mingle.vo.ResellVO;

@Service
public class ResellServiceImpl implements ResellService {
	
	@Inject
	ResellMapper mapper;
	
	// 크림관련 데이터 가져오기
	@Override
	public int resell_totalRecord(ResellVO rVO) {
		return mapper.resell_totalRecord(rVO);
	}
	@Override
	public int kream_totalRecord(ResellVO rVO) {
		return mapper.kream_totalRecord(rVO);
	}
	@Override
	public List<ResellVO> resell_boardData(ResellVO rVO) {
		return mapper.resell_boardData(rVO);
	}
	@Override
	public List<ResellVO> kreamData(ResellVO rVO) {
		return mapper.kreamData(rVO);
	}

	// 유저가 올린 데이터 가져오기
	@Override
	public ResellVO resell_select(int no) {
		return mapper.resell_select(no);
	}
	@Override
	public ResellVO item_select(int no) {
		return mapper.item_select(no);
	}
	@Override
	public List<String> image_select(int no) {
		return mapper.image_select(no);
	}
	@Override
	public ResellVO user_select(String id) {
		return mapper.user_select(id);
	}

	// 데이터 추가하기
	@Override
	public int item_insert(ResellVO rVO) {
		return mapper.item_insert(rVO);
	}
	@Override
	public int resell_insert(ResellVO rVO) {
		return mapper.resell_insert(rVO);
	}
	@Override
	public int image_insert(List<ResellVO> list) {
		return mapper.image_insert(list);
	}
	
	// 데이터 수정하기
	@Override
	public int item_update(ResellVO rVO) {
		return mapper.item_update(rVO);
	}
	@Override
	public int resell_update(ResellVO rVO) {
		return mapper.resell_update(rVO);
	}
	@Override
	public int image_update(List<ResellVO> list) {
		return mapper.image_update(list);
	}
	
	// 데이터 삭제하기
	@Override
	public int resell_delete(int no) {
		return mapper.resell_delete(no);
	}
	@Override
	public int item_delete(int no) {
		return mapper.item_delete(no);
	}
	@Override
	public int image_delete(int no) {
		return mapper.image_delete(no);
	}
	
	// 구매자 등록
	@Override
	public int resell_buyer(ResellVO rVO) {
		return mapper.resell_buyer(rVO);
	}
	@Override
	public int item_buyer(ResellVO rVO) {
		return mapper.item_buyer(rVO);
	}
}

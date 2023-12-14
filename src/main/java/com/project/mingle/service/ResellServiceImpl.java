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
	public ResellVO boardData(int no) {
		return mapper.boardData(no);
	}
	@Override
	public ResellVO itemData(int no) {
		return mapper.itemData(no);
	}
	@Override
	public List<String> imageData(int no) {
		return mapper.imageData(no);
	}
	@Override
	public ResellVO userData(String id) {
		return mapper.userData(id);
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
	public int item_file_insert(List<ResellVO> list) {
		return mapper.item_file_insert(list);
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
	public int item_file_update(List<ResellVO> list) {
		return mapper.item_file_update(list);
	}
	
	// 데이터 삭제하기
	@Override
	public int resell_delete(ResellVO rVO) {
		return mapper.resell_delete(rVO);
	}
	@Override
	public int item_delete(ResellVO rVO) {
		return mapper.item_delete(rVO);
	}
	@Override
	public int item_file_delete(List<ResellVO> list) {
		return mapper.item_file_delete(list);
	}
}

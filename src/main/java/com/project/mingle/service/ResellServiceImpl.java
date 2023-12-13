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
}

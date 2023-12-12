package com.project.mingle.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.mingle.mapper.ResellMapper;
import com.project.mingle.vo.RequestVO;
import com.project.mingle.vo.ItemFileVO;
import com.project.mingle.vo.ResellItemVO;
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
	public int itemInsert(ResellItemVO rivo) {
		return mapper.itemInsert(rivo);
	}

	@Override
	public int resellInsert(ResellVO rvo) {
		return mapper.resellInsert(rvo);
	}

	@Override
	public int itemFileInsert(List<ItemFileVO> list) {
		return mapper.itemFileInsert(list);
	}
}

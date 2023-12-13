package com.project.mingle.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.project.mingle.mapper.StyleMapper;
import com.project.mingle.vo.StyleFileVO;
import com.project.mingle.vo.StyleVO;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.project.mingle.mapper.StyleMapper;
import com.project.mingle.vo.StyleVO;

@Service
public class StyleServiceImpl  implements StyleService{

	@Inject
	StyleMapper mapper;
	
	

	@Override
	public int kream_totalRecord(StyleVO sVO) {
		
		return mapper.kream_totalRecord(sVO);
	}


	@Override
	public List<StyleVO> kreamData(StyleVO sVO) {
		
		return mapper.kreamData(sVO);
	}


	@Override
	public int style_likes_check(StyleVO sVO) {
		
		return mapper.style_likes_check(sVO);
	}
  
  	@Override
	public int styleInsert(StyleVO vo) {
		return mapper.styleInsert(vo);
	}


	@Override
	public int styleFileInsert(List<StyleFileVO> list) {
		return mapper.styleFileInsert(list);
	}
}

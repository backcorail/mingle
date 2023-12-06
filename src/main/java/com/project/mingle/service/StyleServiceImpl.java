package com.project.mingle.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.project.mingle.mapper.StyleMapper;
import com.project.mingle.vo.StyleVO;

@Service
public class StyleServiceImpl implements StyleService{
	@Inject
	StyleMapper mapper;

	@Override
	public int styleInsert(StyleVO vo) {
		return mapper.styleInsert(vo);
	}

}

package com.project.mingle.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.mingle.vo.StyleVO;

@Mapper
public interface StyleMapper {
	public int styleInsert(StyleVO vo); //스타일 작성 저장
}

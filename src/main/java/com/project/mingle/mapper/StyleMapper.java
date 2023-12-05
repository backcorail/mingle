package com.project.mingle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.mingle.vo.StyleVO;

@Mapper
public interface StyleMapper {
	// public int Style_totalRecord(StyleVO sVO);
	public int kream_totalRecord(StyleVO sVO);
	// public List<StyleVO> Style_boardData(StyleVO sVO);
	public List<StyleVO> kreamData(StyleVO sVO);
}

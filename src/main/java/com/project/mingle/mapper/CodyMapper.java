package com.project.mingle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.mingle.vo.CodyTestVO;


@Mapper
public interface CodyMapper {
	
	public List<CodyTestVO>cody_boardData(CodyTestVO cVO);//데이터 가져오기
	
	
	
}
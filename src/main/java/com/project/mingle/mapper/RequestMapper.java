package com.project.mingle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.mingle.vo.RequestFileVO;
import com.project.mingle.vo.RequestVO;

@Mapper
public interface RequestMapper {
	
	
	//글작성
	public int requestInsert(RequestVO rvo);//글작성
	public int requestFileInsert(List<RequestFileVO> list);//파일명 insert
}

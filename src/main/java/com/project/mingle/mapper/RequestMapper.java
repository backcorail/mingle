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
	
	//글선택
	public RequestVO requestSelect(int request_no);//글 제목, 내용 등 선택
	public List<RequestFileVO> getDataFile(int request_no);//첨부파일선택
}

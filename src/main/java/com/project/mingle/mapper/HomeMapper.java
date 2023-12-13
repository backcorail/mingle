package com.project.mingle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.mingle.vo.ResellVO;

@Mapper
public interface HomeMapper {
	public List<ResellVO> resellList(ResellVO rVO); // 데이터 가져오기
	public List<ResellVO> kreamList(ResellVO rVO); // 크림데이터 가져오기
}

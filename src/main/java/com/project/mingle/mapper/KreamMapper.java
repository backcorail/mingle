package com.project.mingle.mapper;

import com.project.mingle.vo.KreamVO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface KreamMapper {
	public int kreamInsert(@Param("kreamlist") List<KreamVO> kreamlist);

//	public int kreamInsert(List<KreamVO> kreamlist);
}

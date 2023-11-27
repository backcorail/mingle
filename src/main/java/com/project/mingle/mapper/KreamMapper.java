package com.project.mingle.mapper;

import com.project.mingle.vo.KreamVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KreamMapper {
	public int kreamInsert(KreamVO vo);
}

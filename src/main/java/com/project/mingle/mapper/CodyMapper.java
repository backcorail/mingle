package com.project.mingle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.mingle.vo.CodyTestVO;
import com.project.mingle.vo.UserVO;


@Mapper
public interface CodyMapper {
	
	public List<CodyTestVO>cody_boardData(CodyTestVO cVO);//데이터 가져오기
	
	public  UserVO getgender(@Param("userid") String userid);
	
}

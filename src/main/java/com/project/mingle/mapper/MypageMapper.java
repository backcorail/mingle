package com.project.mingle.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.mingle.vo.UserVO;

@Mapper
@Repository
public interface MypageMapper {

	// 닉네임 중복체크
	public UserVO ddDataCheck(@Param("column")String column , @Param("data")String data);

	//회원정보 단일 수정
	public int userPut(@Param("userid")String user_id, String column, @Param("data")String data);

}

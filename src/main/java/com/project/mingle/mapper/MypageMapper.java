package com.project.mingle.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.mingle.vo.UserVO;

@Mapper
@Repository
public interface MypageMapper {

	// 데이터 중복체크
	public UserVO ddDataCheck(String column , String data);

	//회원정보 단일 수정
	public int userPut(String user_id, String column, String data);

}

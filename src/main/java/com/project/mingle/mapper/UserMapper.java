package com.project.mingle.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.mingle.vo.UserVO;

@Mapper
@Repository
public interface UserMapper {

	// 회원가입
	public int save(UserVO uservo);

	// 아이디로 찾기
	public Optional<UserVO> findById(@Param("userId") String userId);
	
	//회원정보수정
	public int userUpdate(UserVO uservo);

	//회원탈퇴
	public int deleteById(@Param("userId") String userId);

	// 아이디 중복체크
	public String iddcheck(@Param("checkid")String checkid);
	
	
	

}

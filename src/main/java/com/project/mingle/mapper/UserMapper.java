package com.project.mingle.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.mingle.vo.UserVO;

@Mapper
@Repository
public interface UserMapper {

	// 회원가입
	public int save(UserVO uservo);
	
	// 아이디 중복체크
	public UserVO iddcheck(@Param("checkid")String checkid);

	// 닉네임 중복체크
	public UserVO nickcheck(@Param("checknick")String checknick);
	
	// 전화번호 중복 확인
	public UserVO telcheck(@Param("checktel")String checktel);	

	//로그인
	public UserVO login(UserVO userVO);
	
	//회원정보수정
	public int userUpdate(UserVO uservo);

	//회원탈퇴
	public int deleteById(@Param("userId") String userId);

	// 유저가 등록한 전화번호 일치 체크
	public UserVO idTelcheck(UserVO userVO);
	
	//비밀번호 변경
	public int pwdUpdate(UserVO userVO);
	

	

}

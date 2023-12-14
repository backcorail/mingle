package com.project.mingle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.mingle.vo.UserVO;
import com.project.mingle.vo.mypage.MyRequestVO;
import com.project.mingle.vo.mypage.MyResellVO;
import com.project.mingle.vo.mypage.MyStyleVO;
import com.project.mingle.vo.user.ResponseDto;

@Mapper
@Repository
public interface MypageMapper {

	// 데이터 중복체크
	public UserVO ddDataCheck(String column , String data);

	//회원정보 단일 수정
	public int userPut(String user_id, String column, String data);

	public int userOut(String userid);

	public List<MyRequestVO> getMyRequest(@Param("userid") String userid, @Param("defalutGetNo") int defalutGetNo);

	public List<MyResellVO> getMyResell(@Param("userid") String userid, @Param("defalutGetNo") int defalutGetNo);

	public List<MyStyleVO> getMyReStyle(@Param("userid") String userid, @Param("defalutGetNo") int defalutGetNo);

}

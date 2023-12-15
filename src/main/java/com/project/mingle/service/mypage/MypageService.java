package com.project.mingle.service.mypage;

import java.util.List;

import com.project.mingle.vo.mypage.MyActInfo;
import com.project.mingle.vo.mypage.MyboardRequestVO;
import com.project.mingle.vo.user.CheckVO;
import com.project.mingle.vo.user.ResponseDto;

public interface MypageService {

	ResponseDto<String> userPut(String userid, CheckVO checkVO);

	int userOut(String name);

	List<MyActInfo> myboard(String userid, MyboardRequestVO myboardRequestVO);
	
	List<MyActInfo> myReply(String userid, MyboardRequestVO myboardRequestVO);

	List<MyActInfo> mysellist(String userid, MyboardRequestVO myboardRequestVO);

}

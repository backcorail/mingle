package com.project.mingle.service.mypage;

import com.project.mingle.vo.user.CheckVO;
import com.project.mingle.vo.user.ResponseDto;

public interface MypageService {

	ResponseDto<String> userPut(String userid, CheckVO checkVO);

	int userOut(String name);

}

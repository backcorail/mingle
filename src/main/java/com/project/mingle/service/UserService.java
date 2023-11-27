package com.project.mingle.service;

import com.project.mingle.vo.UserVO;

public interface UserService {
	
	public int save(UserVO userVO);

	public String iddcheck(String checkid);

}

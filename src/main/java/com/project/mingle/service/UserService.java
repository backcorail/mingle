package com.project.mingle.service;

import com.project.mingle.vo.UserVO;
import com.project.mingle.vo.user.JoinUserVO;

public interface UserService {
	
	public int save(JoinUserVO joinUserVO );

	public UserVO iddcheck(String checkid);

	public UserVO nickcheck(String checknick);

	public UserVO login(JoinUserVO joinUserVO);

	public UserVO idTelcheck(JoinUserVO joinUserVO);

	public UserVO telcheck(String checktel);

	public int pwdUpdate(JoinUserVO joinUserVO);

}

package com.project.mingle.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.mingle.mapper.UserMapper;
import com.project.mingle.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	UserMapper userMapper;

	@Override
	public int save(UserVO userVO) {
		// TODO Auto-generated method stub
		System.out.println("usersTest : UserServiceImpl");
		return userMapper.save(userVO);
	}

	@Override
	public String iddcheck(String checkid) {
		// TODO Auto-generated method stub
		return userMapper.iddcheck(checkid);
	}


	
}

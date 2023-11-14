package com.project.mingle.test;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	UserMapper mapper;

	@Override
	public int userInsert(UserVO vo) {
		// TODO Auto-generated method stub
		System.out.println("usersTest : UserServiceImpl");
		return mapper.userInsert(vo);
	}

	@Override
	public String nameCheck(String username) {
		return mapper.nameCheck(username);
		// TODO Auto-generated method stub
		
	}

	
}

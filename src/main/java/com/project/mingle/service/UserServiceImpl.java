package com.project.mingle.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.project.mingle.mapper.UserMapper;
import com.project.mingle.vo.UserVO;
import com.project.mingle.vo.user.JoinUserVO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	UserMapper userMapper;
	
	@Autowired
	PlatformTransactionManager  platformTransactionManager;
	@Autowired
	TransactionDefinition transactionDefinition;

	@Override
	public int save(JoinUserVO joinUserVO ) {
		// TODO Auto-generated method stub
		System.out.println("save : UserServiceImpl");
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		int saveResult=0;
        try {
    		UserVO userVO = UserVO.builder()
    				.user_id(joinUserVO.getUserid())
    				.user_pwd(joinUserVO.getUserpwd())
    				.user_nick(joinUserVO.getUsernick())
    				.user_tel(joinUserVO.getUsertel())
    				.user_status(1)
    				.build();
    		System.out.println("\n 서비스 레이어 userVO build 이후 값");
    		System.out.println(userVO.toString());
        	saveResult = userMapper.save(userVO);
            platformTransactionManager.commit(transactionStatus); // 성공 시 커밋
        } catch (Exception e) {
            platformTransactionManager.rollback(transactionStatus); // 예외 발생 시 롤백
            
        }
		return saveResult;
	}

	@Override
	public UserVO iddcheck(String checkid) {
		// TODO Auto-generated method stub
		return userMapper.iddcheck(checkid);
	}

	@Override
	public UserVO nickcheck(String checknick) {
		// TODO Auto-generated method stub
		return userMapper.nickcheck(checknick);
	}

	@Override
	public UserVO login(JoinUserVO joinUserVO) {
		// TODO Auto-generated method stub
		UserVO userVO = UserVO.builder()
				.user_id(joinUserVO.getUserid())
				.user_pwd(joinUserVO.getUserpwd())
				.build();
		System.out.println("\n 서비스 레이어 userVO build 이후 값");
		System.out.println(userVO.toString());
		return userMapper.login(userVO);
	}


	
}

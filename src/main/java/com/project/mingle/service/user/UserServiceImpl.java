package com.project.mingle.service.user;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.project.mingle.mapper.UserMapper;
import com.project.mingle.vo.UserVO;
import com.project.mingle.vo.user.JoinUserVO;
import com.project.mingle.vo.user.OauthJoinUserVO;
import com.project.mingle.vo.user.ResponseDto;
import com.project.mingle.vo.user.UserResp;

@Service
public class UserServiceImpl implements UserService {

	 private static final int MAX_LOGIN_ATTEMPTS = 5;
	 
	@Inject
	UserMapper userMapper;
	@Autowired	
	HttpSession session; 
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	PlatformTransactionManager  platformTransactionManager;
	@Autowired
	TransactionDefinition transactionDefinition;

	@Override
	public int save(JoinUserVO joinUserVO ) {
		// TODO Auto-generated method stub
		System.out.println("save : UserServiceImpl");
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		
		String rawPwd = joinUserVO.getUserpwd();
		String encodedPwd = passwordEncoder.encode(rawPwd);
		int saveResult=0;
        try {
    		UserVO userVO = UserVO.builder()
    				.user_id(joinUserVO.getUserid())
    				.user_pwd(encodedPwd)
    				.user_nick(joinUserVO.getUsernick())
    				.user_tel(joinUserVO.getUsertel())
    				.user_role("ROLE_USER")
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
	public int saveOauth(OauthJoinUserVO oauthJoinUserVO  ) {
		// TODO Auto-generated method stub
		System.out.println("save : UserServiceImpl");
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		
		String rawPwd = oauthJoinUserVO.getUserpwd();
		String encodedPwd = passwordEncoder.encode(rawPwd);
		int saveResult=0;
        try {
    		UserVO userVO = UserVO.builder()
    				.user_id(oauthJoinUserVO.getUserid())
    				.user_pwd(encodedPwd)
    				.user_nick(oauthJoinUserVO.getUsernick())
    				.user_Oauth(oauthJoinUserVO.getUserOauth())
    				.user_role("ROLE_USER")
    				.user_status(1)
    				.build();
    		System.out.println("\n 서비스 레이어 userVO build 이후 값");
    		System.out.println(userVO.toString());
        	saveResult = userMapper.saveOauth(userVO);
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
	public ResponseDto<String> login(JoinUserVO joinUserVO) {
		// TODO Auto-generated method stub
		UserVO userVO = UserVO.builder()
				.user_id(joinUserVO.getUserid())
				.user_pwd(joinUserVO.getUserpwd())
				.build();
		System.out.println("\n 서비스 레이어 userVO build 이후 값");
		System.out.println(userVO.toString());
		userVO = userMapper.login(userVO);
		
		// 로그인시도 횟수 측정
		Integer loginAttempts = (Integer) session.getAttribute("LOGIN_ATTEMPTS");
        // 로그인 시도 횟수 초기화
        if (loginAttempts == null) {
            loginAttempts = 0;
        }

        if (userVO !=null) {
            // 로그인 성공 로직
        	session.removeAttribute("LOGIN_ATTEMPTS"); // 성공 시 로그인 시도 횟수 제거
        	System.out.println(userVO.toString());
        	System.out.println("로그인 성공");
            return new ResponseDto<String>(UserResp.LOGINOK.getValue(),"로그인에 성공하였습니다."); 
        } else {
            loginAttempts++;
            session.setAttribute("LOGIN_ATTEMPTS", loginAttempts);

            if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
                // 최대 시도 횟수 초과 처리
            	System.out.println("로그인을 "+loginAttempts+" 회 실패하였습니다.");
            	System.out.println("캡차로 이동");
            	return new ResponseDto<String>(UserResp.LOGINATTEMPTS.getValue(),"캡차로 이동");
            }
            System.out.println("로그인을 "+loginAttempts+" 회 실패하였습니다.");
            return new ResponseDto<String>(UserResp.LOGINFAILD.getValue(),"로그인을 "+loginAttempts+" 회 실패하였습니다.");
        }
	}

	@Override
	public UserVO idTelcheck(JoinUserVO joinUserVO) {
		// TODO Auto-generated method stub
		UserVO userVO = UserVO.builder()
				.user_id(joinUserVO.getUserid())
				.user_tel(joinUserVO.getUsertel())
				.build();
		System.out.println("\n 서비스 레이어 idTelcheck userVO build 이후 값");
		System.out.println(userVO.toString());
		return userMapper.idTelcheck(userVO);
	}

	@Override
	public UserVO telcheck(String checktel) {
		// TODO Auto-generated method stub
		return userMapper.telcheck(checktel);
	}

	@Override
	public int pwdUpdate(JoinUserVO joinUserVO) {
		// TODO Auto-generated method stub
		UserVO userVO = UserVO.builder()
				.user_id(joinUserVO.getUserid())
				.user_pwd(joinUserVO.getUserpwd())
				.build();
		System.out.println("\n 서비스 레이어 idTelcheck userVO build 이후 값");
		System.out.println(userVO.toString());
		int updateResult = userMapper.pwdUpdate(userVO);
		return updateResult;
	}

	
}

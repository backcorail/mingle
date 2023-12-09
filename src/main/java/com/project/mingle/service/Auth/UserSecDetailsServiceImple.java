package com.project.mingle.service.Auth;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.mingle.config.Auth.UserSecDetails;
import com.project.mingle.mapper.UserMapper;
import com.project.mingle.vo.UserVO;

@Service
public class UserSecDetailsServiceImple implements UserDetailsService {

    @Inject
    UserMapper userMapper;
    
    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
    	System.out.println("UserSecDetailsServiceImple  loadUserByUsername() 호출확인");
    	System.out.println("UserSecDetailsServiceImple "+userid);
    	
        UserVO userVO = userMapper.iddcheck(userid);
        
        if (userVO == null) {
        	System.out.println("UserSecDetailsServiceImple 사용자 없음.");
//            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.: " + userid);
        	 return null;
        }
        return new UserSecDetails(userVO);
    }
}


package com.project.mingle.service.Auth;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.mingle.config.Auth.AdminSecDetails;
import com.project.mingle.mapper.UserMapper;
import com.project.mingle.vo.AdminLoginVO;

@Service
public class AdminSecDetailsServiceImple implements UserDetailsService {

    @Inject
    UserMapper userMapper;
    
    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
    	System.out.println("AdminSecDetailsServiceImple  loadUserByUsername() 호출확인");
    	System.out.println("AdminSecDetailsServiceImple "+userid);
    	
    	AdminLoginVO adminLoginVO = userMapper.adminIddcheck(userid);
        
        if (adminLoginVO == null) {
        	System.out.println("AdminSecDetailsServiceImple 사용자 없음.");
//            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.: " + userid);
        	 return null;
        }else {
        	System.out.println("AdminSecDetailsServiceImple 기존가입자.");
        	System.out.println("AdminSecDetailsServiceImple.loadUserByUsername() ->userVO.getUser_id() : " + adminLoginVO.getAdmin_id());
        }
        
        return new AdminSecDetails(adminLoginVO);
    }
}


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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO userVO = userMapper.iddcheck(username);
        if (userVO == null) {
            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.: " + username);
        }
        return new UserSecDetails(userVO);
    }
}


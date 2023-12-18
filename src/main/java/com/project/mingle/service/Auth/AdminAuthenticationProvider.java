package com.project.mingle.service.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.mingle.mapper.UserMapper;
import com.project.mingle.vo.AdminLoginVO;
import com.project.mingle.vo.UserVO;

@Service
public class AdminAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	UserMapper userMapper;
	
    private final AdminSecDetailsServiceImple adminSecDetailsServiceImple ;
    private final PasswordEncoder passwordEncoder;

	public AdminAuthenticationProvider(AdminSecDetailsServiceImple adminSecDetailsServiceImple, PasswordEncoder passwordEncoder) {
        this.adminSecDetailsServiceImple = adminSecDetailsServiceImple;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	System.out.println("AdminAuthenticationProvider authenticate 호출 확인");
        String adminrid = authentication.getName();
        String adminpwd = authentication.getCredentials().toString();

        System.out.println("Provider adminrid : "+ adminrid);
        System.out.println("Provider adminpwd : "+ adminpwd);
        
        UserDetails userDetails = adminSecDetailsServiceImple.loadUserByUsername(adminrid);
        
   	
        if (userDetails == null) {
        	System.out.println("등록되지 않은 관리자");
    		String rawPwd = adminpwd;
    		String encodedPwd = passwordEncoder.encode(rawPwd);
            AdminLoginVO adminLoginVO = AdminLoginVO.builder()
    				.admin_id(adminrid)
    				.admin_pwd(encodedPwd)
    				.admin_role("ROLE_ADMIN")
    				.build();     
        	userMapper.adminsave(adminLoginVO);
        	userDetails = adminSecDetailsServiceImple.loadUserByUsername(adminrid);
        }else {
        	System.out.println("등록된 관리자.");
        }
//        if (userDetails == null) {
//        	System.out.println("AdminAuthenticationProvider userDetails 사용자 없음.");
//            throw new UsernameNotFoundException("User not found");
//        } 
//
//        if (!passwordEncoder.matches(adminrid, userDetails.getPassword())) {
//        	System.out.println("AdminAuthenticationProvider userDetails 비밀번호 오류");
//            throw new BadCredentialsException("Invalid password");
//        }
        System.out.println("AdminAuthenticationProvider userDetails 토큰생성 직전 " + userDetails.getUsername());
        System.out.println("AdminAuthenticationProvider userDetails 토큰생성 직전 " + userDetails.getPassword());
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

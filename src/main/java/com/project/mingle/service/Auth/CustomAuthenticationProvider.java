package com.project.mingle.service.Auth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserSecDetailsServiceImple userSecDetailsServiceImple;
    private final PasswordEncoder passwordEncoder;

	public CustomAuthenticationProvider(UserSecDetailsServiceImple userSecDetailsServiceImple, PasswordEncoder passwordEncoder) {
        this.userSecDetailsServiceImple = userSecDetailsServiceImple;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	System.out.println("Provider authenticate 호출 확인");
        String userid = authentication.getName();
        String userpwd = authentication.getCredentials().toString();

        System.out.println("Provider userid : "+ userid);
        System.out.println("Provider userpwd : "+ userpwd);
        
        UserDetails userDetails = userSecDetailsServiceImple.loadUserByUsername(userid);
        if (userDetails == null) {
        	System.out.println("Provider userDetails 사용자 없음.");
            throw new UsernameNotFoundException("User not found");
        } 

        if (!passwordEncoder.matches(userpwd, userDetails.getPassword())) {
        	System.out.println("Provider userDetails 비밀번호 오류");
            throw new BadCredentialsException("Invalid password");
        }
        
        
        System.out.println("Provider userDetails 토큰생성 직전 " + userDetails.getUsername());
        System.out.println("Provider userDetails 토큰생성 직전 " + userDetails.getPassword());
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//        return new UsernamePasswordAuthenticationToken(userid, userpwd, userDetails.getAuthorities());
        
        // authenticate 가 끝나면 CustomAuthenticationSuccessHandler 호출
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
	
	
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean supports(Class<?> authentication) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}

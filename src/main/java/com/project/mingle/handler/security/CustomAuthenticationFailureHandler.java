package com.project.mingle.handler.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.mingle.vo.user.ResponseDto;
import com.project.mingle.vo.user.UserResp;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
	
	private static final int MAX_LOGIN_ATTEMPTS = 5;
	

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // 로그인 실패 카운트 증가 로직
    	System.out.println("onAuthenticationFailure  로그인 실패 호출 : ");
        Integer loginAttempts = (Integer) request.getSession().getAttribute("LOGIN_ATTEMPTS");
        if (loginAttempts == null) {
            loginAttempts = 0;
        }
        loginAttempts++;
        request.getSession().setAttribute("LOGIN_ATTEMPTS", loginAttempts);

        
        
        ObjectMapper mapper = new ObjectMapper();
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
//        response.setContentType("application/json"); // 있든없든 상관없다.
        
        ResponseDto<String> responseDto = new ResponseDto<String>();
       
        // 실패 원인에 따른 처리
        if (exception instanceof BadCredentialsException) {
            // 비밀번호 오류 처리
        	System.out.println("실패 핸들러 원인 비밀번호 오류  BadCredentialsException");
        	responseDto.setStatus(UserResp.PASSWORDFAILD.getValue()); //192 // 비밀번호 오류
        	responseDto.setRes("비밀번호가 다릅니다. \n로그인 "+loginAttempts+" 회 실패");
//        response.sendRedirect("/login?error=password");
        } else if (exception instanceof UsernameNotFoundException) {
            // 아이디 오류 처리
        	System.out.println("실패 핸들러 원인 아이디 없음  UsernameNotFoundException");
        	responseDto.setStatus(UserResp.USERIDOK.getValue()); //101  // 가입된 아이디 없음
        	responseDto.setRes("사용자 아이디가 없습니다. \n로그인 "+loginAttempts+" 회 실패하였습니다.");
        }
        

        // 최대 시도 횟수 초과 시 캡차 페이지로 리디렉션
        if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
        	System.out.println("loginAttempts "+ loginAttempts);
        	responseDto.setStatus(UserResp.LOGINATTEMPTS.getValue()); //143  // 가입된 아이디 없음
        	responseDto.setRes("로그인 5회 이상 실패 하셨습니다.\n캡차인증 로그인으로 이동합니다.");
        }
        
        response.getWriter().println(mapper.writeValueAsString(responseDto));
        response.getWriter().flush();
    }
}


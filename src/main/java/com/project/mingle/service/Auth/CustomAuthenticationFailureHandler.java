package com.project.mingle.service.Auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
	
	private static final int MAX_LOGIN_ATTEMPTS = 5;
	

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // 로그인 실패 카운트 증가 로직
        Integer loginAttempts = (Integer) request.getSession().getAttribute("LOGIN_ATTEMPTS");
        if (loginAttempts == null) {
            loginAttempts = 0;
        }
        loginAttempts++;
        request.getSession().setAttribute("LOGIN_ATTEMPTS", loginAttempts);

        // 실패 원인에 따른 처리
        if (exception instanceof BadCredentialsException) {
            // 비밀번호 오류 처리
            response.sendRedirect("/login?error=password");
        } else if (exception instanceof UsernameNotFoundException) {
            // 아이디 오류 처리
            response.sendRedirect("/login?error=username");
        }

        // 최대 시도 횟수 초과 시 캡차 페이지로 리디렉션
        if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
            response.sendRedirect("/captcha");
        }
    }
}


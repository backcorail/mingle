package com.project.mingle.handler.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.mingle.vo.user.ResponseDto;
import com.project.mingle.vo.user.UserResp;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
    	System.out.println("onAuthenticationSuccess  로그인 성공 호출 : ");
    	
        request.getSession().removeAttribute("LOGIN_ATTEMPTS"); // 성공 시 로그인 시도 횟수 제거
    	
        ObjectMapper mapper = new ObjectMapper();
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        ResponseDto<String> responseDto = new ResponseDto<String>();
    	responseDto.setStatus(UserResp.LOGINOK.getValue()); //141 // 로그인 성공
    	responseDto.setRes("사용자 확인 성공");
        response.getWriter().println(mapper.writeValueAsString(responseDto));
        response.getWriter().flush();
    }
}

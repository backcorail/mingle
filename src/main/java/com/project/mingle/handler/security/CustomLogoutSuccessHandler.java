package com.project.mingle.handler.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.mingle.vo.user.ResponseDto;
import com.project.mingle.vo.user.UserResp;

@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        
    	System.out.println("CustomLogoutSuccessHandler 호출확인 ");
    	ObjectMapper mapper = new ObjectMapper();
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        ResponseDto<String> responseDto = new ResponseDto<String>();
    	responseDto.setStatus(UserResp.LOGOUTOK.getValue()); //144// 로그아웃 성공
    	responseDto.setRes("로그아웃 성공");
        response.getWriter().println(mapper.writeValueAsString(responseDto));
        response.getWriter().flush();  
    }
}


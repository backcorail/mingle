package com.project.mingle.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@Value("${N_CAP_IMG_CLIENT_ID}")
	private String CLIENT_ID;
	
	@Value("${N_CAP_IMG_CLIENT_SEC}")
	private String CLIENT_SEC;
	
	
	// 로그인 - 회원가입 폼
	// http://localhost:9998/mingle/user/login_joinForm
	@GetMapping("/user/login_joinForm")
	public String joinForm(HttpSession session) {
		System.out.println("CLIENT_ID -> " +CLIENT_ID);
		System.out.println("CLIENT_SEC -> " +CLIENT_SEC);
		String contextName = session.getServletContext().toString();
		System.out.println("1) contextName : "+contextName);
		
		String ContextPath = session.getServletContext().getContextPath();
		System.out.println("2) ContextPath : "+ContextPath);
		
		String cssPath = session.getServletContext().getRealPath("/css");
		System.out.println("3) cssPath : "+cssPath);
		
		String captempfilePath = session.getServletContext().getRealPath("/captempfile");
		System.out.println("4) captempfilePath : "+captempfilePath);
			
		
		return "user/login_joinForm";
	}

}

package com.project.mingle.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	// 로그인 - 회원가입 폼
	// http://localhost:9998/mingle/user/login_joinForm
	@GetMapping("/user/login_joinForm")
	public String joinForm(HttpSession session) {
		System.out.println("joinForm 맵핑");
		return "user/login_joinForm";
	}
	
	@GetMapping("/mypage")
	public String mypage(HttpSession session) {
		System.out.println("mypage 맵핑");
		return "home";
	}


}

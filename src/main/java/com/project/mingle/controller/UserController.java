package com.project.mingle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	// 로그인 - 회원가입 폼
	// http://localhost:9998/mingle/user/login_joinForm
	@GetMapping("/user/login_joinForm")
	public String joinForm() {
		return "user/login_joinForm";
	}

}

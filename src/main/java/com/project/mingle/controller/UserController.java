package com.project.mingle.controller;

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
	public String joinForm() {
		System.out.println("CLIENT_ID -> " +CLIENT_ID);
		System.out.println("CLIENT_SEC -> " +CLIENT_SEC);
		return "user/login_joinForm";
	}

}

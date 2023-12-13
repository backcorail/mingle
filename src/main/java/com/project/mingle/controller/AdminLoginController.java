package com.project.mingle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminLoginController {

	// http://localhost:9998/mingle/admin/loginForm
	@GetMapping("/admin/loginForm")
	public String loginForm() {
		System.out.println("AdminLoginController.loginForm() -> 로그인 호출확인. : " );
		return "admin/admin_loginForm";
	}
}

package com.project.mingle.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionTestController {

	@GetMapping("/test")
	public void sessionTest(Principal principal) {
		if(principal==null) {
			System.out.println("로그인한 사용자 아님");
		}else {
			System.out.println("로그인한 사용자" +principal );
			System.out.println("로그인한 사용자" +principal.getName());
		}	
	}
}

package com.project.mingle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.mingle.service.NaverApiService;

@RestController
public class NaverAPIController {
	
	@Autowired
	NaverApiService naverApiService;
	
	@GetMapping("/user/captcha")
	public String	captcha() {
		
		String result = naverApiService.request();
		
		return result;
	}
}

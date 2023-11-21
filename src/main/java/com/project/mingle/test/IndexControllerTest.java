package com.project.mingle.test;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexControllerTest {
	
	@GetMapping({"/",""})
	public String index() {
		System.out.println("index :  테스트" );
		return "test/index";
	}
}

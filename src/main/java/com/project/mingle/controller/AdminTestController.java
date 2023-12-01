package com.project.mingle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

@RequestMapping("/admintest")
public class AdminTestController {
	
	@GetMapping("")
	public String admintest() {
		return "admin/admin_test";
	}
	
	@GetMapping("/layout_static")
	public String layout_static() {
		return "admin/layout_static";	
	}
	
	@GetMapping("/charts")
	public String charts() {
		return "admin/charts";	
	}
	
	@GetMapping("/tables")
	public String tables() {
		return "admin/tables";	
	}
	
}
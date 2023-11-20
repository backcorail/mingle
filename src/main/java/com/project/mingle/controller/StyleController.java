package com.project.mingle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StyleController {
	
	@GetMapping("/style")
	public String Style_trendboard() {
		return "style/style_trendboard";
	}
	
	@GetMapping("/style/ranking")
	public String Style_ranking() {
		return "style/style_ranking";
	}
}
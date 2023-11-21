package com.project.mingle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/style")
public class StyleController {

	@GetMapping("/main")
	public String style_main() {
		return "style/style_main";
	}

	@GetMapping("/ranking")
	public String style_ranking() {
	
		return "style/style_ranking";
	}
	
	@GetMapping("/request")
	public String style_request() {
		
		return "style/style_request";
	}
	
	@GetMapping("/styles")
	public String style_styles() {
		
		return "style/style_styles";
	}
	
	@GetMapping("/trend")
	public String style_trend() {
		
		return "style/style_trend";
	}

}
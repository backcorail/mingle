package com.project.mingle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CodyController {

	@GetMapping("/cody")
	public String cody_board(){
		return "cody/cody_board";
	}
	
	
	
}

package com.project.mingle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/resell")

public class ResellController {
	
	@GetMapping("")
	public String resellMain() {
		return "resell/resell_main";
	}

	@GetMapping("/board")
	public String resell_board() {
		return "resell/resell_board";
	}
}

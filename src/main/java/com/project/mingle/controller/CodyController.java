package com.project.mingle.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CodyController {
	
	@GetMapping("/cody")
	public String cody(){
		return "cody/cody";
	}
	@GetMapping("/cody_board")
	public String cody_board() {
		return "cody/cody_board";
	}
}

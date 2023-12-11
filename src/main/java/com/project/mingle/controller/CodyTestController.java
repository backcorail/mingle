package com.project.mingle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CodyTestController {
	
	
	@RequestMapping(value="/action", method = RequestMethod.POST)
	@ResponseBody
	public String test(@RequestParam("place") String p, @RequestParam("situation") String s, Model model) {
		model.addAttribute("place", p);
		model.addAttribute("situation", p);
		return "OK";
	}
	
	@RequestMapping("/co")
	public String main(Model model) {
		model.addAttribute("data", "hello rozy~!");
		return "index";
	}
	
	
	
	
}

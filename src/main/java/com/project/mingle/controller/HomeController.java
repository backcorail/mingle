package com.project.mingle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.mingle.service.HomeService;
import com.project.mingle.vo.ResellVO;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	HomeService service;
	
	
	@GetMapping("")
	public String home(Model model, ResellVO rvo) {
		List<ResellVO> kreamList = service.kreamList(rvo);
		model.addAttribute("rvo", rvo);
		model.addAttribute("kreamList", kreamList.subList(1, 6));
    
		return "home";
	}
}

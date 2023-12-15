package com.project.mingle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.mingle.service.HomeService;
import com.project.mingle.service.StyleService;
import com.project.mingle.vo.ResellVO;
import com.project.mingle.vo.StyleVO;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	HomeService service;
	@Autowired
	StyleService service2;
	
	@GetMapping("")
	public String home(Model model, ResellVO rvo, StyleVO sVO) {
		List<ResellVO> kreamList = service.kreamList(rvo);
		List<StyleVO> kreamList2 = service2.kreamData(sVO);
		model.addAttribute("rvo", rvo);
		model.addAttribute("sVO", sVO);
		model.addAttribute("kreamList", kreamList.subList(1, 6));
		model.addAttribute("kreamList2", kreamList2.subList(1, 7));
    
		return "home";
	}
}

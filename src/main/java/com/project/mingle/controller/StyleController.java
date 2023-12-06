package com.project.mingle.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.mingle.service.StyleService;
import com.project.mingle.vo.StyleVO;

@Controller

@RequestMapping("/style")
public class StyleController {
	@Autowired
	StyleService service;

	@GetMapping("")
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
	
	@GetMapping("/trend/info")
	public String style_trendinfo() {
		return "style/style_trendinfo";
	}
	
	@GetMapping("/write")
	public String style_stylewrite() {
		return "style/style_write";
	}
	
	@GetMapping("/requestwrite")
	public String style_requestwrite() {
		return "style/request_write";
	}
	
	@PostMapping("/writeOk")
	public ModelAndView styleWriteOk(StyleVO vo, HttpServletRequest request, Principal principal) {
		ModelAndView mav = new ModelAndView();
		vo.setUser_id(principal.getName());
		
		int result = service.styleInsert(vo);
		if (result > 0) {
			mav.setViewName("redirect:list");
		} else {
			mav.addObject("msg", "등록");
			mav.setViewName("board/boardResult");
		}
		return mav;
		
	}
	
	
	@GetMapping("/map")
	public String style_map() {
		return "style/map";
	}

}
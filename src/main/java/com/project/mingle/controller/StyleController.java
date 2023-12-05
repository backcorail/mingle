package com.project.mingle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.mingle.service.StyleService;
import com.project.mingle.vo.StyleVO;

@Controller

@RequestMapping("/style")
public class StyleController {

	@Autowired
	StyleService service; // 서비스의 내용을 가져온다.
	
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
	public ModelAndView style_styles(StyleVO sVO) {
		ModelAndView mav =  new ModelAndView();
		
		List<StyleVO> kreamList = service.kreamData(sVO);
		mav.addObject("sVO", sVO);
		mav.addObject("klist", kreamList);
		
		mav.setViewName("style/style_styles");	
		return mav;
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
	
	@GetMapping("/map")
	public String style_map() {
		return "style/map";
	}

}
package com.project.mingle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.mingle.service.ResellService;
import com.project.mingle.vo.ResellVO;

@Controller
@RequestMapping("/resell")
public class ResellController {
	
	@Autowired
	ResellService service;

	@GetMapping("")
	public ModelAndView resell_main(ResellVO rVO) {
		ModelAndView mav = new ModelAndView();
		// 총 레코드 수(resell_totalRecord)
		rVO.setTotalRecord(service.resell_totalRecord(rVO));
		// 게시글 데이터
		List<ResellVO> list = service.resell_boardData(rVO);
		mav.addObject("rVO", rVO);
		mav.addObject("list", list);
		mav.setViewName("resell/resell_main");
		return mav;
	}
	
	@GetMapping("/board")
	public String resell_board() {
		return "resell/resell_board";
	}
	
	@GetMapping("/write")
	public String resell_write() {
		return "/resell/resell_write";
	}
}

package com.project.mingle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.mingle.service.ResellService;
import com.project.mingle.vo.ResellVO;

@Controller
@RequestMapping("/resell")
public class ResellController {
	
	@Autowired
	ResellService service;

	@GetMapping("")
	public ModelAndView resell_main(@RequestParam(name="page", required = false) Integer page, ResellVO rVO) {
		ModelAndView mav = new ModelAndView();
		int currentPage = (page != null) ? page : 1;
		// 총 레코드 수(resell_totalRecord)
		rVO.setTotalRecord(service.resell_totalRecord(rVO));
		rVO.setKtotalRecord(service.kream_totalRecord(rVO));
		// 총 페이지수 계산을 setTotalPage 메소드에서 계산
		rVO.setNowPage(currentPage);
		rVO.setTotalPage();
		rVO.setKtotalPage();
		// 게시글 데이터
		List<ResellVO> list = service.resell_boardData(rVO);
		List<ResellVO> kreamList = service.kreamData(rVO);
		
		mav.addObject("rVO", rVO);
		mav.addObject("list", list);
		mav.addObject("klist", kreamList);
		mav.setViewName("resell/resell_main");
		return mav;
	}
	
	@GetMapping("/board")
	public ModelAndView resell_board(@RequestParam(name="no") Integer no, @RequestParam(name="page") Integer page, ResellVO rVO) {
		ModelAndView mav = new ModelAndView();
		rVO.setNowPage(page);
		
		List<ResellVO> kreamList = service.kreamData(rVO);
		mav.addObject("rVO", rVO);
		mav.addObject("klist", kreamList);
		
		mav.setViewName("resell/resell_board");
		return mav;
	}
	
	@GetMapping("/write")
	public ModelAndView resell_write() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("resell/resell_write");
		return mav;
	}
}

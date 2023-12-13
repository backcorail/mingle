package com.project.mingle.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.mingle.service.AdminService;
import com.project.mingle.service.RequestService;
import com.project.mingle.service.ResellService;
import com.project.mingle.vo.AdminTestVO;
import com.project.mingle.vo.AdminVO;
import com.project.mingle.vo.RequestVO;
import com.project.mingle.vo.ResellVO;

@Controller

@RequestMapping("/admintest")
public class AdminTestController {
	@Autowired
	AdminService service; 
	@Autowired
	ResellService resellservice;
	@Autowired
	RequestService requestservice;
	
	@GetMapping("")
	public String admintest() {
		return "admin/admin_test";
	}
	
	@GetMapping("/layout_static")
	public String layout_static() {
		return "admin/layout_static";	
	}
	
	@GetMapping("/members_data")
	public ModelAndView members_data(AdminTestVO rVO) {
		ModelAndView mav = new ModelAndView();
		
		//사용자 데이터
		List<AdminTestVO> userlist = service.usersData(rVO);
		
		mav.addObject("userlist", userlist);
		mav.setViewName("admin/members_data");
		return mav;
	}
	
	@GetMapping("/members_charts")
	public ModelAndView members_charts(AdminTestVO rVO) {
		ModelAndView mav = new ModelAndView();
		
		// 현재 날짜와 시간 가져오기
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy 'at' hh:mm a");
		String formattedDate = now.format(formatter);
		
		//총 유저 수 카운트
		int userCount = service.countUsers();
		System.out.println("User Count : " +userCount);
		
		mav.addObject("currentDateTime", formattedDate);
		mav.addObject("userCount", userCount);
		mav.setViewName("admin/members_charts");
		return mav;
		
	}
	
	@GetMapping("/products_data")
	public ModelAndView products_data(AdminVO rVO) {
		ModelAndView mav = new ModelAndView();
		
		//게시글 데이터
		//List<AdminVO> list = service.resell_boardData(rVO);
		List<AdminVO> kreamlist = service.kreamData(rVO);
		
		//사용자 데이터
		List<AdminTestVO> userlist = service.usersData(new AdminTestVO());

		mav.addObject("rVO", rVO);
		mav.addObject("klist", kreamlist);
		mav.addObject("userlist", userlist);
		mav.setViewName("admin/products_data");
		return mav;
	}
	
	@GetMapping("transactions_data")
	public ModelAndView transactions_data() {
		ModelAndView mav = new ModelAndView();
		ResellVO rVO = new ResellVO();
		
		//리셀 데이터
		List<ResellVO> boardList = resellservice.resell_boardData(rVO);
		
		mav.addObject("boardList", boardList);
		mav.setViewName("admin/transactions_data");
		return mav;
	}
	
	@GetMapping("transactions_charts")
	public String transactions_charts() {
		return "admin/transactions_charts";
	}
	
	@GetMapping("posts_data")
	public ModelAndView postsData() {
	    ResellVO rVO = new ResellVO();
	    List<ResellVO> boardList = resellservice.resell_boardData(rVO);
	    
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("boardList", boardList);
	    mav.setViewName("admin/posts_data");
	    return mav;
	}

	@GetMapping("recommend_data")
	public String recommend_data() {
		return"admin/recommend_data";
	}
	
	@GetMapping("/charts")
	public String charts() {
		return "admin/charts";	
	}
	
	@GetMapping("/tables")
	public String tables() {
		return "admin/tables";	
	}
	
}

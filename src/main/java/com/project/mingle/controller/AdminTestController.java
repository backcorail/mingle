package com.project.mingle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.mingle.service.AdminService;
import com.project.mingle.vo.AdminTestVO;
import com.project.mingle.vo.AdminVO;


@Controller

@RequestMapping("/admintest")
public class AdminTestController {
	
	@Autowired
	AdminService service; 
	

	
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
	
	@GetMapping("/charts")
	public String charts() {
		return "admin/charts";	
	}
	
	@GetMapping("/tables")
	public String tables() {
		return "admin/tables";	
	}
	
}

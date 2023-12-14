package com.project.mingle.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		//성별 카운트
		 int maleCount = service.countByGender(1); // 남성 카운트
		 int femaleCount = service.countByGender(2); // 여성 카운트
		 
		mav.addObject("currentDateTime", formattedDate);
		mav.addObject("userCount", userCount);
		mav.addObject("maleCount", maleCount); 
		mav.addObject("femaleCount", femaleCount); 
		mav.setViewName("admin/members_charts");
		return mav;	
	}
	
	@GetMapping("/products_data")
	public ModelAndView products_data(
		@RequestParam(name="no", defaultValue="0") int no,
		@RequestParam(name="page", defaultValue="1") int page,
		@RequestParam(name="search", defaultValue="") String[] search,
		@RequestParam(name="category", defaultValue="0") int category,
		@RequestParam(name="detail", defaultValue="0") int detail,
		@RequestParam(name="sort", defaultValue="latest_desc") String sort,
		AdminVO aVO) {
	
		ModelAndView mav = new ModelAndView();
	
	String[] main = {"All", "Men", "Women", "Other"};
	String[] title = {"Top", "Outer", "Bottom", "Shose", "Bag"};;
	String[] Top = {"전체", "맨투맨/스웨트 셔츠", "니트/스웨터", "긴소매 티셔츠", "카라 티셔츠", "반소매 티셔츠", "민소매 티셔츠", "후드 티셔츠", "스포츠 상의", "셔츠/블라우스", "기타 상의"};
	String[] Outer = {"전체", "후드 집업", "블루종", "라이더 재킷", "트러커 재킷", "슈트/블레이저 재킷", "무스탕/퍼", "카디건", "아노락", "코트", "패딩", "나일론/코치 재킷", "기타 아우터"};
	String[] Bottom = {"전체", "데님팬츠", "코튼 팬트", "슈트 팬츠/슬랙스", "트레이닝/조거 팬츠", "숏 팬츠", "스포츠 하의", "기타 바지"};
	String[] Shose = {"전체", "구두", "부츠", "힐/펌프스", "운동화", "슬리퍼", "샌들", "기타 신발"};
	String[] Bag = {"전체", "백팩", "크로스백/매신저백", "슬링백", "핸드백", "지갑", "기타 가방"};
	mav.addObject("main", main);
	mav.addObject("title", title);
	mav.addObject("Top", Top);
	mav.addObject("Outer", Outer);
	mav.addObject("Bottom", Bottom);
	mav.addObject("Shose", Shose);
	mav.addObject("Bag", Bag);
		
		//게시글 데이터
		//List<AdminVO> list = service.resell_boardData(rVO);
		List<AdminVO> kreamlist = service.kreamData(aVO);
		
		mav.addObject("aVO", aVO);
		mav.addObject("klist", kreamlist);
		mav.setViewName("admin/products_data");
		return mav;
	}
	
	@GetMapping("products_charts")
	public String products_charts() {
		return "admin/products_charts";
	}
	
	@GetMapping("transactions_data")
	public ModelAndView transactions_data() {
		ModelAndView mav = new ModelAndView();
		ResellVO rVO = new ResellVO();
		
		//리셀 데이터
		List<ResellVO> boardList = resellservice.resell_boardData(rVO);
		//사용자 데이터
		List<AdminTestVO> userlist = service.usersData(new AdminTestVO());
		
		mav.addObject("boardList", boardList);
		mav.addObject("userlist", userlist);
		mav.setViewName("admin/transactions_data");
		return mav;
	}
	
	@GetMapping("transactions_charts")
	public String transactions_charts() {
		return "admin/transactions_charts";
	}
	
	@GetMapping("posts_data")
	public ModelAndView postsData() {
	    RequestVO requestVO = new RequestVO();
	    List<RequestVO> requestList = requestservice.requestList(requestVO);
		List<AdminTestVO> userlist = service.usersData(new AdminTestVO());
	    
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("requestList", requestList);
	    mav.addObject("userlist", userlist);
	    mav.setViewName("admin/posts_data");
	    return mav;
	}
	
	@GetMapping("posts_charts")
	public String posts_charts() {
		return "admin/posts_charts";
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

package com.project.mingle.controller.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {
	
	@GetMapping("/mypage/mybasket")
	public String mybasket() {
		return "/mypage/mybasket";
	}
	@GetMapping("/mypage/myboard")
	public String myboard() {
		return "/mypage/myboard";
	}
	@GetMapping("/mypage/mybuylist")
	public String mybuylist() {
		return "/mypage/mybuylist";
	}
	@GetMapping("/mypage/myedit")
	public String myedit() {
		return "/mypage/myedit";
	}
	@GetMapping("/mypage/myfavo")
	public String myfavo() {
		return "/mypage/myfavo";
	}
	@GetMapping("/mypage/mymain")
	public String mymain() {
		return "/mypage/mymain";
	}
	@GetMapping("/mypage/myreply")
	public String myreply() {
		return "/mypage/myreply";
	}
	@GetMapping("/mypage/myscrap")
	public String myscrap() {
		return "/mypage/myscrap";
	}
	@GetMapping("/mypage/myselllist")
	public String myselllist() {
		return "/mypage/myselllist";
	}
	
}

package com.project.mingle.controller.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {
	
	//1)
	@GetMapping("/mypage/mybasket")
	public String mybasket() {
		return "/mypage/mybasket";
	}
	//2)
	@GetMapping("/mypage/myboard")
	public String myboard() {
		return "/mypage/myboard";
	}
	//3)
	@GetMapping("/mypage/mybuylist")
	public String mybuylist() {
		return "/mypage/mybuylist";
	}
	//4)
	@GetMapping("/mypage/myedit")
	public String myedit() {
		return "/mypage/myedit";
	}
	//5)
	@GetMapping("/mypage/myfavo")
	public String myfavo() {
		return "/mypage/myfavo";
	}
	//6)
	@GetMapping("/mypage/mymain")
	public String mymain() {
		return "/mypage/mymain";
	}
	//7)
	@GetMapping("/mypage/myreply")
	public String myreply() {
		return "/mypage/myreply";
	}
	//8)
	@GetMapping("/mypage/myscrap")
	public String myscrap() {
		return "/mypage/myscrap";
	}
	//9)
	@GetMapping("/mypage/myselllist")
	public String myselllist() {
		return "/mypage/myselllist";
	}
	
}

package com.project.mingle.controller.mypage;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.mingle.service.user.UserService;
import com.project.mingle.vo.UserVO;

@Controller
public class MypageController {
	
	@Autowired
	UserService userService;
	
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
	//4)회원정보 수정 => 작업중
	@GetMapping("/mypage/myedit")
	public ModelAndView myedit(Principal principal) {
		ModelAndView modelAndView = new ModelAndView();
		
		UserVO userVO = userService.iddcheck(principal.getName());
		
		modelAndView.addObject("userVO", userVO);
		modelAndView.setViewName("/mypage/myedit");
		return modelAndView;
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

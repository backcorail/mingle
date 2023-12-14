package com.project.mingle.controller.mypage;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.mingle.service.mypage.MypageService;
import com.project.mingle.service.user.UserService;
import com.project.mingle.vo.UserVO;
import com.project.mingle.vo.mypage.MyActInfo;

@Controller
public class MypageController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	MypageService mypageService;
	

	
	//1)
	@GetMapping("/mypage/mybasket")
	public ModelAndView mybasket() {
		ModelAndView modelAndView = new ModelAndView();
		// 장바구니 내역 가져오기
		
		//
		modelAndView.setViewName("/mypage/mybasket");
		return modelAndView;
	}
	//2) 내활동 -게시글 첫번째 
	@GetMapping("/mypage/myboard")
	public ModelAndView myboard(	Principal principal) {
		ModelAndView modelAndView = new ModelAndView();
		// 내작성글 가져오기
		System.out.println("MypageController.myboard() ->principal.getName() : " + principal.getName());
		String userid = principal.getName();
		List<MyActInfo> actInfos = mypageService.myboard(userid);
		modelAndView.addObject("actInfos", actInfos);
		modelAndView.setViewName("/mypage/myboard");
		return modelAndView;
	}
	//3)
	@GetMapping("/mypage/mybuylist")
	public ModelAndView mybuylist() {
		ModelAndView modelAndView = new ModelAndView();
		// 구매내역 가져오기
		
		modelAndView.setViewName("/mypage/mybuylist");
		return modelAndView;
	}
	
	//4)회원정보 수정 => 작업완료
	@GetMapping("/mypage/myedit")
	public ModelAndView myedit(Principal principal) {
		ModelAndView modelAndView = new ModelAndView();
		
		UserVO userVO = userService.iddcheck(principal.getName());
		
		modelAndView.addObject("userVO", userVO);
		modelAndView.setViewName("/mypage/myedit");
		return modelAndView;
	}
	//5) 좋아요 체크한것 
	@GetMapping("/mypage/myfavo")
	public ModelAndView myfavo() {
		ModelAndView modelAndView = new ModelAndView();
		
		
		modelAndView.setViewName("/mypage/myfavo");
		return modelAndView;	
		}
	
	//6) 마이페이지 메인 ->작업중
	@GetMapping("/mypage/mymain")
	public ModelAndView mymain(Principal principal) {
		ModelAndView modelAndView = new ModelAndView();
		
		UserVO userVO = userService.iddcheck(principal.getName());
		
		
		modelAndView.addObject("userVO", userVO);
		modelAndView.setViewName("/mypage/mymain");
		return modelAndView;
		
	}
	//7)
	@GetMapping("/mypage/myreply")
	public ModelAndView myreply() {
		ModelAndView modelAndView = new ModelAndView();
		// 데이터 가져오기
		// 댓글내역
		
		modelAndView.setViewName("/mypage/myreply");
		return modelAndView;
	}
	//8)
	@GetMapping("/mypage/myscrap")
	public ModelAndView myscrap() {
		ModelAndView modelAndView = new ModelAndView();
		// 데이터 가져오기
		//스크랩 내역
		
		modelAndView.setViewName("/mypage/myscrap");
		return modelAndView;
	}
	//9)
	@GetMapping("/mypage/myselllist")
	public ModelAndView myselllist() {
		ModelAndView modelAndView = new ModelAndView();
		// 데이터 가져오기
		// 판매내역 가져오기


		modelAndView.setViewName("/mypage/myselllist");
		return modelAndView;
	}
}

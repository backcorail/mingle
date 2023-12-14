package com.project.mingle.controller.mypage;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.mingle.service.mypage.MypageService;
import com.project.mingle.service.user.UserService;
import com.project.mingle.vo.UserVO;
import com.project.mingle.vo.mypage.MyActInfo;
import com.project.mingle.vo.mypage.MyboardRequestVO;

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
		MyboardRequestVO myboardRequestVO =new MyboardRequestVO(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
		List<MyActInfo> actInfos = mypageService.myboard(userid,myboardRequestVO);
		
		System.out.println("MypageController.myboard() ->actInfos.size() : " + actInfos.size());
		Map<String, Integer> lastmap = new HashMap<>();
		lastmap.put("리퀘스트", Integer.MAX_VALUE);
		lastmap.put("스타일", Integer.MAX_VALUE);
		lastmap.put("리셀", Integer.MAX_VALUE);
		
		for (MyActInfo myActInfo : actInfos) {
			System.out.println("myActInfo.getNo : " + myActInfo.getNo());
			System.out.println("myActInfo.getTitle : " + myActInfo.getType());
			
			if("리퀘스트".equals(myActInfo.getType())) {
				if(lastmap.get("리퀘스트") > myActInfo.getNo()) {
					lastmap.put("리퀘스트", myActInfo.getNo());
				}					
			} else if("스타일".equals(myActInfo.getType())) {
				if(lastmap.get("스타일") > myActInfo.getNo()) {
					lastmap.put("스타일", myActInfo.getNo());
				}					
			}else if("리셀".equals(myActInfo.getType())) {
				if(lastmap.get("리셀") > myActInfo.getNo()) {
					lastmap.put("리셀", myActInfo.getNo());
				}					
			}
		}
		System.out.println("lastmap.리퀘스트.getNo : " + lastmap.get("리퀘스트"));
		System.out.println("lastmap.스타일.getNo : " + lastmap.get("스타일"));
		System.out.println("lastmap.리셀.getNo : " + lastmap.get("리셀"));
		
		modelAndView.addObject("lastmap", lastmap);
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
	//7)  내활동 - 댓글 첫번째 
	@GetMapping("/mypage/myreply")
	public ModelAndView myreply(Principal principal) {
		ModelAndView modelAndView = new ModelAndView();
		// 데이터 가져오기
		// 댓글내역 스타일리플 / 리퀘스트 리플
		// 내작성글 가져오기
		System.out.println("MypageController.myreply() ->principal.getName() : " + principal.getName());
		String userid = principal.getName();
		MyboardRequestVO myboardRequestVO =new MyboardRequestVO(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
		List<MyActInfo> actInfos = mypageService.myReply(userid,myboardRequestVO);
		
		System.out.println("MypageController.myreply() ->actInfos.size() : " + actInfos.size());
		Map<String, Integer> lastmap = new HashMap<>();
		lastmap.put("리퀘스트", Integer.MAX_VALUE);
		lastmap.put("스타일", Integer.MAX_VALUE);
		lastmap.put("리셀", Integer.MAX_VALUE);
		
		for (MyActInfo myActInfo : actInfos) {
			System.out.println("myActInfo.getNo : " + myActInfo.getNo());
			System.out.println("myActInfo.getTitle : " + myActInfo.getType());
			
			if("리퀘스트".equals(myActInfo.getType())) {
				if(lastmap.get("리퀘스트") > myActInfo.getNo()) {
					lastmap.put("리퀘스트", myActInfo.getNo());
				}					
			} else if("스타일".equals(myActInfo.getType())) {
				if(lastmap.get("스타일") > myActInfo.getNo()) {
					lastmap.put("스타일", myActInfo.getNo());
				}					
			}else if("리셀".equals(myActInfo.getType())) {
				if(lastmap.get("리셀") > myActInfo.getNo()) {
					lastmap.put("리셀", myActInfo.getNo());
				}					
			}
		}
		System.out.println("lastmap.리퀘스트.getNo : " + lastmap.get("리퀘스트"));
		System.out.println("lastmap.스타일.getNo : " + lastmap.get("스타일"));
		System.out.println("lastmap.리셀.getNo : " + lastmap.get("리셀"));
		
		modelAndView.addObject("lastmap", lastmap);
		modelAndView.addObject("actInfos", actInfos);
		
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

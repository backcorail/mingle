package com.project.mingle.controller.user;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.mingle.config.Auth.UserSecDetails;

@Controller
public class UserController {
	

	// 로그인 - 회원가입 폼
	// http://localhost:9998/mingle/user/login_joinForm
	@GetMapping("/user/login_joinForm")
	public String joinForm(HttpSession session) {
		System.out.println("joinForm 맵핑");
		return "user/login_joinForm";
	}
	
	@GetMapping("/mypage")
	//1)
	public String mypage(HttpSession session) {
	//2)
//	public String mypage(HttpSession session, Principal principal) {
	//3)
//	public String mypage(HttpSession session, Authentication authentication) {
	//4)
//	public String mypage(HttpSession session,@AuthenticationPrincipal UserSecDetails secDetails) {
		System.out.println("mypage 맵핑");
		
		// 1) 실패) 컨택스트에서 직접가져오는 방법
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
//		UserDetails userDetails = (UserDetails)principal; 
//		String username = userDetails.getUsername();
//		System.out.println("username  확인"+ username);
		
		// 2) 성공) 컨트롤러 - 자바 principal 사용하는 방법  java.security.Principal;
		//System.out.println("principal  확인"+ principal.getName());
		
		// 3) 성공) 컨트롤러 - Authentication 시큐리티 코어
		//System.out.println("principal  확인"+ authentication.getName());
		
		// 4)  실패) 컨트롤러 - @AuthenticationPrincipal 커스텀 한거 
		 // System.out.println("secDetails  확인"+ secDetails.getUserVO().getUser_id());
		return "home";
	}


}

package com.project.mingle.controller.mypage;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.mingle.service.mypage.MypageService;
import com.project.mingle.vo.user.CheckVO;
import com.project.mingle.vo.user.ResponseDto;

@RestController
public class MyPageAPIController {

	@Autowired
	MypageService mypageService;
	
	@PutMapping("/mypage/user")
	public ResponseDto<String> userPut(@RequestBody CheckVO checkVO, Principal principal) {
		
		System.out.println("userPut 호출");
		ResponseDto<String> responseDto = mypageService.userPut(principal.getName(),checkVO);
		

		return responseDto;
	}
}

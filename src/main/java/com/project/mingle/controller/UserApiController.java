package com.project.mingle.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.mingle.service.AuthService;
import com.project.mingle.service.UserService;
import com.project.mingle.vo.OtpVO;
import com.project.mingle.vo.ResponseDto;

@RestController
public class UserApiController {
	
	@Autowired
	UserService userService;
	
	@Autowired 
	AuthService authService;
	
	// http://localhost:9998/mingle/user/iddcheck
	@PostMapping("/user/iddcheck")
	public ResponseDto<String> iddcheck(@RequestBody String checkid){
		System.out.println("checkid : " + checkid);
		String iddcheck = userService.iddcheck(checkid);
		if(iddcheck==null) {
			iddcheck="사용가능한 아이디입니다.";
		}
		return new ResponseDto<String>(101,iddcheck);
	}
	
	
	@PostMapping("/user/send-otp")
    public void sendOtp(@RequestBody String phone, HttpSession session) {
        // 서비스 계층을 통해 인증번호 생성 및 전송
        String otp = authService.generateAndSendOtp(phone);
        
        System.out.println("otp 생성 확인 : "+ otp);
        // 세션에 인증번호 저장
        session.setAttribute("otp", otp);
    }

    @PostMapping("/user/verify-otp")
    public ResponseDto<String> verifyOtp(@RequestBody OtpVO otpVO , HttpSession session) {
        // 세션에서 인증번호 가져오기
        String sessionOtp = (String) session.getAttribute("otp");
        System.out.println("sessionOtp : "+ sessionOtp);
        System.out.println("otp : "+ otpVO.getOtp());

        // 서비스 계층을 통해 인증번호 검증
        if (authService.verifyOtp(otpVO.getOtp(), sessionOtp)) {
            // 인증 성공
            return new ResponseDto<String>(111,"otp성공");
        } else {
            // 인증 실패
        	return new ResponseDto<String>(112,"otp실패");
        }
    }

}

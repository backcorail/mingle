package com.project.mingle.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.mingle.service.AuthService;
import com.project.mingle.service.UserService;
import com.project.mingle.vo.UserVO;
import com.project.mingle.vo.user.CheckVO;
import com.project.mingle.vo.user.JoinUserVO;
import com.project.mingle.vo.user.ResponseDto;
import com.project.mingle.vo.user.UserResp;

@RestController
public class UserApiController {
	
	@Autowired
	UserService userService;
	
	@Autowired 
	AuthService authService;
	
	// http://localhost:9998/mingle/user/iddcheck
	@PostMapping("/user/iddcheck")
	public ResponseDto<String> iddcheck(@RequestBody CheckVO checkVO ){
		System.out.println("checkVO.getData : " + checkVO.getData());
		UserVO userVO = userService.iddcheck(checkVO.getData());
		if(userVO==null) {
			return new ResponseDto<String>(UserResp.USERIDOK.getValue(),"사용가능한 아이디입니다.");//101
		}else {
			System.out.println(userVO.toString());
			return new ResponseDto<String>(UserResp.USERIDDD.getValue(),"중복된 아이디입니다.");//102
		}
		
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
    public ResponseDto<String> verifyOtp(@RequestBody CheckVO checkVO , HttpSession session) {
        // 세션에서 인증번호 가져오기
        String sessionOtp = (String) session.getAttribute("otp");
        System.out.println("sessionOtp : "+ sessionOtp);
        System.out.println("checkVO : "+ checkVO.getData());

        // 서비스 계층을 통해 인증번호 검증
        if (authService.verifyOtp(checkVO.getData(), sessionOtp)) {
            // 인증 성공
            return new ResponseDto<String>(UserResp.OTPOK.getValue(),"otp성공");
        } else {
            // 인증 실패
        	return new ResponseDto<String>(UserResp.OTPFAIDL.getValue(),"otp실패");
        }
    }
	// http://localhost:9998/mingle/user/nickdcheck
	@PostMapping("/user/nickdcheck")
	public ResponseDto<String> nickdcheck(@RequestBody CheckVO checkVO){
		System.out.println("checknick : " + checkVO.getData());
		UserVO userVO = userService.nickcheck(checkVO.getData());
		if(userVO==null) {
			return new ResponseDto<String>(UserResp.USERNICKOK.getValue(),"사용가능한 닉네임입니다.");
		}else {
			System.out.println(userVO.toString());
			return new ResponseDto<String>(UserResp.USERNICKDD.getValue(),"중복된 닉네임 입니다.");
		}	
	}
	
	@PostMapping("/user")
	//public ResponseDto<String> save(@RequestBody UserVO userVO){
	public ResponseDto<String> save(@RequestBody JoinUserVO joinUserVO){
		System.out.println("\n joinUserVO 브라우저에서 오는값");
		System.out.println(joinUserVO.toString());
		int saveResult = userService.save(joinUserVO);
		if(saveResult < 1 ) return  new ResponseDto<String>(UserResp.JOINFAILD.getValue(),"회원가입에 실패 하였습니다.");
		return new ResponseDto<String>(UserResp.JOINSUCCESS.getValue(),"회원가입 완료");
	}
	
	@PostMapping("/user/login")
	public ResponseDto<String> login(@RequestBody JoinUserVO joinUserVO, HttpSession session) {
		System.out.println("UserApiController : login 호출됨");
		UserVO principal = userService.login(joinUserVO); // principal(접근주체)

		if (principal != null) {
			session.setAttribute("principal", principal);
		}
		return new ResponseDto<String>(UserResp.LOGINOK.getValue(), "로그인에 성공하였습니다.");
	}
	

}

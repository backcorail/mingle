package com.project.mingle.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

// ... 클래스 정의 및 다른 필요한 코드


import com.project.mingle.service.NaverApiService;
import com.project.mingle.vo.naver.NaverCapKeyVO;
import com.project.mingle.vo.user.ResponseDto;
import com.project.mingle.vo.user.UserResp;


@RestController
public class NaverAPIController {
    
    @Autowired
    NaverApiService naverApiService;
    
    @GetMapping("/user/captcha")
    public ResponseEntity<Resource> getCaptcha() throws IOException {
        File captchaImage = naverApiService.getCaptcha();
        
        // 파일을 Resource로 변환 //파일 객체는 서버의 파일구조가 드러나므로 적극 비추천
        InputStreamResource resource = new InputStreamResource(new FileInputStream(captchaImage));

        return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_JPEG) // 캡차 이미지의 타입에 따라 변경 필요
            .body(resource);
    }
    
    @GetMapping("/user/captchaaudio")
    public ResponseEntity<Resource> getCaptchaAudio() throws IOException {
        File captchaAudio = naverApiService.getCaptchaAudio();
        
        // 파일을 Resource로 변환 //파일 객체는 서버의 파일구조가 드러나므로 적극 비추천
        InputStreamResource resource = new InputStreamResource(new FileInputStream(captchaAudio));

        return ResponseEntity.ok()
        	.contentType(MediaType.parseMediaType("audio/wav"))
            .body(resource);
    }
    
    @PostMapping("/user/capkeycheck")
    public ResponseDto<String> capkeycheck(@RequestBody NaverCapKeyVO naverCapKeyVO ) throws IOException {
        System.out.println("컨트롤러 capkeycheck naverCapKeyVO-TYPE"+naverCapKeyVO.getType());
        System.out.println("컨트롤러 capkeycheck naverCapKeyVO-KEY "+naverCapKeyVO.getKey());
    	
    	boolean capKeyOauth = naverApiService.capkeycheck(naverCapKeyVO);
    	if(capKeyOauth) {
    		return new ResponseDto<String>(UserResp.CAPTCHAOK.getValue(),"캡차성공.");//102
    	}
    	return new ResponseDto<String>(UserResp.CAPTCHAFAILD.getValue(),"캡차실패");//102
    }
}

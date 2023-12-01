package com.project.mingle.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// ... 클래스 정의 및 다른 필요한 코드

import com.project.mingle.service.NaverApiService;
import com.project.mingle.vo.naver.NaverCapKeyVO;
import com.project.mingle.vo.user.ResponseDto;
import com.project.mingle.vo.user.UserResp;

@RestController
public class NaverAPIController {

	@Autowired
	NaverApiService naverApiService;

//		1) 1차 시도 ResponseEntity<Resource> 가 간편하다.
//    @GetMapping("/user/captcha")
//    public ResponseEntity<Resource> getCaptcha() throws IOException {
//        File captchaImage = naverApiService.getCaptcha();
//        
//        // 파일을 Resource로 변환 //파일 객체는 서버의 파일구조가 드러나므로 적극 비추천
//        InputStreamResource resource = new InputStreamResource(new FileInputStream(captchaImage));
//
//        return ResponseEntity.ok()
//            .contentType(MediaType.IMAGE_JPEG) // 캡차 이미지의 타입에 따라 변경 필요
//            .body(resource);
//    }

//		2) 2차시도  
//    @GetMapping("/user/captcha")
//    public ResponseEntity<Resource> getCaptcha() {
//        File captchaFile = null;
//        try {
//            captchaFile = naverApiService.getCaptcha();
//            
//            InputStreamResource resource = new InputStreamResource(new FileInputStream(captchaFile)) {
//                @Override
//                public void close() throws IOException {
//                    super.close();
//                    if (captchaFile.exists()) {
//                        captchaFile.delete();
//                    }
//                }
//            };
//            return ResponseEntity.ok()
//                .contentType(MediaType.IMAGE_JPEG)
//                .body(resource);
//        } catch (IOException e) {
//            // 에러 처리 로직
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(null);
//        } finally {
//            // 최종적으로 파일이 열려있지 않은지 확인하고 삭제
//            if (captchaFile != null && captchaFile.exists()) {
//                captchaFile.delete();
//            }
//        }
//    }

// 3차 시도 파일이 작은 경우 적당함. 바이트변경하여. 전송.
// 4차  코드 개선 계획. TODO 
//    	=> HttpServletResponse  res 로 스트림을 열어서 작은 바이트 단위로 직접전송.
//		=> 전송직후 스트림을 닫고 파일 삭제.
// 	=> 에러 발생!! => 단순 네트워크 문제일수도 있으니 재전송 시도. 2차 시도 동일 패턴을 파일 삭제할것.
//		=> StreamUtils 이라는 것도 있으니까 나중에 확인.
	@GetMapping("/user/captcha")
	public ResponseEntity<byte[]> getCaptcha() {
		File captchaFile = null;
		byte[] fileContent = null;

		try {
			captchaFile = naverApiService.getCaptcha();
			fileContent = Files.readAllBytes(captchaFile.toPath());

			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG) // 적절한 MIME 타입 설정
					.body(fileContent);
		} catch (IOException e) {
			// 에러 처리 로직
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		} finally {
			// 최종적으로 파일이 열려있지 않은지 확인하고 삭제
			if (captchaFile != null && captchaFile.exists()) {
				captchaFile.delete();
			}
		}
	}
// 	1차 시도)
//    @GetMapping("/user/captchaaudio")
//    public ResponseEntity<Resource> getCaptchaAudio() throws IOException {
//        File captchaAudio = naverApiService.getCaptchaAudio();
//        
//        // 파일을 Resource로 변환 //파일 객체는 서버의 파일구조가 드러나므로 적극 비추천
//        InputStreamResource resource = new InputStreamResource(new FileInputStream(captchaAudio));
//
//        return ResponseEntity.ok()
//        	.contentType(MediaType.parseMediaType("audio/wav"))
//            .body(resource);
//    }
	//2차 시도 : 파일 전송직후 삭제.
	@GetMapping("/user/captchaaudio")
	public ResponseEntity<byte[]> getCaptchaAudio() {
		File captchaAudio = null;
		byte[] fileContent = null;

		try {
			captchaAudio = naverApiService.getCaptchaAudio();
			fileContent = Files.readAllBytes(captchaAudio.toPath());

			return ResponseEntity.ok().contentType(MediaType.parseMediaType("audio/wav")).body(fileContent);
		} catch (IOException e) {
			// 에러 처리 로직
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		} finally {
			// 최종적으로 파일이 열려있지 않은지 확인하고 삭제
			if (captchaAudio != null && captchaAudio.exists()) {
				captchaAudio.delete();
			}
		}
	}

	@PostMapping("/user/capkeycheck")
	public ResponseDto<String> capkeycheck(@RequestBody NaverCapKeyVO naverCapKeyVO) throws IOException {
		System.out.println("컨트롤러 capkeycheck naverCapKeyVO-TYPE" + naverCapKeyVO.getType());
		System.out.println("컨트롤러 capkeycheck naverCapKeyVO-KEY " + naverCapKeyVO.getKey());

		boolean capKeyOauth = naverApiService.capkeycheck(naverCapKeyVO);
		if (capKeyOauth) {
			return new ResponseDto<String>(UserResp.CAPTCHAOK.getValue(), "캡차성공.");// 102
		}
		return new ResponseDto<String>(UserResp.CAPTCHAFAILD.getValue(), "캡차실패");// 102
	}
}

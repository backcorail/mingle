package com.project.mingle.controller.mypage;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.mingle.config.Auth.UserSecDetails;
import com.project.mingle.service.Auth.UserSecDetailsServiceImple;
import com.project.mingle.service.mypage.MypageService;
import com.project.mingle.vo.user.CheckVO;
import com.project.mingle.vo.user.ResponseDto;
import com.project.mingle.vo.user.UserResp;

@RestController
public class MyPageAPIController {

	@Autowired
	MypageService mypageService;
	
    private final UserSecDetailsServiceImple userSecDetailsServiceImple;

	public MyPageAPIController(UserSecDetailsServiceImple userSecDetailsServiceImple, PasswordEncoder passwordEncoder) {
        this.userSecDetailsServiceImple = userSecDetailsServiceImple;
    }

	@PutMapping("/mypage/user")
	public ResponseDto<String> userPut(@RequestBody CheckVO checkVO,@AuthenticationPrincipal UserSecDetails principal) {

		System.out.println("userPut 호출");
		ResponseDto<String> responseDto = mypageService.userPut(principal.getUserVO().getUser_id(), checkVO);
		
		UserDetails userDetails = userSecDetailsServiceImple.loadUserByUsername(principal.getUserVO().getUser_id());
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return responseDto;
	}

	@PutMapping("/mypage/upload")
	public ResponseDto<String> uploadImage(@RequestParam("image") MultipartFile file,@AuthenticationPrincipal UserSecDetails principal,HttpSession session) {
		// 파일 처리 로직
		try {
			if (file.isEmpty()) {
				return new ResponseDto<String>(UserResp.IMG_C_BLANK.getValue(), "파일이 비어 있습니다.");
			}
			// 업로드할 파일의 위치
			String path = session.getServletContext().getRealPath("/profileimg");
			System.out.println("path => " + path);

			// 파일 업로드
			 // 원본 파일 이름에서 확장자 추출
            String originalFileName = file.getOriginalFilename();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));

            // 새로운 파일 이름 생성 (예: UUID 사용)
            String newFileName = principal.getUsername()+ fileExtension;
            System.out.println("newFileName => " + newFileName);
            
			// 파일 저장 로직 (여기에 구현)
            String fileName = MypageFileUpload.fileUpload(path, file, newFileName);

            CheckVO checkVO = new CheckVO("/mingle/profileimg/"+fileName,"userimg");
            
            
            ResponseDto<String> responseDto = mypageService.userPut(principal.getUsername(), checkVO);
            responseDto.setRes("/mingle/profileimg/"+fileName);
            
    		UserDetails userDetails = userSecDetailsServiceImple.loadUserByUsername(principal.getUserVO().getUser_id());
    		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    		SecurityContextHolder.getContext().setAuthentication(authentication);
            
            return responseDto;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("값 확인 : Exception");
			return new ResponseDto<String>(UserResp.IMG_C_FAILE.getValue(), "프로필 변경실패");
		}
	}
	@PutMapping("/mypage/defaultimg")
	public ResponseDto<String> defaultimg(Principal principal) {

			String fileName="profileEX.png";
            CheckVO checkVO = new CheckVO("/mingle/profileimg/"+fileName,"userimg");
            ResponseDto<String> responseDto = mypageService.userPut(principal.getName(), checkVO);
            responseDto.setRes("/mingle/profileimg/"+fileName);

			System.out.println("값 확인 : Exception");
			
			UserDetails userDetails = userSecDetailsServiceImple.loadUserByUsername(principal.getName());
			Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			return responseDto;

	}
	
	
	
	
	//회원탈퇴로직
	@DeleteMapping("/mypage/user")
	public ResponseDto<String> userOut(Authentication authentication){
		int resultDel = mypageService.userOut(authentication.getName());
		
		ResponseDto<String> responseDto = new ResponseDto<String>();
		if(resultDel>0) {
			if (authentication != null ) {
	            SecurityContextHolder.clearContext();
				responseDto.setStatus(UserResp.USER_OUT_OK.getValue());
				responseDto.setRes("회원탈퇴 완료");
	        } 
		}else {
			responseDto.setStatus(UserResp.USER_OUT_FAILE.getValue());
			responseDto.setRes("회원탈퇴 실패");
		}
		
		return responseDto;
	}
}
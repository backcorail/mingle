package com.project.mingle.controller.user;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.mingle.service.user.UserService;
import com.project.mingle.vo.UserVO;
import com.project.mingle.vo.user.KaKaoProfile;
import com.project.mingle.vo.user.OAuthToken;
import com.project.mingle.vo.user.OauthJoinUserVO;

@Controller
public class UserController {
	
	@Value("${KAKAO_REST_API}")
	private String app_key;
	
	@Value("${KAKAO_UUID}")
	private String app_uuid;
	
	@Autowired
	UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	// 로그인 - 회원가입 폼
	// http://localhost:9998/mingle/user/login_joinForm
	@GetMapping("/user/login_joinForm")
	public String joinForm(Model model) {
		System.out.println("UserController.joinForm() -> joinForm : ");
		model.addAttribute("REST_API_KEY", app_key);
		model.addAttribute("REDIRECT_URI", "http://localhost:9998/mingle/user/kakao/callback");
		return "user/login_joinForm";
	}
	
//	@GetMapping("/mypage")
	//1)
	public String mypage(HttpSession session) {
	//2)
//	public String mypage(HttpSession session, Principal principal) {
	//3)
//	public String mypage(HttpSession session, Authentication authentication) {
	//4)
//	public String mypage(HttpSession session,@AuthenticationPrincipal UserSecDetails secDetails) {
		System.out.println("UserController.mypage() ->session : " + session);
		
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
	// 카카오 코드 받기
	// 콜백 : http://localhost:9998/mingle/user/kakao/callback
	@GetMapping("/user/kakao/callback")
	public  String kakaoCallBack(String code) { 
		//System.out.println("UserController.kakaoCallBack() ->code : " + code);

		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", app_key);
		params.add("redirect_uri", "http://localhost:9998/mingle/user/kakao/callback");
		params.add("code", code);
		
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = 
				new HttpEntity<>(params,headers);
		

		ResponseEntity<String> response = rt.exchange(
				"https://kauth.kakao.com/oauth/token",
				HttpMethod.POST,
				kakaoTokenRequest,
				String.class
				);
		System.out.println("UserController.kakaoCallBack() ->response : " + response);

		
		ObjectMapper objectMapper = new ObjectMapper();
		OAuthToken oAuthToken=null;
		try {
			// 맵핑중간에 오류가 날수 있으므로 이렇게 예외처리 한다.
			oAuthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("UserController.kakaoCallBack() ->access_token : " + oAuthToken.getAccess_token());
		System.out.println("UserController.kakaoCallBack() ->token_type : " + oAuthToken.getToken_type());
		System.out.println("UserController.kakaoCallBack() ->refresh_token : " + oAuthToken.getRefresh_token());
		System.out.println("UserController.kakaoCallBack() ->expires_in : " + oAuthToken.getExpires_in());
		System.out.println("UserController.kakaoCallBack() ->scope : " + oAuthToken.getScope());
		System.out.println("UserController.kakaoCallBack() ->refresh_token_expires_in : " + oAuthToken.getRefresh_token_expires_in());

		System.out.println("카카오 엑세스 토큰 : "+ oAuthToken.getAccess_token());
		
		RestTemplate rt2 = new RestTemplate();
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", "Bearer "+oAuthToken.getAccess_token());
		headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest2 = 
				new HttpEntity<>(headers2);

		ResponseEntity<String> response2 = rt2.exchange(
				"https://kapi.kakao.com/v2/user/me",
				HttpMethod.POST,
				kakaoProfileRequest2,
				String.class
				);

		ObjectMapper objectMapper2 = new ObjectMapper();
		KaKaoProfile kaKaoProfile2=null;
		try {
			kaKaoProfile2 = objectMapper2.readValue(response2.getBody(), KaKaoProfile.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("카카오 엑세스 getId : "+ kaKaoProfile2.getId());
		System.out.println("카카오 엑세스 getThumbnail_image : "+ kaKaoProfile2.getProperties().getThumbnail_image());
		
        String imageUrl = kaKaoProfile2.getProperties().getThumbnail_image(); // 이미지 URL
//        System.out.println("UserController.kakaoCallBack() ->imageUrl : " + imageUrl);
//        String fileExtension = extractExtension(imageUrl);
//        System.out.println("UserController.kakaoCallBack() ->fileExtension : " + fileExtension);
//        String destinationFile = kaKaoProfile2.getId()+fileExtension; // 저장할 파일 이름
//        System.out.println("UserController.kakaoCallBack() ->destinationFile : " + destinationFile);
//        try {
//        	downloadImage(imageUrl, destinationFile);
//        } catch (IOException e) {
//            return "Error: " + e.getMessage();
//        }
		// kakao 회원가입 / 아이디 /비빌번호/ 닉네임/ oauth
		OauthJoinUserVO kakaoUser = OauthJoinUserVO.builder()
				.userid(kaKaoProfile2.getId()+"_ka")
				.userpwd(app_uuid)
				.usernick(kaKaoProfile2.getProperties().getNickname()+"_ka")
				.userOauth("kakao")
				.build();
		System.out.println("kakaoUser : "+ kakaoUser);
		// 가입자 혹은 비가입자 체크 해서 처리
		UserVO originUser = userService.iddcheck(kakaoUser.getUserid());
		
		System.out.println("기존가입 결과 확인 : ");
		// null 이면 가입 처리
		if(originUser== null) { 
			System.out.println("기존 회원이 아닙니다..........................................!!!");
			userService.saveOauth(kakaoUser);
		}else {
			System.out.println("기존 회원이 맞습니다.!!!");
		}
		System.out.println("자동 로그인을 진행합니다.");
		if(authenticationManager==null) {
			System.out.println("UserController.kakaoCallBack() ->authenticationManager : null " );
		}else {
			System.out.println("UserController.kakaoCallBack() ->authenticationManager : not null " );
		}
		System.out.println("자동 로그인을 진행합니다.");
		
		try {
		    Authentication authentication = 
		            authenticationManager.authenticate(
		                new UsernamePasswordAuthenticationToken(kakaoUser.getUserid(), kakaoUser.getUserpwd()));
		    System.out.println("UserController.kakaoCallBack() ->세션넣기 전: " + authentication.getPrincipal());
		    SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (AuthenticationException e) {
		    e.printStackTrace(); // 예외 정보 출력
		}
		
		System.out.println("UserController.kakaoCallBack() ->authentication. 세션넣기 후 : ");
		System.out.println("페이지 이동합니다.");
		return "redirect:/";
	}
	
    public void downloadImage(String imageUrl, String imageName) throws IOException {
        String destinationFilePath = "profileimg/" + imageName;
        System.out.println("UserController.downloadImage() ->destinationFilePath : " + destinationFilePath);

        URL url = new URL(imageUrl);
        System.out.println("UserController.downloadImage() ->url : " + url);

        try (InputStream in = new BufferedInputStream(url.openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(destinationFilePath)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        }
    }
    private static String extractExtension(String filePath) {
        int lastIndex = filePath.lastIndexOf(".");
        if (lastIndex > 0) {
            return filePath.substring(lastIndex);
        } else {
            return ""; // 확장자가 없는 경우
        }
    }

}

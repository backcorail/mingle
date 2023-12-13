package com.project.mingle.service.Auth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.project.mingle.config.Auth.UserSecDetails;
import com.project.mingle.config.Auth.provider.FacebookUserInfo;
import com.project.mingle.config.Auth.provider.GoogleUserInfo;
import com.project.mingle.config.Auth.provider.NaverUserInfo;
import com.project.mingle.config.Auth.provider.OAuth2UserInfo;
import com.project.mingle.service.user.UserService;
import com.project.mingle.vo.UserVO;
import com.project.mingle.vo.user.OauthJoinUserVO;

@Service
public class PrincipalOauth2UserService extends  DefaultOAuth2UserService{

	@Autowired
    private UserService userService;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		// TODO Auto-generated method stub
		OAuth2User oauth2User = super.loadUser(userRequest);
		OAuth2UserInfo oAuth2UserInfo = null;
		if("google".equals(userRequest.getClientRegistration().getRegistrationId()) ) {
			oAuth2UserInfo = new GoogleUserInfo(oauth2User.getAttributes());
		}else if("facebook".equals(userRequest.getClientRegistration().getRegistrationId()) ) {
			oAuth2UserInfo = new FacebookUserInfo(oauth2User.getAttributes());
		}else if("naver".equals(userRequest.getClientRegistration().getRegistrationId()) ) {
			oAuth2UserInfo = new NaverUserInfo((Map)oauth2User.getAttributes().get("response"));
		}
		
		String provider = oAuth2UserInfo.getProvider();
		String poviderId = oAuth2UserInfo.getProviderId();
		String userid = poviderId+"_"+ provider;

		UserVO userEntity =  userService.iddcheck(userid);
		if(userEntity==null) { // null이란 말은 우리 DB에 없다는 말이다.
			OauthJoinUserVO oauthJoinUserVO = new OauthJoinUserVO(userid, "test@1234", userid, provider);
			userService.saveOauth(oauthJoinUserVO);
			userEntity =  userService.iddcheck(userid);
		}else {  // null 이면 우리DB에 있다는 말이다.
			System.out.println("로그인을 이미 한적이 있습니다. 당신은 자동회원가입이 되었습니다.");
		}
		return new UserSecDetails(userEntity,oauth2User.getAttributes());
	}
}

package com.project.mingle.config.Auth.provider;

import java.util.Map;

public class FacebookUserInfo implements OAuth2UserInfo{

	private Map<String, Object> attributes; // getAttributes
	
	public FacebookUserInfo(Map<String, Object> attributes) {
		this.attributes= attributes;
	}
	
	public String getProviderId() {
		// TODO Auto-generated method stub
		return (String) attributes.get("id");
	}

	public String getProvider() {
		// TODO Auto-generated method stub
		return "facebook";
	}
}

package com.project.mingle.config.Auth.provider;

import java.util.Map;

public class GoogleUserInfo implements OAuth2UserInfo{

	private Map<String, Object> attributes; // getAttributes
	
	public GoogleUserInfo(Map<String, Object> attributes) {
		this.attributes= attributes;
	}
	
	public String getProviderId() {
		// TODO Auto-generated method stub
		return (String) attributes.get("sub");
	}

	public String getProvider() {
		// TODO Auto-generated method stub
		return "google";
	}
}

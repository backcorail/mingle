package com.project.mingle.config.Auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.project.mingle.vo.UserVO;

import lombok.Data;

@Data
public class UserSecDetails implements UserDetails ,OAuth2User{

	private UserVO userVO;
	private Map<String,Object> attributes;
	
	public UserSecDetails() {
	}

	public UserSecDetails(UserVO userVO) {
		this.userVO = userVO;
	}
	public UserSecDetails(UserVO userVO, Map<String, Object> attributes) {
		this.userVO = userVO;
		this.attributes = attributes;
	}

	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return attributes;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userVO.getUser_pwd();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userVO.getUser_id();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		// 유저상태를 2는 비활성화 1은 활성화
		if(userVO.getUser_status()==2) {
			return false;
		}
		return true;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Collection<GrantedAuthority> collectors = new ArrayList();
		collectors.add(()->{ return userVO.getUser_role();});
		return null;
	}



}

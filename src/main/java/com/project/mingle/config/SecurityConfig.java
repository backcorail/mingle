package com.project.mingle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration 
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	// 1. 접근 경로 필터링.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors().disable() // cors 방지
			.csrf().disable() //csrf 			
			.authorizeRequests()
	        .antMatchers("/mingle/mypage").authenticated() // /mingle/mypage에 대해서는 인증 필요
	        .antMatchers("/", "/mingle/**").permitAll() // 나머지 /mingle/** 경로는 모두 허용
        .and()
        .formLogin()
            .loginPage("/mingle/user/login_joinForm") // 컨텍스트 패스에 맞춘 로그인 페이지 경로
            .loginProcessingUrl("/mingle/user/login") // 컨텍스트 패스에 맞춘 로그인 처리 URL
            .defaultSuccessUrl("/mingle"); // 로그인 성공 후 이동할 기본 URL
            // .failureUrl("/mingle/fail") // 로그인 실패 시 이동할 URL (필요한 경우)
	}
	
	//2. 비밀번호 암호화
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}

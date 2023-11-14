package com.project.mingle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration 
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	// 1. 접근 경로 필터링.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.cors().disable() // cors 방지
//			.csrf().disable() //csrf 			
//			.formLogin().disable()
//			.headers().frameOptions().disable();
	    http
        .cors(cors -> cors.disable())
        .csrf(csrf -> csrf.disable())
        .formLogin(formLogin -> formLogin.disable())
        .headers(headers -> headers.frameOptions().disable());
	}
	
	//2. 비밀번호 암호화
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}

package com.project.mingle.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.project.mingle.config.Auth.CustomAuthenticationFilter;
import com.project.mingle.service.Auth.CustomAuthenticationFailureHandler;
import com.project.mingle.service.Auth.CustomAuthenticationProvider;
import com.project.mingle.service.Auth.CustomAuthenticationSuccessHandler;
import com.project.mingle.service.Auth.CustomLogoutSuccessHandler;


@Configuration 
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;
	@Autowired
	private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
	@Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	 @Autowired
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;
	    
	// 1. 접근 경로 필터링.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// 커스텀 필터 인스턴스 생성
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter();
        customAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
        
		http
			.cors().disable() // cors 방지
			.csrf().disable() //csrf 			
			.authorizeRequests()
		        .antMatchers("/mingle/mypage").authenticated() // /mingle/mypage에 대해서는 인증 필요
		        .antMatchers("/mingle/user/logout").authenticated() // 로그아웃 경로는 인증된 사용자만 허용
		        .antMatchers("/", "/mingle/**").permitAll() // 나머지 /mingle/** 경로는 모두 허용
        .and()
        .formLogin()
	        .usernameParameter("userid") // 사용자 이름 파라미터 이름 변경
	        .passwordParameter("userpwd") // 비밀번호 파라미터 이름 변경
            .loginPage("/mingle/user/login_joinForm") // 컨텍스트 패스에 맞춘 로그인 페이지 경로
            .loginProcessingUrl("/mingle/user/login") // 컨텍스트 패스에 맞춘 로그인 처리 URL
            .successHandler(customAuthenticationSuccessHandler)
            .defaultSuccessUrl("/mingle")
            .failureHandler(customAuthenticationFailureHandler) // 로그인 실패 핸들러 설정
         .and()
         	.logout()
         	.logoutUrl("/mingle/user/logout") // 로그아웃 처리 URL 설정
         	.logoutSuccessHandler(customLogoutSuccessHandler) 
            .logoutSuccessUrl("/mingle") // 로그아웃 성공 시 리디렉션할 URL
            .invalidateHttpSession(true) // 세션 무효화// 로그인 성공 후 이동할 기본 URL
            // .failureUrl("/mingle/fail") // 로그인 실패 시 이동할 URL (필요한 경우)
         // 커스텀 필터 추가
        .and()
            .addFilterBefore(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	//2. 비밀번호 암호화 순환참조때문에 다른 config에서 생성.
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(customAuthenticationProvider);
    }
    
	//2. 비밀번호 암호화
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
//	@Autowired
//	private UserSecDetailsServiceImple userSecDetailsServiceImple;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		auth.userDetailsService(userSecDetailsServiceImple).passwordEncoder(passwordEncoder());
//		
//	}
	
}

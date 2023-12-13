package com.project.mingle.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.project.mingle.handler.security.AdminAuthenticationFailureHandler;
import com.project.mingle.handler.security.AdminAuthenticationSuccessHandler;
import com.project.mingle.handler.security.AdminLogoutSuccessHandler;
import com.project.mingle.service.Auth.AdminAuthenticationProvider;

@Configuration
@EnableWebSecurity
@Order(1)
public class AdminSecurityConfig {

	@Autowired
	private AdminAuthenticationProvider adminAuthenticationProvider;
	@Autowired
	private AdminAuthenticationFailureHandler adminAuthenticationFailureHandler;
	@Autowired
	private AdminAuthenticationSuccessHandler adminAuthenticationSuccessHandler;
	@Autowired
	private AdminLogoutSuccessHandler adminLogoutSuccessHandler;

	// 1. 접근 경로 필터링.
	@Bean
	protected SecurityFilterChain adminFilterChain(HttpSecurity http) throws Exception {

		http. // http 설정 시작.
				authorizeHttpRequests() // 인가 요청
				.antMatchers("/admin/**").hasRole("ADMIN")
//				.antMatchers("/admin/**").authenticated()
//				.anyRequest().permitAll()// 마이페이지는 인증받은 사람만 // 인증받지 않으면 exceptionHandling
				;
		http // http 설정 시작.
				.formLogin(login -> login. // 폼 로그인 설정
						loginPage("/admin/loginForm")
						.loginProcessingUrl("/admin/loginproc") // 해당 URL 로 접근 시 로그인 프로세스 실행
						.usernameParameter("adminid") // 사용자아이디 파라미터 name을 정의
						.passwordParameter("adminpwd") // 비밀번호 파라미터 name을 정의
						.successHandler(adminAuthenticationSuccessHandler)
						.failureHandler(adminAuthenticationFailureHandler))// 그리고 http
				.logout(logout -> logout.// 로그아웃
						logoutUrl("/admin/logout") // 로그아웃 처리 URL 설정
						.logoutSuccessHandler(adminLogoutSuccessHandler)// 로그아웃 처리 핸들러
						.logoutSuccessUrl("/") // 로그아웃 성공 시 리디렉션할 URL
						.invalidateHttpSession(true) // 세션 무효화// 로그인 성공 후 이동할 기본 URL
						.deleteCookies("JSESSIONID"))// 그리고 http
				.authenticationProvider(adminAuthenticationProvider)
				.csrf(csrf -> csrf.disable()); // 테스트를 위해서
        http.exceptionHandling(handling -> handling
                .authenticationEntryPoint((request, response, authException) -> {
                    // 주의!!! AuthenticationEntryPoint를 직접 구현하게 되면
                    // 우리가 만든 로그인 페이지로 이동하게 된다. 
                    // 스프링 시큐리티가 제공하는 로그인 페이지가 아니다!
                    System.out.println(" 호출확인 adminFilterChain exceptionHandling");
                    //response.sendRedirect("/mingle/login");
                    response.sendRedirect("/mingle/admin/loginForm");
                }));
//			     http.accessDeniedHandler((request, response, accessDeniedException) -> {
//		        	 System.out.println(" 호출확인 accessDeniedHandler");
//		             response.sendRedirect("/mingle/denied");
//		         });
				
				
		return http.build();

		/*
		 * 🛑 인가 받지 못하면 예외처리 인가 받지 못하는 사용자에 대해 다른곳으로 보내는 것보다 먼저 처리된다. 즉 애보다 =>
		 * .formLogin().loginPage("/user/login_joinForm") 먼저 처리된다. 그리고 위에 주소로 연결되지 않는다.
		 */
//     http.exceptionHandling()
//         .authenticationEntryPoint((request, response, authException) -> {
//             // 주의!!! AuthenticationEntryPoint를 직접 구현하게 되면
//             // 우리가 만든 로그인 페이지로 이동하게 된다. 
//             // 스프링 시큐리티가 제공하는 로그인 페이지가 아니다!
//        	 System.out.println(" 호출확인 exceptionHandling");
//             //response.sendRedirect("/mingle/login");
//             response.sendRedirect("/mingle/user/login_joinForm");
//         });
//         .accessDeniedHandler((request, response, accessDeniedException) -> {
//        	 System.out.println(" 호출확인 accessDeniedHandler");
//             response.sendRedirect("/mingle/denied");
//         });

//		http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);

//         // 커스텀 필터 추가
//        .and()
//            .addFilterBefore(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

	}
}

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

	@Bean
	protected SecurityFilterChain adminFilterChain(HttpSecurity http) throws Exception {
		http//
				.antMatcher("/myadmin/**")//
				.authorizeHttpRequests(authz -> authz//
						.antMatchers("/myadmin/loginForm").permitAll() // 로그인 페이지에 대한 접근 허용
						.anyRequest().hasRole("ADMIN")//
				);
		http // http 설정 시작.
				.formLogin(login -> login. // 폼 로그인 설정
						loginPage("/myadmin/loginForm")//
						.loginProcessingUrl("/myadmin/loginproc") //
						.usernameParameter("adminid") //
						.passwordParameter("adminpwd") //
						.successHandler(adminAuthenticationSuccessHandler)
						.failureHandler(adminAuthenticationFailureHandler))//
				.logout(logout -> logout.//
						logoutUrl("/myadmin/logout") //
						.logoutSuccessHandler(adminLogoutSuccessHandler)//
						.logoutSuccessUrl("/") //
						.invalidateHttpSession(true) //
						.deleteCookies("JSESSIONID"))//
				.authenticationProvider(adminAuthenticationProvider).csrf(csrf -> csrf.disable()); //
		http.exceptionHandling(handling -> handling//
				.authenticationEntryPoint((request, response, authException) -> {//
					System.out.println(" 호출확인 adminFilterChain exceptionHandling");//
					response.sendRedirect("/mingle/myadmin/loginForm");//
				}));
		return http.build();

	}
}

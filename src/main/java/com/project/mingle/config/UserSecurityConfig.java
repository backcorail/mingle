package com.project.mingle.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import com.project.mingle.handler.security.CustomAuthenticationFailureHandler;
import com.project.mingle.handler.security.CustomAuthenticationSuccessHandler;
import com.project.mingle.handler.security.CustomLogoutSuccessHandler;
import com.project.mingle.service.Auth.CustomAuthenticationProvider;

@Configuration
@Order(2)
public class UserSecurityConfig {

	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;
	@Autowired
	private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	@Autowired
	private CustomLogoutSuccessHandler customLogoutSuccessHandler;

	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http // 
				.authorizeHttpRequests() //
				.antMatchers("/mypage/**").hasRole("USER")//
				.anyRequest().permitAll(); // 
		http // 
				.formLogin(login -> login. //
						loginPage("/user/login_joinForm") // 
						.loginProcessingUrl("/user/loginproc") //
						.usernameParameter("userid") //
						.passwordParameter("userpwd") //
						.successHandler(customAuthenticationSuccessHandler) //
						.failureHandler(customAuthenticationFailureHandler))//
				.logout(logout -> logout.// 
						logoutUrl("/user/logout") // 
						.logoutSuccessHandler(customLogoutSuccessHandler)// 
						.logoutSuccessUrl("/") //
						.invalidateHttpSession(true) // 
						.deleteCookies("JSESSIONID"))//
				.authenticationProvider(customAuthenticationProvider)//
				.csrf(csrf -> csrf.disable());//
		http.exceptionHandling(handling -> handling.authenticationEntryPoint((request, response, authException) -> {
			System.out.println(" filterChain 호출확인 exceptionHandling");
			response.sendRedirect("/mingle/user/login_joinForm");
		}));
		http.oauth2Login(login -> login.loginPage("/user/login_joinForm"));
		return http.build();
	}

}

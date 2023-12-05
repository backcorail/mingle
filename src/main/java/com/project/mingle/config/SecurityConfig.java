package com.project.mingle.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import com.project.mingle.handler.security.AccessDeniedHandlerImpl;
import com.project.mingle.handler.security.CustomAuthenticationFailureHandler;
import com.project.mingle.handler.security.CustomAuthenticationSuccessHandler;
import com.project.mingle.handler.security.CustomLogoutSuccessHandler;
import com.project.mingle.service.Auth.CustomAuthenticationProvider;
import com.project.mingle.service.Auth.UserSecDetailsServiceImple;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private UserSecDetailsServiceImple userSecDetailsServiceImple;
	
	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;
	@Autowired
	private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

	@Autowired
	private CustomLogoutSuccessHandler customLogoutSuccessHandler;

//    private final AccessDeniedHandlerImpl accessDeniedHandler;
//        	 
//	public SecurityConfig(AccessDeniedHandlerImpl accessDeniedHandler) {
//		this.accessDeniedHandler = accessDeniedHandler;
//	}
	// 1)인증 예외처리 // static 자원은 인증 제외.
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/js/**", "/css/**", "/assets/**", "/font/**", "/img/**");
	}

	// 1. 접근 경로 필터링.
	@Override
	protected void configure(HttpSecurity http) throws Exception {

//      CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter();
//      customAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
		/*
		 * 1) 시큐시티 자동맵핑 Spring Security는 기본적으로 로그인 페이지 경로 앞에 애플리케이션의 컨텍스트 패스를 추가한다.
		 * .loginPage("/mingle/user/login_joinForm") =>
		 * .loginPage("/user/login_joinForm") 2) 로그인페이지는 허용페이지어야 한다.
		 * 
		 */
// 	1)기본설정
//		http
//		.cors().disable() // cors 방지
//		.csrf().disable() //csrf 			
//		.formLogin().disable()
//		.headers().frameOptions().disable();

		http. // http 설정 시작.
				authorizeHttpRequests() // 인가 요청
//         	.antMatchers("/user/**","/js/**","/css/**","/assets/**","/font/**","/img/**").permitAll()
//         	.anyRequest().authenticated();
				.antMatchers("/mypage/**").authenticated()// 마이페이지는 인증받은 사람만 // 인증받지 않으면 exceptionHandling
				.anyRequest().permitAll() // 다른 인가 요청은 모두 인증없이 모두 허용
				// .antMatchers("/user").hasRole("USER") // 인증과 인가에 대해서

				.and()// 그리고 http
				.formLogin(). // 폼 로그인 설정
				loginPage("/user/login_joinForm")
				// .loginProcessingUrl("/user/loginProc")//Action 스프링 시큐리티가 해당 주소로 요청(request)오는
				// 로그인을 가로채서 대신 로그인 해준다.
				// .defaultSuccessUrl("/")// 인증이 성공하면 여기로 이동한다.
				.loginProcessingUrl("/user/loginproc") // 해당 URL 로 접근 시 로그인 프로세스 실행
				.usernameParameter("userid") // 사용자아이디 파라미터 name을 정의
				.passwordParameter("userpwd") // 비밀번호 파라미터 name을 정의
				.successHandler(customAuthenticationSuccessHandler) // 로그인 성공시 해당 핸들러 실행
				.failureHandler(customAuthenticationFailureHandler) // 로그인 실패시 해당 핸들러 실행
				//.permitAll()

				.and()// 그리고 http
				.logout().// 로그아웃
				logoutUrl("/user/logout") // 로그아웃 처리 URL 설정
				.logoutSuccessHandler(customLogoutSuccessHandler)// 로그아웃 처리 핸들러
				.logoutSuccessUrl("/") // 로그아웃 성공 시 리디렉션할 URL
				.invalidateHttpSession(true) // 세션 무효화// 로그인 성공 후 이동할 기본 URL
//				.deleteCookies("JSESSIONID"); // 쿠키삭제
				
                // ajax 통신 가능하도록
                .and()// 그리고 http
                .authenticationProvider(customAuthenticationProvider)//AuthenticationManagerBuilder 에서 provider를 지정해도 된다. 
                .csrf().disable();// 테스트를 위해서 
                

//         .successHandler((request, response, authentication) -> {
//             HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
//             
//             // 세션에서 이미 저장되어 있는 이전 요청 정보를 추출!
//             SavedRequest savedRequest = requestCache.getRequest(request, response);
//             String redirectUrl = savedRequest.getRedirectUrl();
//             System.out.println("redirectUrl = " + redirectUrl);
//             
//             // 그 이전 요청 위치로 이동!
//             response.sendRedirect(redirectUrl);
//         });

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

//		http
//	    .cors().disable() // CORS 방지
//	    .csrf().disable() // CSRF 방지
//	    .authorizeRequests()
//	    	.antMatchers("/mingle/**")
//	        .permitAll() // 해당 경로는 누구나 접근 가능
//		    .anyRequest()
//		    .authenticated(); // 그 외의 경로는 인증 필요		
//		http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);

//	    .and()
//	    .formLogin()
//	    .loginPage("/user/login_joinForm") // 로그인 페이지 경로
//	    .loginProcessingUrl("/mingle/user/login_joinForm") // 로그인 처리 경로
//	    .defaultSuccessUrl("/"); // 로그인 성공 시 리디렉션 경로

//		http
//			.cors().disable() // cors 방지
//			.csrf().disable() //csrf 			
//			.authorizeRequests()
//				.antMatchers("/","/mingle/mypage","/mingle/user/login_joinForm","/mingle/js/**","/mingle/css/**","/mingle/assets/**","/mingle/font/**")
//				.permitAll() // request를 허용한다.
//				.anyRequest() // 그리고 다른 모든 rqquest는
//				.authenticated()// 인증이 되어야 한다.
//			.and() // 그리고
//				.formLogin() //인증이 되지 않는 요청은 폼로그인 페이지로 이동
//				.loginPage("/user/login_joinForm") // 로그인 페이지는 여기로
//				.loginProcessingUrl("/mingle/user/loginproc")//Action 스프링 시큐리티가 해당 주소로 요청(request)오는 로그인을 가로채서 대신 로그인 해준다.
//				.defaultSuccessUrl("/");// 인증이 성공하면 여기로 이동한다.

//     		http
//		        .antMatchers("/mingle/mypage/**").authenticated() // /mingle/mypage에 대해서는 인증 필요
//		        .antMatchers("/mingle/user/logout").authenticated() // 로그아웃 경로는 인증된 사용자만 허용
//		        .antMatchers("/", "/mingle/**").permitAll(); // 나머지 /mingle/** 경로는 모두 허용

//        .and()
//        .formLogin()
//	        .usernameParameter("userid") // 사용자 이름 파라미터 이름 변경
//	        .passwordParameter("userpwd") // 비밀번호 파라미터 이름 변경
//            .loginPage("/mingle/user/login_joinForm") // 컨텍스트 패스에 맞춘 로그인 페이지 경로
//            .loginProcessingUrl("/mingle/user/loginproc") // 컨텍스트 패스에 맞춘 로그인 처리 URL
//            .successHandler(customAuthenticationSuccessHandler)
//            .defaultSuccessUrl("/mingle")
//            .failureHandler(customAuthenticationFailureHandler); // 로그인 실패 핸들러 설정
////         .and()
//         	.logout()
//         	.logoutUrl("/mingle/user/logout") // 로그아웃 처리 URL 설정
//         	.logoutSuccessHandler(customLogoutSuccessHandler) 
//            .logoutSuccessUrl("/mingle") // 로그아웃 성공 시 리디렉션할 URL
//            .invalidateHttpSession(true) // 세션 무효화// 로그인 성공 후 이동할 기본 URL
//            // .failureUrl("/mingle/fail") // 로그인 실패 시 이동할 URL (필요한 경우)
//         // 커스텀 필터 추가
//        .and()
//            .addFilterBefore(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) {
//		auth.authenticationProvider(customAuthenticationProvider);
//	}
	
	
	
	// 2. 비밀번호 암호화 순환참조때문에 다른 config에서 생성.
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

//	@Autowired
//	private UserSecDetailsServiceImple userSecDetailsServiceImple;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		auth.userDetailsService(userSecDetailsServiceImple).passwordEncoder(passwordEncoder());
//	}

}

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
@EnableWebSecurity(debug = true)
@Order(2)
public class UserSecurityConfig {

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
//	@Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/js/**", "/css/**", "/assets/**", "/font/**", "/img/**");
//    }

	// 1. 접근 경로 필터링.
	@Bean
	protected SecurityFilterChain filterChain (HttpSecurity http) throws Exception {

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
                .antMatchers("/mypage/**").hasRole("USER")// 마이페이지는 인증받은 사람만 // 인증받지 않으면 exceptionHandling
                //.antMatchers("/mypage/**").hasRole("USER")// 마이페이지는 인증받은 사람만 // 인증받지 않으면 exceptionHandling
                .anyRequest().permitAll(); // 다른 인가 요청은 모두 인증없이 모두 허용
                // .antMatchers("/user").hasRole("USER") // 인증과 인가에 대해서
        http // http 설정 시작.                
                .formLogin(login -> login. // 폼 로그인 설정
                        loginPage("/user/login_joinForm")
                        // .loginProcessingUrl("/user/loginProc")//Action 스프링 시큐리티가 해당 주소로 요청(request)오는
                        // 로그인을 가로채서 대신 로그인 해준다.
                        // .defaultSuccessUrl("/")// 인증이 성공하면 여기로 이동한다.
                        .loginProcessingUrl("/user/loginproc") // 해당 URL 로 접근 시 로그인 프로세스 실행
                        .usernameParameter("userid") // 사용자아이디 파라미터 name을 정의
                        .passwordParameter("userpwd") // 비밀번호 파라미터 name을 정의
                        .successHandler(customAuthenticationSuccessHandler) // 로그인 성공시 해당 핸들러 실행
                        .failureHandler(customAuthenticationFailureHandler))// 그리고 http
                .logout(logout -> logout.// 로그아웃
                        logoutUrl("/user/logout") // 로그아웃 처리 URL 설정
                        .logoutSuccessHandler(customLogoutSuccessHandler)// 로그아웃 처리 핸들러
                        .logoutSuccessUrl("/") // 로그아웃 성공 시 리디렉션할 URL
                        .invalidateHttpSession(true) // 세션 무효화// 로그인 성공 후 이동할 기본 URL
                        .deleteCookies("JSESSIONID"))// 그리고 http
                .authenticationProvider(customAuthenticationProvider)//AuthenticationManagerBuilder 에서 provider를 지정해도 된다. 
                .csrf(csrf -> csrf.disable());// 테스트를 위해서
        http.exceptionHandling(handling -> handling
                .authenticationEntryPoint((request, response, authException) -> {
                    // 주의!!! AuthenticationEntryPoint를 직접 구현하게 되면
                    // 우리가 만든 로그인 페이지로 이동하게 된다. 
                    // 스프링 시큐리티가 제공하는 로그인 페이지가 아니다!
                    System.out.println(" filterChain 호출확인 exceptionHandling");
                    //response.sendRedirect("/mingle/login");
                    response.sendRedirect("/mingle/user/login_joinForm");
                }));
        http.oauth2Login(login -> login.loginPage("/user/login_joinForm"));
		return http.build();
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

//		http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);

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
	
//	구버전
//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		// TODO Auto-generated method stub
//		return super.authenticationManagerBean();
//	}


}

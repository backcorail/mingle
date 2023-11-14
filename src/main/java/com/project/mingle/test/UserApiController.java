package com.project.mingle.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

	@Autowired
	UserService userService;
	
	@GetMapping("/user")
	public TestVO user(TestVO tvo) {
		System.out.println("1 . UserApiController user @GetMapping :");
		UserVO uvo = new UserVO();
		uvo.setUsername("홍길동");
		uvo.setPassword("1231214");
		uvo.setEmail("tesadf@adfas.asdf");
		uvo.setRole("USER");
		//userService.userInsert(uvo);
		String email = userService.nameCheck("홍길동");
		if(email == null) {
			System.out.println("해당 사용자가 없습니다.");
		}else {
			System.out.println("DB연결 확인 email테스트 => "+ email);
		}		
		return tvo;
	}
	
	// 2 .post -> insult (Create )
	// http://localhost:9998/user
	@PostMapping("/user")
	public TestVO postTest(@RequestBody TestVO tvo) {
		System.out.println("2 . UserApiController user @PostMapping :");
		System.out.println(tvo.toString());
		return tvo;
	}
	
	
	// 3. put  -> update ( Update )
	// http://localhost:9998/user
	@PutMapping("/user")
	public TestVO putTest(@RequestBody TestVO tvo) {
		System.out.println("3 . UserApiController user @PutMapping :");
		System.out.println(tvo.toString());
		return tvo;
	}
	
	
	// 4. delete -> delete ( Delete )
	// http://localhost:9998/user
	@DeleteMapping("/user")
	public TestVO deleteTest(@RequestBody TestVO tvo) {
		System.out.println("4 . UserApiController user @DeleteMapping :");
		System.out.println(tvo.toString());
		return tvo;
	}
}

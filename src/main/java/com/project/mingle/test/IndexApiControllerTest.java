package com.project.mingle.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexApiControllerTest {

	// 0. - 안녕 테스트 - 서버의 안부를 묻는 연결.
	// http://localhost:9998/hello
	@GetMapping("/hello")
	public String hello() {
		return "<h1>hello<h1>";
	}
	
	
	// 1 .get -> select ( Read )
	// http://localhost:9998/board
	@GetMapping("/board")
	public String getTest(TestVO tvo) {
		System.out.println("getTest 호출 확인");
		System.out.println(tvo.toString());
		return "get 요청을했습니다";
	}
	
	
	// 2 .post -> insult (Create )
	// http://localhost:9998/board
	@PostMapping("/board")
	public String postTest(@RequestBody TestVO tvo) {
		System.out.println("postTest 호출 확인");
		System.out.println(tvo.toString());
		return "post 요청을했습니다";
	}
	
	
	// 3. put  -> update ( Update )
	// http://localhost:9998/board
	@PutMapping("/board")
	public String putTest(@RequestBody TestVO tvo) {
		System.out.println("putTest 호출 확인");
		System.out.println(tvo.toString());
		return "put 요청을했습니다";
	}
	
	
	// 4. delete -> delete ( Delete )
	// http://localhost:9998/board
	@DeleteMapping("/board")
	public String deleteTest(@RequestBody TestVO tvo) {
		System.out.println("deleteTest 호출 확인");
		System.out.println(tvo.toString());
		return "dlelet 요청을했습니다";
	}
}

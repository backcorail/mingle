package com.project.mingle.controller;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.mingle.service.StyleService;
import com.project.mingle.vo.AdminTestVO;
import com.project.mingle.vo.AdminVO;
import com.project.mingle.vo.ReplyVO;
import com.project.mingle.vo.StyleVO;

@Controller

@RequestMapping("/style")
public class StyleController {
	@Autowired
	StyleService service; // 서비스의 내용을 가져온다.
	
	@GetMapping("")
	public ModelAndView style_main(
			@RequestParam(name="tabs", defaultValue = "1") int tabs,
			StyleVO sVO) {
		ModelAndView mav =  new ModelAndView();
		sVO.setTabs(tabs);
		mav.addObject("sVO", sVO);
		mav.setViewName("style/style_main");	
		return mav;
	}

	@GetMapping("/ranking")
	public String style_ranking() {
		return "style/style_ranking";
	}
	
	@GetMapping("/request")
	public String style_request() {
		return "style/style_request";
	}
	
	@GetMapping("/styles")
	public ModelAndView style_styles(StyleVO sVO) {
		ModelAndView mav =  new ModelAndView();
		
		List<StyleVO> kreamList = service.kreamData(sVO);
		mav.addObject("sVO", sVO);
		mav.addObject("klist", kreamList);
		
		mav.setViewName("style/style_styles");	
		return mav;
	}
	
	
	@GetMapping("/trend/info")
	public ModelAndView style_trendinfo(StyleVO sVO) {
		ModelAndView mav =  new ModelAndView();
		
		List<StyleVO> reply = service.replySelect(sVO);
		
		mav.addObject("sVO", sVO);
		mav.addObject("reply", reply);
		
		mav.setViewName("style/style_trendinfo");	
		return mav;
	}
	
	@GetMapping("/trend")
	public String style_trend() {
		return "style/style_trend";
	}
	
	@GetMapping("/write")
	public String style_stylewrite() {
		return "style/style_write";
	}
	
	@GetMapping("/requestwrite")
	public String style_requestwrite() {
		return "style/request_write";
	}
	
	@PostMapping("/writeOk")
	public ModelAndView styleWriteOk(StyleVO vo, HttpServletRequest request, Principal principal) {
		ModelAndView mav = new ModelAndView();
		vo.setUser_id(principal.getName());
		
		int result = service.styleInsert(vo);
		if (result > 0) {
			mav.setViewName("redirect:list");
		} else {
			mav.addObject("msg", "등록");
			mav.setViewName("board/boardResult");
		}
		return mav;
		
	}
	
	
	@GetMapping("/map")
	public String style_map() {
		return "style/map";
	}

	
	@PostMapping("/products_data") // 넣을때
	public ModelAndView products_data(@RequestBody ReplyVO replyVO) {
		ModelAndView mav = new ModelAndView();
		System.out.println("replyVO+asd "+replyVO.toString());
		//게시글 데이터
		 int result = service.usercomment(replyVO);

		//List<AdminVO> list = service.resell_boardData(styleVo);
		
		//사용자 데이터
		// List<AdminTestVO> userlist = service.usersData(new AdminTestVO());
		 
		// mav.addObject("rVO", rVO);
		// mav.addObject("userlist", userlist);
		// mav.setViewName("admin/products_data");
		 
		return mav;
	}
	
}
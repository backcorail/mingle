package com.project.mingle.controller;

import java.io.File;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.project.mingle.service.StyleService;
import com.project.mingle.vo.Comment;
import com.project.mingle.vo.ReplyVO;
import com.project.mingle.vo.StyleFileVO;
import com.project.mingle.vo.StyleInfo;
import com.project.mingle.vo.StyleInfoDTO;
import com.project.mingle.vo.StyleVO;
import com.project.mingle.vo.Stylefile;

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
	  public String listStyles1(Model model) {
		 
		 List<StyleInfo> styleInfos = service.getAllStyleInfo();
		 System.out.println("listStyles");
		 System.out.println(styleInfos.size());
		
		 
		 for (StyleInfo styleInfo : styleInfos) {
			// System.out.println("styleInfo" + styleInfo.getStyleFileName());
			// System.out.println("styleInfo" + styleInfo.getStyleName());
			 System.out.println("styleInfo" + styleInfo.getStyle_no());
			// System.out.println("styleInfo" + styleInfo.getUserId());
			// System.out.println("styleInfo" + styleInfo.getUserImg());
			// System.out.println(styleInfo.toString());
		}
	        model.addAttribute("styles", styleInfos);
	        System.out.println("실행");
	        return "style/style_ranking"; // JSP 파일 이름
	    }
	
	
	
	@GetMapping("/request")
	public String style_request() {
		return "style/style_request";
	}
	
	//@GetMapping("/styles")
	public ModelAndView style_styles(StyleVO sVO) {
		ModelAndView mav =  new ModelAndView();
		List<StyleVO> list = service.styleList(sVO);
		List<StyleVO> fileList = service.styleImgFile(sVO);
		List<StyleVO> kreamList = service.kreamData(sVO);
		System.out.println(kreamList);
		mav.addObject("fileList", fileList);
		mav.addObject("sVO", sVO);
		mav.addObject("klist", kreamList);
		mav.addObject("list", sVO);
		mav.addObject("ReplyVO", sVO);
		mav.addObject("StyleVO", sVO);
		mav.setViewName("style/style_styles");	
		return mav;
	}
	
	 @GetMapping("/styles")
	    public String listStyles(Model model) {
		 
		 List<StyleInfo> styleInfos = service.getAllStyleInfo();
		 System.out.println("listStyles");
		 System.out.println(styleInfos.size());
		
		 
		 for (StyleInfo styleInfo : styleInfos) {
			// System.out.println("styleInfo" + styleInfo.getStyleFileName());
			// System.out.println("styleInfo" + styleInfo.getStyleName());
		
			// System.out.println("styleInfo" + styleInfo.getUserId());
			// System.out.println("styleInfo" + styleInfo.getUserImg());
			// System.out.println(styleInfo.toString());
		}
	        model.addAttribute("styles", styleInfos);
	        System.out.println("실행");
	        return "style/style_styles"; // JSP 파일 이름
	    }
	
	
	 @GetMapping("/trend/info/{style_no}")
	 public ModelAndView style_trendinfo(@PathVariable("style_no") int style_no) {
	     
		ModelAndView mav =  new ModelAndView();
		List<Stylefile> files = service.getfiles(style_no);
		List<Comment> comments = service.getcomments(style_no);
		
		StyleInfoDTO info = service.getStyleDetails(style_no);
		info.setFiles(files);
		info.setComment(comments);
		mav.addObject("info", info);
		
		//System.out.println(sVO.toString());
		//mav.addObject("reply", reply);
		
		
		mav.setViewName("style/style_trendinfo");	
		return mav;
	}
	
	
	@GetMapping("/trend")
	public ModelAndView style_trend(StyleVO sVO) {
		ModelAndView mav =  new ModelAndView();
		
		List<StyleVO> kreamList = service.kreamData(sVO);
		System.out.println(kreamList);
		mav.addObject("sVO", sVO);
		mav.addObject("klist", kreamList);
		mav.addObject("ReplyVO", sVO);
		mav.setViewName("style/style_trend");	
		return mav;
	}
	
	
	
	@GetMapping("/write")
	public String style_stylewrite() {
		return "style/style_write";
	}
	
	@PostMapping("/writeOk")
	@Transactional(rollbackFor={RuntimeException.class, SQLException.class})
	public ModelAndView styleWriteOk(StyleVO vo, HttpSession session, HttpServletRequest hsr, Principal principal) {
		ModelAndView mav = new ModelAndView();
		String username = principal.getName();
		if(username == null) {
			mav.setViewName("user/login_joinForm");
			return mav;
		}
		vo.setUser_id(principal.getName());
		
		//2. 파일업로드 (rename)
		//업로드할 위치 폴더(절대주소로 구한다.)구하기
		String path = session.getServletContext().getRealPath("/uploadfile");
		System.out.println("path->"+ path);
		
		// HttpServletRequest -> MultipartHttpServletRequest객체를 구한다.
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)hsr;
		
		//mr객체 내에 파일의 수만큼 MultipartFile객체가 있다.
		List<MultipartFile> filesList = mr.getFiles("filename"); //input 태그의 name 속성값
		// 업로드 한 파일목록을 보관 DatafileVO -> List
		List<StyleFileVO> uploadFileList = new ArrayList<StyleFileVO>();
		
		if(filesList != null){//업로드 파일이 있을때
			for(int i=0; i<filesList.size(); i++) {// 첨부된 파일 만큼 반복수행
				MultipartFile mf = filesList.get(i);
				
				String orgFilename = mf.getOriginalFilename();//클라이언트가 선택한 원래 파일명을 구한다.
				
				if(orgFilename!=null && !orgFilename.equals("")){ // if2
					//이미 서버에 같은 파일이 있으면 rename을 수행한다.  car.jpg -> car(1).jpg -> car(2).jpg -> car(3).jpg
					
					File f = new File(path, orgFilename);
					
					if(f.exists()) {// 파일이 있으면 true, 파일이 없으면 false if3
						// rename -> 파일명 찾기
						for(int renameNum = 1; ;renameNum++) {
							//확장자와 파일명분리
							int point = orgFilename.indexOf(".");//점위치구하기
							String filenameNoExt = orgFilename.substring(0, point);//파일명(확장자빼고) car
							String ext = orgFilename.substring(point+1);//확장자 gif
							
							//새로운 파일명 만들기
							String newFilename = filenameNoExt+"("+renameNum+")."+ext; // car(1).jpg
							f = new File(path, newFilename);
							if(!f.exists()) {//새로운 파일명이 서버에 있는지 확인 if4
								orgFilename = newFilename; // 새로 만든 파일이 서버에 없으면 반복중단
								break;
							}//if 4
						}// for2
						
					}//if3
					//업로드
					try {
						mf.transferTo(f);//서버에 실제 업로드 되는 시점.
					}catch(Exception e) {}
					
					//업로드 
					StyleFileVO fVO = new StyleFileVO();
					fVO.setStyle_file_name(orgFilename);
					uploadFileList.add(fVO);
				}//if2
			}//for1
			
		}//if1
		try {
			int result = service.styleInsert(vo);
			System.out.println(result);
			//업로드 파일명
			for(StyleFileVO fVO: uploadFileList) {
				fVO.setStyle_no(vo.getStyle_no());
			}
			System.out.println(uploadFileList+"123456");
			int fileResult = service.styleFileInsert(uploadFileList);
			
			//4. 추가 성공하면 -> 자료실목록
			mav.addObject("tab", "tab");
			mav.setViewName("style/style_main");
			
		}catch(Exception e) {
			e.printStackTrace();
			//5. 실패하면 레코드와, 파일을 삭제하고 글올리기 폼으로 이동
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			//이미 업로드된 파일을 삭제
			for(StyleFileVO fVO : uploadFileList) {
				File f = new File(path, fVO.getStyle_file_name());
				f.delete();
			}
			
			//글등록폼으로 이동
			mav.setViewName("style/request_result");
			
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
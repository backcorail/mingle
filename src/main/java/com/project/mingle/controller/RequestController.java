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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.project.mingle.service.RequestService;
import com.project.mingle.vo.RequestFileVO;
import com.project.mingle.vo.RequestVO;


@Controller
@RequestMapping("/style/request")
public class RequestController {
	@Autowired
	RequestService service;
	
	@GetMapping("/list")
	public ModelAndView boardList(RequestVO vo, RequestFileVO rfvo) {
		ModelAndView mav = new ModelAndView();
		List<RequestVO> list = service.requestList(vo);
		List<RequestFileVO> fileList = service.getImgFile(rfvo);
		System.out.println(fileList);
		mav.addObject("rfvo", rfvo);
		mav.addObject("list", list);
		mav.addObject("fileList", fileList);
		mav.setViewName("style/style_request");
		return mav;
	}
	
	@GetMapping("/write")
	public String request_write() {
		return "style/request_write";
	}
	
	@PostMapping("/writeOk")
	@Transactional(rollbackFor={RuntimeException.class, SQLException.class})
	public ModelAndView reqeust_writeOk(RequestVO rvo, HttpSession session, HttpServletRequest hsr, Principal principal) {
		ModelAndView mav = new ModelAndView();
		rvo.setUser_id(principal.getName());
		
		//2. 파일업로드 (rename)
		//업로드할 위치 폴더(절대주소로 구한다.)구하기
		String path = session.getServletContext().getRealPath("/uploadfile");
		System.out.println("path->"+ path);
		
		// HttpServletRequest -> MultipartHttpServletRequest객체를 구한다.
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)hsr;
		
		//mr객체 내에 파일의 수만큼 MultipartFile객체가 있다.
		List<MultipartFile> filesList = mr.getFiles("filename"); //input 태그의 name 속성값
		// 업로드 한 파일목록을 보관 DatafileVO -> List
		List<RequestFileVO> uploadFileList = new ArrayList<RequestFileVO>();
		
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
					RequestFileVO fVO = new RequestFileVO();
					fVO.setRequest_datafile_dataname(orgFilename);
					uploadFileList.add(fVO);
				}//if2
			}//for1
			
		}//if1
		try {
			int result = service.requestInsert(rvo);
			System.out.println(result);
			//업로드 파일명
			for(RequestFileVO fVO: uploadFileList) {
				fVO.setRequest_no(rvo.getRequest_no());
			}
			System.out.println(uploadFileList+"123456");
			int fileResult = service.requestFileInsert(uploadFileList);
			
			//4. 추가 성공하면 -> 자료실목록
			mav.setViewName("style/style_ranking");
			
		}catch(Exception e) {
			e.printStackTrace();
			//5. 실패하면 레코드와, 파일을 삭제하고 글올리기 폼으로 이동
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			//이미 업로드된 파일을 삭제
			for(RequestFileVO fVO : uploadFileList) {
				File f = new File(path, fVO.getRequest_datafile_dataname());
				f.delete();
			}
			
			//글등록폼으로 이동
			mav.setViewName("style/request_result");
			
		}
		return mav;
		
	}
	
	@GetMapping("/{request_no}")
	public ModelAndView request_view(@PathVariable("request_no") int request_no) {
		ModelAndView mav  = new ModelAndView();
		//원글선택
		RequestVO vo = service.requestSelect(request_no);
		//첨부파일 
		mav.addObject("vo", vo);//목록
		//뷰페이지
		mav.setViewName("style/request_board");
		return mav;
	}
}

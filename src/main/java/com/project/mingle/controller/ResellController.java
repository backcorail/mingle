package com.project.mingle.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.project.mingle.service.ResellService;
import com.project.mingle.vo.RequestFileVO;
import com.project.mingle.vo.RequestVO;
import com.project.mingle.vo.ItemFileVO;
import com.project.mingle.vo.ResellItemVO;
import com.project.mingle.vo.ResellVO;

@Controller
@RequestMapping("/resell")
public class ResellController {
	
	@Autowired
	ResellService service;

	@GetMapping("")
	public ModelAndView resell_main(
			@RequestParam(name="no", defaultValue="0") int no,
			@RequestParam(name="page", defaultValue="1") int page,
			@RequestParam(name="search", defaultValue="") String[] search,
			@RequestParam(name="category", defaultValue="0") int category,
			@RequestParam(name="detail", defaultValue="0") int detail,
			@RequestParam(name="sort", defaultValue="latest_desc") String sort,
			ResellVO rVO) {
		
		ModelAndView mav = new ModelAndView();
		
		String[] main = {"All", "Men", "Women", "Other"};
		String[] title = {"Top", "Outer", "Bottom", "Shose", "Bag"};;
		String[] Top = {"전체", "맨투맨/스웨트 셔츠", "니트/스웨터", "긴소매 티셔츠", "카라 티셔츠", "반소매 티셔츠", "민소매 티셔츠", "후드 티셔츠", "스포츠 상의", "셔츠/블라우스", "기타 상의"};
		String[] Outer = {"전체", "후드 집업", "블루종", "라이더 재킷", "트러커 재킷", "슈트/블레이저 재킷", "무스탕/퍼", "카디건", "아노락", "코트", "패딩", "나일론/코치 재킷", "기타 아우터"};
		String[] Bottom = {"전체", "데님팬츠", "코튼 팬트", "슈트 팬츠/슬랙스", "트레이닝/조거 팬츠", "숏 팬츠", "스포츠 하의", "기타 바지"};
		String[] Shose = {"전체", "구두", "부츠", "힐/펌프스", "운동화", "슬리퍼", "샌들", "기타 신발"};
		String[] Bag = {"전체", "백팩", "크로스백/매신저백", "슬링백", "핸드백", "지갑", "기타 가방"};
		mav.addObject("main", main);
		mav.addObject("title", title);
		mav.addObject("Top", Top);
		mav.addObject("Outer", Outer);
		mav.addObject("Bottom", Bottom);
		mav.addObject("Shose", Shose);
		mav.addObject("Bag", Bag);
		
		String searchAll = "";
		for(int i=0; i<search.length; i++) {
			searchAll += search[i];
			if(i != search.length-1) {
				searchAll += ",";
			}
		}
		
		rVO.setNowPage(page);
		rVO.setSearchWord(searchAll);
		rVO.setCategory(category);
		rVO.setDetail(detail);
		rVO.setSort(sort);
		
		if (search.length > 0 && !"".equals(search[0])) {
			rVO.setSearchWord1(search[0]);
		}
		if (search.length > 1 && !"".equals(search[1])) {
	        rVO.setSearchWord2(search[1]);
	    }
	    if (search.length > 2 && !"".equals(search[2])) {
	        rVO.setSearchWord3(search[2]);
	    }

		// 총 레코드 수(resell_totalRecord)
		rVO.setTotalRecord(service.resell_totalRecord(rVO));
		rVO.setKtotalRecord(service.kream_totalRecord(rVO));
		
		// 총 페이지수 계산을 setTotalPage 메소드에서 계산
		rVO.setTotalPage();
		rVO.setKtotalPage();
		
		// 게시글 데이터
		List<ResellVO> list = service.resell_boardData(rVO);
		List<ResellVO> kreamList = service.kreamData(rVO);
		
		mav.addObject("rVO", rVO);
		mav.addObject("list", list);
		mav.addObject("klist", kreamList);
		mav.setViewName("resell/resell_main");
		return mav;
	}
	
	
	
	@GetMapping("/board")
	public ModelAndView resell_board(
			@RequestParam(name="no", defaultValue="0") int no,
			@RequestParam(name="page", defaultValue="1") int page,
			@RequestParam(name="search", defaultValue="") String[] search,
			@RequestParam(name="category", defaultValue="0") int category,
			@RequestParam(name="detail", defaultValue="0") int detail,
			@RequestParam(name="sort", defaultValue="latest_desc") String sort,
			HttpServletRequest request,
			ResellVO rVO) {
		
		ModelAndView mav = new ModelAndView();
		
		String[] main = {"All", "Men", "Women", "Other"};
		mav.addObject("main", main);
		
		ResellVO boardData = service.boardData(no);
		mav.addObject("boardData", boardData);
		mav.addObject("rVO", rVO);
		
		mav.setViewName("resell/resell_board");
		return mav;
	}

	
	
	@GetMapping("/write")
	public ModelAndView resell_write(ResellVO rVO) {
		ModelAndView mav = new ModelAndView();
		List<ResellVO> kreamList = service.kreamData(rVO);
		mav.addObject("rVO", rVO);
		mav.addObject("klist", kreamList);
		mav.setViewName("resell/resell_write");
		return mav; 
	}
	
  
  
	@PostMapping("/writeOk")
	@Transactional(rollbackFor={RuntimeException.class, SQLException.class})
	public ModelAndView resell_writeOk(
			ResellItemVO rivo,
			HttpSession session,
			HttpServletRequest hsr,
			Principal principal,
			ResellVO rVO) {
		
		ModelAndView mav = new ModelAndView();
		
		rVO.setResell_seller(principal.getName());
		System.out.println(principal.getName()+" --- 1");
		
		//2. 파일업로드 (rename)
		//업로드할 위치 폴더(절대주소로 구한다.)구하기
		String path = session.getServletContext().getRealPath("/uploadfile");
		System.out.println("path->"+ path+" --- 2");
		
		// HttpServletRequest -> MultipartHttpServletRequest객체를 구한다.
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)hsr;
		
		//mr객체 내에 파일의 수만큼 MultipartFile객체가 있다.
		List<MultipartFile> filesList = mr.getFiles("filename"); //input 태그의 name 속성값
		// 업로드 한 파일목록을 보관 DatafileVO -> List
		List<ItemFileVO> uploadFileList = new ArrayList<ItemFileVO>();
		
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
					ItemFileVO ifVO = new ItemFileVO();
					ifVO.setItem_file_name(orgFilename);
					uploadFileList.add(ifVO);
				}//if2
			}//for1
			
		}//if1
		try {
			//아이템 업로드
			int result = service.itemInsert(rivo);
			System.out.println("result : "+result+" --- 3");
			
			//글 업로드
			rVO.setItem_no(rivo.getItem_no());
			int result1 = service.resellInsert(rVO);
			System.out.println("result : "+result1+" --- 4");
			
			//업로드아이템 사진 파일명
			for(ItemFileVO ifVO: uploadFileList) {
				ifVO.setItem_no(rivo.getItem_no());
			}
			System.out.println(uploadFileList+"123456"+" --- 5");
			int fileResult = service.itemFileInsert(uploadFileList);
			System.out.println("fileResult"+fileResult+" --- 6");
			//4. 추가 성공하면 -> 자료실목록
			
			TransactionAspectSupport.currentTransactionStatus().flush();
			mav.setViewName("home");
			
		}catch(Exception e) {
			e.printStackTrace();
			//5. 실패하면 레코드와, 파일을 삭제하고 글올리기 폼으로 이동
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			//이미 업로드된 파일을 삭제
			for(ItemFileVO ifVO : uploadFileList) {
				File f = new File(path, ifVO.getItem_file_name());
				f.delete();
			}
			
			//글등록폼으로 이동
			mav.addObject("msg", "등록");	
			mav.setViewName("resell/write_result");
			
		}
		return mav;

		
	}
  
  
  
  @GetMapping("/board/delete")
	public void board_delete() {}
}

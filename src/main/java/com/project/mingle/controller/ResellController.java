package com.project.mingle.controller;


import java.util.List;
import java.util.Set;

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
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.ast.CombinedBinaryExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
		String[] title = {"Top", "Outer", "Bottom", "Shose", "Bag"};
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

		ResellVO boardData = service.resell_select(no); // no를 통한 게시글 데이터 받아오기
		ResellVO itemData = service.item_select(no); // no를 통한 아이템 데이터 받아오기
		List<String> imageData = service.image_select(no); // no를 통한 이미지 데이터 받아오기
		mav.addObject("itemData", itemData);
		mav.addObject("boardData", boardData);
		
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
		
		// no를 통한 게시글 데이터 받아오기
		ResellVO boardData = service.resell_select(no);
		// no를 통한 아이템 데이터 받아오기
		ResellVO itemData = service.item_select(no);
		// no를 통한 이미지 데이터 받아오기
		List<String> imageData = service.image_select(no);
		// 유저 데이터 가져오기 위한 객체 생성

		if (boardData != null) {
			ResellVO userData = service.user_select(boardData.getResell_seller());
			mav.addObject("userData", userData);
			System.out.println("글 작성자(user_id) -> "+boardData.getResell_seller());
			System.out.println("글 데이터(ResellVO) -> "+userData);
		} else {
			System.out.println("값이 없음");
		}
		
		mav.addObject("boardData", boardData);
		mav.addObject("itemData", itemData);
		mav.addObject("imageData", imageData);
		
		mav.addObject("rVO", rVO);
		
		mav.setViewName("resell/resell_board");
		return mav;
	}

	
	
	@GetMapping("/write")
	public ModelAndView resell_write(
			@RequestParam(name="no", defaultValue="0") int no,
			ResellVO rVO) {
		
		ModelAndView mav = new ModelAndView();
		
		String[] main = {"all", "men", "women", "other"};
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
		
		// no를 통한 게시글 데이터 받아오기
		ResellVO boardData = service.resell_select(no);
		// no를 통한 아이템 데이터 받아오기
		ResellVO itemData = service.item_select(no);
		// no를 통한 이미지 데이터 받아오기
		List<String> imageData = service.image_select(no);
		
		mav.addObject("boardData", boardData);
		mav.addObject("itemData", itemData);
		mav.addObject("imageData", imageData);
		mav.addObject("rVO", rVO);
		
		mav.setViewName("resell/resell_write");
		return mav; 
	}
	
  
  
	@PostMapping("/writeOk")
	@Transactional(rollbackFor={RuntimeException.class, SQLException.class})
	public ModelAndView resell_writeOk(
			@RequestParam(name="no", defaultValue="0") Integer no,
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
		List<ResellVO> uploadFileList = new ArrayList<>();
		List<String> filelist = new ArrayList<>();
		
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
					} catch(Exception e) {}
					
					// 이미지 이름 저장하기
					ResellVO imageVO = new ResellVO(rVO);
					// 여기에 원하는 변수 넣으면됨.
					
					imageVO.setItem_file_name(orgFilename);
					if(no != 0) {imageVO.setItem_no(no);}
					// 배열에 추가
					uploadFileList.add(imageVO);
				}//if2
			}//for1
			
		}//if1
		try {
			System.out.println(uploadFileList);
			if(no == 0) { // 새로 작성할때
				rVO.setItem_status("판매중");
				service.item_insert(rVO); //아이템 업로드
				for(int i=0; i<uploadFileList.size(); i++) {
					uploadFileList.get(i).setItem_no(rVO.getItem_no());
				}
				service.resell_insert(rVO); //글 업로드
				service.image_insert(uploadFileList); // 이미지 업로드
			} else if (no != 0) { // 수정할때
				rVO.setItem_no(no);
				service.resell_update(rVO); // 글 업데이트
				service.item_update(rVO); // 아이템 업데이트
				service.image_delete(no); // 이미지 삭제
				service.image_insert(uploadFileList); // 이미지 다시 추가
			}
			
			if(!uploadFileList.isEmpty()) {
				ResellVO firstFile = uploadFileList.get(0);
				String firstFileName = firstFile.getItem_file_name();
				System.out.println(firstFileName + " --- 7");
			}
			TransactionAspectSupport.currentTransactionStatus().flush();
			mav.setViewName("redirect:/resell");
			
		} catch(Exception e) {
			e.printStackTrace();
			//5. 실패하면 레코드와, 파일을 삭제하고 글올리기 폼으로 이동
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			//이미 업로드된 파일을 삭제
			for(ResellVO ifVO : uploadFileList) {
				File f = new File(path, ifVO.getItem_file_name());
				f.delete();
			}
			
			//글등록폼으로 이동
			mav.addObject("msg", "등록");	
			mav.setViewName("/resell/write_result");
		}
		return mav;
	}
	
	
  
	@GetMapping("/delete")
	public ModelAndView board_delete(
			@RequestParam(name="no", defaultValue="0") int no,
			HttpServletRequest request,
			HttpSession session,
			ResellVO rVO) {
		ModelAndView mav = new ModelAndView();
		String path = session.getServletContext().getRealPath("/uploadfile");
		File file = new File(path);
		
		List<String> fileList = service.image_select(no);
		
		int result1 = service.resell_delete(no);
		int result2 = service.image_delete(no);
		int result3 = service.item_delete(no);
		if(result1 > 0 && result2 > 0 && result3 > 0) {
			mav.setViewName("redirect:/resell");
		} else {
			String referer = request.getHeader("referer");
			mav.setViewName("redirect:" + (referer != null ? referer : "/"));
		}
		return mav;
	}
	
	
	@GetMapping("/itemBuy")
	public ModelAndView item_buy (
			@RequestParam(name="no", defaultValue="0") int no,
			HttpServletRequest request,
			Principal principal,
			ResellVO rVO) {
		ModelAndView mav = new ModelAndView();
		String userId = principal.getName();
        rVO.setResell_buyer(userId);
		rVO.setItem_no(no);
		rVO.setItem_status("판매완료");
        service.resell_buyer(rVO);
        service.item_buyer(rVO);
		System.out.println(rVO);
		if(true) {
			mav.setViewName("redirect:/resell");
		}
		return mav;
	}
}

package com.project.mingle.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
			@RequestParam(name="category", defaultValue="1") int category,
			@RequestParam(name="detail", defaultValue="0") int detail,
			@RequestParam(name="sort", defaultValue="latest") String sort,
			ResellVO rVO) {
		ModelAndView mav = new ModelAndView();
		//rVO.setNowPage(page);
		
		List<ResellVO> kreamList = service.kreamData(rVO);
		mav.addObject("rVO", rVO);
		mav.addObject("klist", kreamList);
		
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
}

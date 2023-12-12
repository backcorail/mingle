package com.project.mingle.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.mingle.mapper.RequestMapper;
import com.project.mingle.vo.RequestFileVO;
import com.project.mingle.vo.RequestVO;

@Service
public class RequestServiceImpl implements RequestService{
	@Inject
	RequestMapper mapper;
	@Override
	public int requestInsert(RequestVO rvo) {
		return mapper.requestInsert(rvo);
	}
	
	@Override
	public int requestFileInsert(List<RequestFileVO> list) {
		System.out.println(list+"1234");
		return mapper.requestFileInsert(list);
	}

	@Override
	public RequestVO requestSelect(int request_no) {
		return mapper.requestSelect(request_no);
	}
}

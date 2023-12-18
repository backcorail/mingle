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
		return mapper.requestFileInsert(list);
	}

	@Override
	public RequestVO requestSelect(int request_no) {
		return mapper.requestSelect(request_no);
	}

	@Override
	public List<RequestVO> requestList(RequestVO rVO) {
		return mapper.requestList(rVO);
	}

	@Override
	public List<RequestFileVO> getImgFile(RequestFileVO rfvo) {
		return mapper.getImgFile(rfvo);
	}

	@Override
	public int replyInsert(RequestVO rvo) {
		return mapper.replyInsert(rvo);
	}

	@Override
	public List<RequestVO> replySelect(int no) {
		return mapper.replySelect(no);
	}

	@Override
	public int replyUpdate(RequestVO rvo) {
		return mapper.replyUpdate(rvo);
	}

	@Override
	public int replyDelete(int request_reply_no) {
		return mapper.replyDelete(request_reply_no);
	}
}

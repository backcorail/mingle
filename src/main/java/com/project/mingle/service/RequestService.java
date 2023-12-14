package com.project.mingle.service;

import java.util.List;

import com.project.mingle.vo.RequestFileVO;
import com.project.mingle.vo.RequestVO;
import com.project.mingle.vo.ResellVO;
import com.project.mingle.vo.UserVO;

public interface RequestService {
	public int requestInsert(RequestVO rvo);
	public int requestFileInsert(List<RequestFileVO> list);
	public RequestVO requestSelect(int request_no);
	public List<RequestVO> requestList(RequestVO rVO);
	public List<RequestFileVO> getImgFile(RequestFileVO rfvo);
}

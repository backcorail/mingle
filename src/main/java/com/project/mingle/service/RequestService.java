package com.project.mingle.service;

import java.util.List;

import com.project.mingle.vo.RequestFileVO;
import com.project.mingle.vo.RequestVO;

public interface RequestService {
	public int requestInsert(RequestVO rvo);
	public int requestFileInsert(List<RequestFileVO> list);
}

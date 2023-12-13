package com.project.mingle.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.mingle.mapper.HomeMapper;
import com.project.mingle.vo.ResellVO;

@Service
public class HomeServiceImpl implements HomeService{
	@Inject
	HomeMapper mapper;

	@Override
	public List<ResellVO> homeResellList(int num) {
		return mapper.homeResellList(num);
	}

}

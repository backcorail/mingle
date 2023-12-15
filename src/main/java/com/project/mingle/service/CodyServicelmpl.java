package com.project.mingle.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.mingle.mapper.CodyMapper;
import com.project.mingle.vo.CodyTestVO;
import com.project.mingle.vo.UserVO;

@Service
public class CodyServicelmpl implements CodyService{
	@Inject
	CodyMapper mapper;
	
	@Override
	public List<CodyTestVO> cody_boardData(CodyTestVO cVO){
		return mapper.cody_boardData(cVO);
	}
	@Override
	public UserVO getgender(String userid) {
		// TODO Auto-generated method stub
		return mapper.getgender(userid);
	}
	
	
}

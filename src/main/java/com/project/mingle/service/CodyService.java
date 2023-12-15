package com.project.mingle.service;

import java.util.List;

import com.project.mingle.vo.CodyTestVO;
import com.project.mingle.vo.UserVO;

public interface CodyService {
	public List<CodyTestVO>cody_boardData(CodyTestVO cVO);//데이터 가져오기
	public UserVO getgender(String userid);
}

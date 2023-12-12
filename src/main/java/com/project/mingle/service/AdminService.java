package com.project.mingle.service;

import java.util.List;

import com.project.mingle.vo.AdminTestVO;
import com.project.mingle.vo.AdminVO;

public interface AdminService {
	//public int resell_totalRecord(AdminVO rVO);
	public int kream_totalRecord(AdminVO rVO);
	//public List<AdminVO> resell_boardData(AdminVO rVO);
	public List<AdminVO> kreamData(AdminVO rVO);
	public List<AdminTestVO> usersData(AdminTestVO rVO);
	
	//유저 수 카운팅
	int countUsers();
}

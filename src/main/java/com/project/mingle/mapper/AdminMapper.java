package com.project.mingle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.mingle.vo.AdminTestVO;
import com.project.mingle.vo.AdminVO;

@Mapper
public interface AdminMapper {
	
	//public int resell_totalRecord(AdminVO rVO);
	public int kream_totalRecord(AdminVO rVO);
	//public List<AdminVO> resell_boardData(AdminVO rVO);
	public List<AdminVO> kreamData(AdminVO rVO);
	public List<AdminTestVO> usersData(AdminTestVO rVO);
	
	//유저 수 카운팅
	int countUsers();
	
}

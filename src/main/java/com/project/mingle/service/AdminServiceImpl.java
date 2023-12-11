package com.project.mingle.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.project.mingle.mapper.AdminMapper;
import com.project.mingle.vo.AdminTestVO;
import com.project.mingle.vo.AdminVO;

@Service
public class AdminServiceImpl implements AdminService{

		@Inject
		AdminMapper mapper;

		/*@Override
		public int resell_totalRecord(AdminVO rVO) {
			// TODO Auto-generated method stub
			return mapper.resell_totalRecord(rVO);
		}*/

		@Override
		public int kream_totalRecord(AdminVO rVO) {
			// TODO Auto-generated method stub
			return mapper.kream_totalRecord(rVO);
		}

		/*@Override
		public List<AdminVO> resell_boardData(AdminVO rVO) {
			// TODO Auto-generated method stub
			return mapper.resell_boardData(rVO);
		}*/

		@Override
		public List<AdminVO> kreamData(AdminVO rVO) {
			// TODO Auto-generated method stub
			return mapper.kreamData(rVO);
		}

		@Override
		public List<AdminTestVO> usersData(AdminTestVO rVO) {
			// TODO Auto-generated method stub
			return mapper.usersData(rVO);
		}

		@Override
		public int countUsers() {
			// TODO Auto-generated method stub
			return mapper.countUsers();
		}
}

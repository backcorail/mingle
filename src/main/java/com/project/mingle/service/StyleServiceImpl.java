package com.project.mingle.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.project.mingle.mapper.StyleMapper;
import com.project.mingle.vo.AdminTestVO;
import com.project.mingle.vo.ReplyVO;
import com.project.mingle.vo.StyleVO;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.project.mingle.mapper.StyleMapper;
import com.project.mingle.vo.StyleVO;

@Service
public class StyleServiceImpl  implements StyleService{

	@Inject
	StyleMapper mapper;
	
	

	@Override
	public int kream_totalRecord(StyleVO sVO) {
		
		return mapper.kream_totalRecord(sVO);
	}


	@Override
	public List<StyleVO> kreamData(StyleVO sVO) {
		
		return mapper.kreamData(sVO);
	}


	@Override
	public int style_likes_check(StyleVO sVO) {
		
		return mapper.style_likes_check(sVO);
	}
  
  	@Override
	public int styleInsert(StyleVO vo) {
		return mapper.styleInsert(vo);
	}


	@Override
	public int usercomment(ReplyVO replyVO) {
		// TODO Auto-generated method stub
		return mapper.usercomment(replyVO);
	}


	@Override
	public List<StyleVO> replySelect(StyleVO StyleVO) {
		
		return mapper.replySelect(StyleVO);
	}


	@Override
	public List<ReplyVO> getAllComments() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<StyleVO> replySelect() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int replycnt(StyleVO sVO) {
		// TODO Auto-generated method stub
		return mapper.replycnt(sVO);
	}


	@Override
	public int gettotallike(ReplyVO replyVO) {
		// TODO Auto-generated method stub
		return mapper.gettotallike(replyVO);
	}



}

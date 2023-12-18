package com.project.mingle.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.project.mingle.mapper.StyleMapper;
import com.project.mingle.vo.StyleFileVO;
import com.project.mingle.vo.StyleInfo;
import com.project.mingle.vo.StyleInfoDTO;
import com.project.mingle.vo.AdminTestVO;
import com.project.mingle.vo.Comment;
import com.project.mingle.vo.ReplyVO;
import com.project.mingle.vo.StyleVO;
import com.project.mingle.vo.Stylefile;

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
	public int styleFileInsert(List<StyleFileVO> list) {
		return mapper.styleFileInsert(list);
	}
	public int usercomment(ReplyVO replyVO) {
		// TODO Auto-generated method stub
		return mapper.usercomment(replyVO);
	}


	@Override
	public List<StyleVO> replySelect(int style_no) {
		
		return mapper.replySelect(style_no);
	}


	
	@Override
	public int replycnt(StyleVO sVO) {
		// TODO Auto-generated method stub
		return mapper.replycnt(sVO);
	}
	

	@Override
	public StyleVO styleSelect(int style_no) {
		// TODO Auto-generated method stub
		return mapper.styleSelect(style_no);
	}


	@Override
	public List<StyleVO> styleList(StyleVO sVO) {
		// TODO Auto-generated method stub
		return mapper.styleList(sVO);
	}


	@Override
	public List<StyleVO> styleImgFile(StyleVO sVO) {
		// TODO Auto-generated method stub
		return mapper.styleImgFile(sVO);
	}


	@Override
	public List<StyleInfo> getAllStyleInfo() {
		
		return mapper.getAllStyleInfo();
	}


	@Override
	public StyleInfoDTO getStyleDetails(int styleNo) {
		
		return mapper.getStyleDetails(styleNo);
	}


	@Override
	public List<Stylefile> getfiles(int styleNo) {
		
		return mapper.getfiles(styleNo);
	}


	@Override
	public List<Comment> getcomments(int styleNo) {
		
		return mapper.getcomments(styleNo);
	}


	


	


	
		

}

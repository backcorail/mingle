package com.project.mingle.service;

import java.util.List;

import com.project.mingle.vo.Comment;
import com.project.mingle.vo.ReplyVO;
import com.project.mingle.vo.StyleFileVO;
import com.project.mingle.vo.StyleInfo;
import com.project.mingle.vo.StyleInfoDTO;
import com.project.mingle.vo.StyleVO;
import com.project.mingle.vo.Stylefile;

public interface StyleService {
	public int  style_likes_check(StyleVO svo); // 좋아요 체크
	public int  kream_totalRecord(StyleVO svo); // 크림 총 레코드
    // 	public List<StyleVO> Style_boardData(StyleVO sVO);
	public List<StyleVO> kreamData(StyleVO sVO);
	public int styleInsert(StyleVO vo);
	public int styleFileInsert(List<StyleFileVO> list);
    public int usercomment(ReplyVO replyVO);
	public List<StyleVO> replySelect(int style_no);
	public int replycnt(StyleVO sVO);
	
	public StyleVO styleSelect(int style_no);
	public List<StyleVO> styleList(StyleVO sVO);
	public List<StyleVO> styleImgFile(StyleVO sVO);
	public List<StyleInfo> getAllStyleInfo();
	public StyleInfoDTO getStyleDetails(int styleNo);
	public List<Stylefile> getfiles(int styleNo); // 
	public List<Comment> getcomments(int styleNo);
}

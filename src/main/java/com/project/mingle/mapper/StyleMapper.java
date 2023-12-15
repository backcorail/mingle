package com.project.mingle.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.mingle.vo.RequestFileVO;
import com.project.mingle.vo.RequestVO;
import com.project.mingle.vo.StyleFileVO;
import com.project.mingle.vo.StyleInfo;
import com.project.mingle.vo.StyleInfoDTO;
import com.project.mingle.vo.AdminTestVO;
import com.project.mingle.vo.Comment;
import com.project.mingle.vo.ReplyVO;
import com.project.mingle.vo.StyleVO;
import com.project.mingle.vo.Stylefile;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.project.mingle.vo.StyleVO;

@Mapper
public interface StyleMapper {
	// public int Style_totalRecord(StyleVO sVO);
	public int kream_totalRecord(StyleVO sVO);
	// public List<StyleVO> Style_boardData(StyleVO sVO);
	public List<StyleVO> kreamData(StyleVO sVO);
	public int style_likes_check(StyleVO sVO); // 좋아요 체크
	public int styleInsert(StyleVO vo); //스타일 작성 저장

	public int gettotallike(ReplyVO replyVO);

	public int styleFileInsert(List<StyleFileVO> list); // 스타일 이미지 저장
	public int gettotallike(int likeno);

    public int usercomment(ReplyVO replyVO); // 리플
	public List<StyleVO> replySelect(int style_no);
	public int replycnt(StyleVO sVO);
	
	public List<StyleInfo> getAllStyleInfo();
	public List<StyleVO> styleList(StyleVO sVO); // 게시글 관련
	public StyleVO styleSelect(int style_no);//글 제목, 내용 등 선택
	public List<StyleVO> styleImgFile(StyleVO sVO); // style 목록 가져오기
	
	public StyleInfoDTO getStyleDetails(int styleNo);
	
	public List<Stylefile> getfiles(int styleNo); // 
	public List<Comment> getcomments(int styleNo);
}

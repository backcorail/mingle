package com.project.mingle.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.mingle.vo.RequestFileVO;
import com.project.mingle.vo.StyleFileVO;
import com.project.mingle.vo.AdminTestVO;
import com.project.mingle.vo.ReplyVO;
import com.project.mingle.vo.StyleVO;
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
	public List<StyleVO> replySelect(StyleVO StyleVO);
	public int replycnt(StyleVO sVO);
}

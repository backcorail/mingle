package com.project.mingle.service;

import com.project.mingle.vo.StyleVO;
import java.util.List;
import com.project.mingle.vo.StyleVO;

public interface StyleService {
	public int  style_likes_check(StyleVO svo); // 좋아요 체크
	public int  kream_totalRecord(StyleVO svo); // 크림 총 레코드
    // 	public List<StyleVO> Style_boardData(StyleVO sVO);
	public List<StyleVO> kreamData(StyleVO sVO);
  public int styleInsert(StyleVO vo);
}

package com.project.mingle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.mingle.vo.RequestFileVO;
import com.project.mingle.vo.RequestVO;

@Mapper
public interface RequestMapper {
	//글작성
	public int requestInsert(RequestVO rvo);//글작성
	public int requestFileInsert(List<RequestFileVO> list);//파일명 insert
	//글선택
	public List<RequestVO> requestList(RequestVO rVO); // 데이터 가져오기
	public RequestVO requestSelect(int request_no);//글 제목, 내용 등 선택
	public List<RequestFileVO> getImgFile(RequestFileVO rfvo);//첨부파일선택
	//댓글작성
	public int replyInsert(RequestVO rvo);//댓글 입력
	public List<RequestVO> replySelect(int no);//댓글 선택
	public int replyUpdate(RequestVO rvo);//댓글 수정
	public int replyDelete(int request_reply_no);//댓글 삭제
}

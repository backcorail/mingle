package com.project.mingle.vo.mypage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyRequestReplyVO implements MyActInfo{
	// 6개
		//기본 데이터
		private int request_reply_no;// 리퀘스트 리플 글번호
		private int request_no;// 리퀘스트 글번호
		private String user_id; //작성자
		
		private String request_reply_comment;
		private String request_reply_writedate;//작성일자
		
		//추가 데이터
		private String  request_name; // 리퀘스트제목	
		
		@Override
		public String getType() {
			// TODO Auto-generated method stub
//			return "MyStyleVO";
			return "리퀘스트";
		}
		@Override
		public String getTitle() { //리퀘스트보드의 제목
			// TODO Auto-generated method stub
			return getRequest_name();
		}
		@Override
		public String getContents() { //리퀘스트 댓글 내용
			// TODO Auto-generated method stub
			return getRequest_reply_comment();
		}
		@Override
		public String getWriteDate() { //댓글 작성일자.
			// TODO Auto-generated method stub
			return getRequest_reply_writedate();
		}
		@Override
		public int getNo() { //댓글테이블 넘버.
			// TODO Auto-generated method stub
			return getRequest_no();
		}
		@Override
		public String getImg() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String getSelldone() {
			// TODO Auto-generated method stub
			return null;
		}

}

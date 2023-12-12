package com.project.mingle.vo;

import lombok.Data;

@Data
public class RequestFileVO {
	//이미지 파일 업로드
		private int request_no;//원글의 글번호
		private String request_datafile_dataname;//첨부파일명
}

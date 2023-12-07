package com.project.mingle.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminTestVO {
	private String searchWord;
	
	private int offsetPoint;	//데이터 시작 부분
	private int onePageRecord = 25; //한페이지 레코드 수
	
	private String user_id; 
	private String user_email;
	private String user_pwd;
	private String user_nick;
	private Integer user_gender;
	private String user_tel;
	private String user_addr;
	private String user_img;
	private String user_regdate;
	private String user_secdate;
	private Integer user_status;
	private String user_unlock;
	private String userOauth;
}

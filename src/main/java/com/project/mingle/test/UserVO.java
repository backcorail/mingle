package com.project.mingle.test;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder //빌더 패턴!!
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {

	private int id; 
	private String username; //아이디
	private String password;
	private String email;
	private String role; 
	private Timestamp createDate;
	private String oauth; // kakao ,google
}

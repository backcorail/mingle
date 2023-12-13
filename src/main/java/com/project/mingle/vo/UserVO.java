package com.project.mingle.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVO {
	//private Integer userNo;		//1) nn 
	private String user_id; 			//2) nn 
	private String user_email;		//3) nn => n
	private String user_pwd;		//4) nn
	private String user_nick;		//5) nn
	private Integer user_gender;//6) nn =>n 1: 남자 / 2:여자
	private String user_tel;			//7) 둘다 가능
	private String user_addr;		//8) nn =>n
	private String user_img;			//9) 기본이미지
	private String user_regdate;	//10) nn
	private String user_secdate;	//11)
	private Integer user_status;	//12) nn
	private String user_unlock;	//13)
	private String user_Oauth;		//14)
	private String user_role;		//15) 	ROLE_USER
	

//	private Integer userNo;		//1)
//    private String userId; 			//2)
//    private String userEmail;	//3)
//    private String userPwd;		//4)
//    private String userName;	//5)
//    private String userNick;		//6)
//    private String userTel;		//7)
//    private Integer userGender;//8)
//    private String userAddr;		//9)
//    private String userImg;		//10)
//    private String userRegdate;	//11)
//    private String userSecdate;	//12)
//    private String userStatus;	//13)
//    private String userOauth;	//14)
    
// 추가 구현 사항 Enum 
//	public void setUserStatus(UserStatusType userStatus) {
//		this.userStatus = userStatus.toString();
//	}
}

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

	private Integer userNo;		//1)
    private String userId; 			//2)
    private String userEmail;	//3)
    private String userPwd;		//4)
    private String userName;	//5)
    private String userNick;		//6)
    private String userTel;		//7)
    private Integer userGender;//8)
    private String userAddr;		//9)
    private String userImg;		//10)
    private String userRegdate;	//11)
    private String userSecdate;	//12)
    private String userStatus;	//13)
    private String userOauth;	//14)
    
// 추가 구현 사항 Enum 
//	public void setUserStatus(UserStatusType userStatus) {
//		this.userStatus = userStatus.toString();
//	}

}
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class UserVO {
//
//  private int user_no;		//1)
//  private String user_id; 	//2)
//  private String user_email;	//3)
//  private String user_pwd;	//4)
//  private String user_name;	//5)
//  private String user_nick;	//6)
//  private int user_gender;	//7)
//  private String user_addr;	//8)
//  private String user_img;	//9)
//  private String user_regdate;	//10)
//  private String user_secdate;	//11)
//  private String user_status;	//12)
//  private String user_oauth;	//13)
//
//  // ... 나머지 메소드들
//}

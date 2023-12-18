package com.project.mingle.vo.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OauthJoinUserVO {
	private String userid; 			
	private String userpwd;		
	private String usernick;
	private String userOauth;
	
}

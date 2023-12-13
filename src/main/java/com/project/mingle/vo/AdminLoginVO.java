package com.project.mingle.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminLoginVO {
	@Builder
	public AdminLoginVO(String admin_id, String admin_pwd, String admin_role) {
		this.admin_id = admin_id;
		this.admin_pwd = admin_pwd;
		this.admin_role = admin_role;
	}
	private String admin_id;	
    private String admin_pwd;
    private String admin_role;

 
}

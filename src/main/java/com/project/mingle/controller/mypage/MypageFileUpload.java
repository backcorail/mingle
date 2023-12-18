package com.project.mingle.controller.mypage;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class MypageFileUpload {
	
	// 파일 업로드 업로드 구현
	public static String fileUpload(String path, MultipartFile file, String newFileName) {
		// 클라이언트가 선택한 파일의 파일명을 구한다.
		// rename영역
		try {
			file.transferTo(new File(path, newFileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newFileName;
	}
}

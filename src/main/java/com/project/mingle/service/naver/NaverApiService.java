package com.project.mingle.service.naver;

import java.io.File;

import com.project.mingle.vo.naver.NaverCapKeyVO;

public interface NaverApiService {

	public File getCaptcha();

	public File getCaptchaAudio();

	public boolean capkeycheck(NaverCapKeyVO naverCapKeyVO);

}

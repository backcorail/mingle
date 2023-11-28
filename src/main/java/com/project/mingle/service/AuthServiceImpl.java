package com.project.mingle.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

	public String generateAndSendOtp(String phone) {
		
        // 인증번호 생성
        String otp = generateOtp();

        // SMS API를 사용하여 전화번호로 인증번호 전송
        sendOtpToPhone(phone, otp);

        return otp;
    }

    public boolean verifyOtp(String submittedOtp, String sessionOtp) {
        // 세션에 저장된 인증번호와 사용자가 제출한 인증번호를 비교
        return submittedOtp.equals(sessionOtp);
    }
    
    private String generateOtp() {
        Random random = new Random();
        int otp = random.nextInt(1000000); // 0부터 999999까지의 정수를 생성
        return String.format("%06d", otp); // 6자리 숫자 형식으로 문자열 변환
    }
    
    private void sendOtpToPhone(String phone, String otp) {
    	// 문자 보내기 전송.
    }
    
}

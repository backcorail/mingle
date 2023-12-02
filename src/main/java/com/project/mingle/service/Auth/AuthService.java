package com.project.mingle.service.Auth;

public interface AuthService {

	String generateAndSendOtp(String phone);

	boolean verifyOtp(String otp, String sessionOtp);

}

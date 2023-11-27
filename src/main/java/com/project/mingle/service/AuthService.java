package com.project.mingle.service;

public interface AuthService {

	String generateAndSendOtp(String phone);

	boolean verifyOtp(String otp, String sessionOtp);

}

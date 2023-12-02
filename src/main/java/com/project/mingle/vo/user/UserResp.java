package com.project.mingle.vo.user;

public enum UserResp {
	USERIDOK(101,"사용가능 아이디"),
	USERIDDD(102,"중복된 아이디"),
	USERIDRETURNE(103,"아이디찾기"),
	
	OTPOK(111,"OTP 인증 성공"),
	OTPFAIDL(112,"OTP 인증 실패"),
	
	USERNICKOK(121,"사용가능 닉네임"),
	USERNICKDD(122,"중복된 닉네임"),
	
	JOINSUCCESS(131,"회원가입 성공"),
	JOINFAILD(132,"회원가입 실패"),
	
	LOGINOK(141,"로그인성공"),
	LOGINFAILD(142,"로그인실패"),
	LOGINATTEMPTS(143,"캡차로이동"),
	
	TELIDEMPTY(151,"사용자전화번호불일치"),
	TELIDDD(152,"사용자전화번호일치"),
	
	TELNOREG(161,"등록안된번호"),
	TELREG(162,"등록된번호"),
	
	PWDMODYOK(171,"변경성공"),
	PWDMODYFAILD(172,"변경실패"),
	
	CAPTCHAOK(181,"캡차성공"),
	CAPTCHAFAILD(182,"캡차실패");
	
	
	
	
	// 필드 선언
    private final int value;
    private final String message;

    // enum 생성자
    UserResp(int value, String message) {
        this.value = value;
        this.message = message;
    }

    // getter 메소드
    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}

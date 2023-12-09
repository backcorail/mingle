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
	LOGOUTOK(144,"로그아웃"),
	
	TELIDEMPTY(151,"사용자전화번호불일치"),
	TELIDDD(152,"사용자전화번호일치"),
	
	TELNOREG(161,"등록안된번호"),
	TELREG(162,"등록된번호"),
	
	PWDMODYOK(171,"변경성공"),
	PWDMODYFAILD(172,"변경실패"),
	
	CAPTCHAOK(181,"캡차성공"),
	CAPTCHAFAILD(182,"캡차실패"),
	
	PASSWORDOK(191,"비밀번호같은"),
	PASSWORDFAILD(192,"비밀번호오류"),
	
	ID_C_OK(211,"아이디변경성공"),
	ID_C_FAILE(212,"아이디변경실패"),
	ID_C_DD(213,"아이디중복"),
	
	PW_C_OK(221,"비밀번호변경성공"),
	PW_C_FAILE(222,"비밀번호변경실패"),
	
	NICK_C_OK(231,"닉네임변경성공"),
	NICK_C_FAILE(232,"닉네임변경실패"),
	NICK_C_DD(233,"닉네임중복"),
	
	TEL_C_OK(241,"전화변호 변경성공"),
	TEL_C_FAILE(242,"전화변호 변경실패"),
	TEL_C_DD(243,"전화변호 중복"),
	
	ADDR_C_OK(251,"주소 변경성공"),
	ADDR_C_FAILE(252,"주소 변경실패"),
	
	GEN_C_OK(261,"성별 변경성공"),
	GEN_C_FAILE(262,"성별 변경실패"),
	
	IMG_C_OK(271,"프로필 변경성공"),
	IMG_C_FAILE(272,"프로필 변경실패"),
	IMG_C_BLANK(273,"파일이 비어 있습니다."),
	
	;
	
	
	
	
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

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://kit.fontawesome.com/7b899d6a28.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/mingle/css/user/loginForm.css">
<link rel="stylesheet" href="/mingle/css/user/fp_Form.css">
<link rel="stylesheet" href="/mingle/css/user/fi_Form.css">
<link rel="stylesheet" href="/mingle/css/user/joinForm.css">
<main>
	<div class="container">
		<!-- 로그인폼 시작 -->
		<div class="div-main-form div-main-lg">
			<div class="blank-102"></div>
			<div class="div-logo">mingle</div>
			<div class="blank-22"></div>
			<div class="div-tile-desc">Mixing various fashions into one</div>
			<!-- 아이디 비밀번호 -->
			<div class="blank-20"></div>
			<div class="div-login-outline">
				<div class="div-id-text">아이디</div>
				<input id="userid" name="userid" type="text" class="in-txt" placeholder="예)asdf12345">
				<div class="blank-20"></div>
				<div class="div-pwd-text">비밀번호</div>
				<input id="userpwd" name="userpwd" type="password" class="in-txt" placeholder="예)qwert0987654">
			</div>
			<!-- 로그인 버튼 -->
			<div class="div-020"></div>
			<input id="btn-main-login" class="btn-login" type="button" value="로그인">

			<!-- 회원가입 / 비밀 번호 / 아이디 찾기-->
			<!-- <div class="blank-35"></div> -->
			<div class="blank-20"></div>
			<ul class="ul-user-option">
				<li><input type="button" value="회원가입" class="btn-joinform"></li>
				<li class="li-col-line"><div></div></li>
				<li><input type="button" value="비밀번호 찾기" class="btn-findpwd"></li>
				<li class="li-col-line"><div></div></li>
				<li><input type="button" value="아이디찾기" class="btn-findid"></li>
			</ul>
			<div class="blank-41"></div>
			<p class="txt-sns-login">or Sign Up Using</p>
			<div class="blank-27"></div>
			<ul class="ul-sns-list">
				<li><a href=""><img src="/mingle/img/user/naver.png" alt="naver"></a></li>
				<li><a href=""><img src="/mingle/img/user/kakao.png" alt="naver"></a></li>
				<li><a href=""><img src="/mingle/img/user/google.png" alt="naver"></a></li>
				<li><a href=""><img src="/mingle/img/user/facebook.png" alt="naver"></a></li>
			</ul>
			<div class="blank-56"></div>
		</div>
		<!-- 로그인 폼 끝 -->
		<!------------------------- -->
		<!-- 비밀번호 찾기 -->
		<!-- 1. 전화 번호인증 시작 -->
		<div class="div-main-form div-fp-s1">
			<div class="div-245"></div>
			<div class="div-logo">mingle</div>
			<div class="blank-22"></div>
			<div class="div-tile-desc">Mixing various fashions into one</div>
			<div class="div-065"></div>
			<div class="div-line1-b2-FW Yaldevi-SemiBold-40y">비밀번호 찾기</div>
			<div class="div-050"></div>
			<div class="div-line1-b1-Fw Yaldevi-SB-20y">아이디와 전화번호를 입력해주세요.</div>

			<!-- 아이디 -->
			<div class="div-180"></div>
			<div class="div-login-outline2">
				<div class="div-id-text">아이디</div>
				<!-- <input type="hidden" id="pw-userid-chk" value="N"> -->
				<input id="pw-userid" name="pw-userid" type="text" class="in-txt" placeholder="예) asdqwe123456">
				
			</div>
			<!-- 전화번호 -->
			<div class="div-070"></div>
			<div class="div-login-outline2">
				<div class="div-id-text">전화번호</div>
				<!-- <input type="hidden" id="pw-usertel-chk" value="N"> -->
				<input id="pw-usertel" name="pw-usertel" type="text" class="in-txt" placeholder="예) 01012345678">
			</div>

			<!-- 다음 버튼 -->
			<div class="div-220"></div>
			<input id="btn-pw-next1" class="btn-login3" type="button" value="다음">
			<div class="div-300"></div>
			<ul class="ul-user-option">
				<li><input type="button" value="회원가입" class="btn-joinform"></li>
				<li class="li-col-line"><div></div></li>
				<li><input type="button" value="비밀번호 찾기" class="btn-findpwd"></li>
				<li class="li-col-line"><div></div></li>
				<li><input type="button" value="아이디찾기" class="btn-findid"></li>
			</ul>
			<div class="blank-41"></div>
		</div>
		<!-- 1. 전화 번호 인증 끝 -->
		<!-- 2. 인증번호 입력 시작 -->
		<div class="div-main-form div-fp-s2">
			<div class="div-245"></div>
			<div class="div-logo">mingle</div>
			<div class="div-110"></div>
			<div class="div-tile-desc">Mixing various fashions into one</div>
			<div class="div-145"></div>
			<div class="div-line1-b2-FW Yaldevi-SemiBold-40y">인증코드</div>
			<div class="div-050"></div>
			<div class="div-line2-b1-Fw Yaldevi-SB-20y">해당전화번호로 인증코드가 전송되었습니다. 해당 6자리를 입력해수세요.</div>

			<!-- 인증번호 -->

			<div class="div-inner-full">
				<div class="div-225"></div>
				<div class="div-bt-area">
					<div class="Yaldevi-SemiBold-20g"></div>
					<div id="pwotp-no-text" class="div-id-alret Yaldevi-SB-20r-A">입력하신 번호가 다릅니다. 다시 입력해주세요.</div>
				</div>
				<div class="div-input-num-area-34">
					<input class="otp1 pwotp1" type="text" maxlength="1">
					<input class="otp2 pwotp2" type="text" maxlength="1"> 
					<input class="otp3 pwotp3" type="text" maxlength="1"> 
					<input class="otp4 pwotp4" type="text" maxlength="1"> 
					<input class="otp5 pwotp5" type="text" maxlength="1"> 
					<input class="otp6 pwotp6" type="text" maxlength="1">
				</div>
			</div>
			<!-- 인증번호 확인 버튼 -->
			<div class="div-392"></div>
			<input id="btn-pw-next2" class="btn-login3" type="button" value="다음">
			<div class="div-300"></div>
			<ul class="ul-user-option">
				<li><input type="button" value="회원가입" class="btn-joinform"></li>
				<li class="li-col-line"><div></div></li>
				<li><input type="button" value="비밀번호 찾기" class="btn-findpwd"></li>
				<li class="li-col-line"><div></div></li>
				<li><input type="button" value="아이디찾기" class="btn-findid"></li>
			</ul>
			<div class="blank-41"></div>
		</div>
		<!-- 2. 인증번호 입력 끝 -->

		<!-- 3. 비밀번호 재설정 시작 -->
		<div class="div-main-form div-fp-s3">
			<div class="div-245"></div>
			<div class="div-logo">mingle</div>
			<div class="blank-22"></div>
			<div class="div-tile-desc">Mixing various fashions into one</div>
			<div class="div-065"></div>
			<div class="div-line1-b2-FW Yaldevi-SemiBold-40y">비밀번호 변경</div>
			<div class="div-050"></div>
			<!-- <div class="div-line1-b1-Fw Yaldevi-SB-20y">비밀번호를 변경해주세요.</div> -->
			<!-- 
        비밀번호가 일치하지 않습니다. 다시 입력해주세요.
        비밀번호가 같습니다. 현재비밀번호와 다르게 입력해주세요.
      -->
			<div class="div-050"></div>
			<div id="pw-dno-text" class="div-pwd-alret">비밀번호가 일치하지 않습니다. 다시 입력해주세요.</div>
			<div class="div-020"></div>
			<!-- 현재 비밀번호 -->
<!-- 			<div class="div-login-outline2">
				<div class="div-id-text">현재비밀번호</div>
				<input id="usertel" name="usertel" type="text" class="in-txt" placeholder="예) asdqwe123456">
			</div> -->
			<!-- 변경할 비밀번호 -->
			<div class="div-070"></div>
			<div class="div-login-outline2">
				<div class="div-id-text">변경할 비밀번호</div>
				<input id="pw-userpwd" name="pw-userpwd" type="text" class="in-txt" placeholder="예) asdqwe123456">
			</div>
			<!-- 비밀번호 확인-->
			<div class="div-070"></div>
			<div class="div-login-outline2">
				<div class="div-id-text">비밀번호 확인</div>
				<input id="pw-userpwd-re" name="pw-userpwd-re" type="text" class="in-txt" placeholder="예) asdqwe123456">
			</div>

			<!-- 비밀번호 재설정 버튼 -->
			<div class="div-090"></div>
			<input id="btn-pw-next3" class="btn-login3" type="button" value="확인">
			<div class="div-050"></div>
			<ul class="ul-user-option">
				<li><input type="button" value="회원가입" class="btn-joinform"></li>
				<li class="li-col-line"><div></div></li>
				<li><input type="button" value="비밀번호 찾기" class="btn-findpwd"></li>
				<li class="li-col-line"><div></div></li>
				<li><input type="button" value="아이디찾기" class="btn-findid"></li>
			</ul>
			<div class="blank-41"></div>
		</div>
		<!-- 3. 비밀번호 재설정 끝 -->
		<!-- 4. 비밀번호 변경 완료 시작-->
		<div class="div-pw-modal-bg">
			<div class="div-edit-pawd-area div-fp-s4 modal-inner-appear">
				<div class="div-160"></div>
				<div class="div-line1-b2-FW Yaldevi-SB-C-40y">비밀번호 변경 완료</div>
				<div class="div-130"></div>
				<div class="div-line1-b1-Fw2 Yaldevi-SB-C-20y">비밀번호 가 변경되었습니다. 로그인페이지로 이동합니다.</div>
				<div class="div-170"></div>
				<input id="btn-pw-next4" class="btn-login26" type="button" value="확인">
				<div class="div-210"></div>
			</div>
		</div>
		<!-- 4. 비밀번호 변경 완료 시작-->
		<!-- 비밓번호 찾기   끝-->

		<!-- 캡차 비밀번호 5실패시  진행  시작-->
		<!-- 1. 캡차 시작 -->
		<div class="div-main-form div-cap-s1">
			<input type="hidden" id="captchaing" value="Y" />
			<div class="div-245"></div>
			<div class="div-logo">mingle</div>
			<div class="blank-22"></div>
			<div class="div-tile-desc">Mixing various fashions into one</div>
			<div class="blank-20"></div>
			<div class="div-login-outline2">
				<div class="div-id-text">아이디</div>
				<input id="cap-userid" name="userid" type="text" class="in-txt" placeholder="예)asdf12345">
				<div class="blank-20"></div>
				<div class="div-p wd-text">비밀번호</div>
				<input id="cap-userpwd" name="userpwd" type="password" class="in-txt" placeholder="예)qwert0987654">
			</div>
			<!-- 캡차 적용구간 -->
			<div class="div-050"></div>

			<div id="div-chapcha-area">
				
				<div class="div-cap-area">
					<input id="cap-type" type="hidden" value="IMG" /><!-- IMG /AUDIO -->
					<img id="captchaImage">
					<div id="captchaAudio-wrap">
						<audio id="captchaAudio" controls></audio>
					</div>
					<div class="div-cap-re-au">
						<!-- TODO : 웹폰트 OR SVG적용 -->
						<img id="div-cap-reload" class="cap-option" src="/mingle/img/user/reload.png" />
						<!-- TODO : 웹폰트 OR SVG적용 -->
						<img id="div-cap-audio" class="cap-option" src="/mingle/img/user/audio.png" />
					</div>
				</div>
				<input id="intext-captcha" class="cap-txt" type="text" placeholder="캡차를 입력하세요" />
				
			</div>
			<!-- 다음 버튼 -->
			<div class="div-070"></div>
			<input id="btn-cap-login" class="btn-login3" type="button" value="로그인">
			<div class="blank-20"></div>
			<ul class="ul-user-option">
				<li><input type="button" value="회원가입" class="btn-joinform"></li>
				<li class="li-col-line"><div></div></li>
				<li><input type="button" value="비밀번호 찾기" class="btn-findpwd"></li>
				<li class="li-col-line"><div></div></li>
				<li><input type="button" value="아이디찾기" class="btn-findid"></li>
			</ul>
			<div class="blank-41"></div>
		</div>
		<!-- 1. 캡차 끝 -->
		<!-- 캡차 비밀번호 5실패시  진행  끝-->
		
		<!-- 아이디 찾기  진행  시작-->
		<!-- 2. 전화 번호인증 시작 -->
		<div class="div-main-form div-fi-s2">
			<div class="div-245"></div>
			<div class="div-logo">mingle</div>
			<div class="blank-22"></div>
			<div class="div-tile-desc">Mixing various fashions into one</div>
			<div class="div-345"></div>
			<div class="div-line1-b2-FW Yaldevi-SemiBold-40y">인증코드</div>
			<div class="div-050"></div>
			<div class="div-line1-b1-Fw Yaldevi-SB-20y">회원가입 시, 입력한 핸드폰 번호를 입력해주세요.</div>

			<!-- 전화번호 -->
			<div class="div-100"></div>
			<div class="div-login-outline2">
				<div class="div-id-text">전화번호</div>
				<input id="id-usertel" name="usertel" type="text" class="in-txt" placeholder="01012345678">
			</div>

			<!-- 다음 버튼 -->
			<div class="div-435"></div>
			<input id="btn-id-next2" class="btn-login3" type="button" value="다음">
			<div class="div-300"></div>
			<ul class="ul-user-option">
				<li><input type="button" value="회원가입" class="btn-joinform"></li>
				<li class="li-col-line"><div></div></li>
				<li><input type="button" value="비밀번호 찾기" class="btn-findpwd"></li>
				<li class="li-col-line"><div></div></li>
				<li><input type="button" value="아이디찾기" class="btn-findid"></li>
			</ul>
			<div class="blank-41"></div>
		</div>
		<!-- 2. 전화 번호 인증 끝 -->
		<!-- 3. 인증번호 입력 시작 -->
		<div class="div-main-form div-fi-s3">
			<div class="div-245"></div>
			<div class="div-logo">mingle</div>
			<div class="div-110"></div>
			<div class="div-tile-desc">Mixing various fashions into one</div>
			<div class="div-145"></div>
			<div class="div-line1-b2-FW Yaldevi-SemiBold-40y">아이디찾기</div>
			<div class="div-050"></div>
			<div class="div-line2-b1-Fw Yaldevi-SB-20y">해당전화번호로 인증코드가 전송되었습니다. 해당 6자리를 입력해수세요.</div>

			<!-- 인증번호 -->

			<div class="div-inner-full">
				<div class="div-225"></div>
				<div class="div-bt-area">
					<div class="Yaldevi-SemiBold-20g"></div>
					<div id="idotp-no-text" class="div-id-alret Yaldevi-SB-20r-A">입력하신 번호가 다릅니다. 다시 입력해주세요.</div>
				</div>
				<div class="div-input-num-area-34">
					<input class="otp1 idotp1" type="text" maxlength="1">
					<input class="otp2 idotp2" type="text" maxlength="1"> 
					<input class="otp3 idotp3" type="text" maxlength="1"> 
					<input class="otp4 idotp4" type="text" maxlength="1"> 
					<input class="otp5 idotp5" type="text" maxlength="1"> 
					<input class="otp6 idotp6" type="text" maxlength="1">
				</div>
			</div>
			<!-- 로그인 버튼 -->
			<div class="div-392"></div>
			<input id="btn-id-next3" class="btn-login3" type="button" value="다음">
			<div class="div-300"></div>
			<ul class="ul-user-option">
				<li><input type="button" value="회원가입" class="btn-joinform"></li>
				<li class="li-col-line"><div></div></li>
				<li><input type="button" value="비밀번호 찾기" class="btn-findpwd"></li>
				<li class="li-col-line"><div></div></li>
				<li><input type="button" value="아이디찾기" class="btn-findid"></li>
			</ul>
			<div class="blank-41"></div>
		</div>
		<!-- 3. 인증번호 입력 끝 -->

		<!-- 4. 아이디 확인 시작 -->
		<div class="div-main-form div-fi-s4">
			<div class="div-245"></div>
			<div class="div-logo">mingle</div>
			<div class="div-110"></div>
			<div class="div-tile-desc">Mixing various fashions into one</div>
			<div class="div-145"></div>
			<div class="div-line1-b2-FW Yaldevi-SemiBold-40y">아이디찾기</div>
			<div class="div-245"></div>
			<div class="div-userid-show-area">
				<div id="id-userid" class="div-userid Yaldevi-SB-24"></div>
			</div>

			<!-- 로그인 버튼 -->
			<div class="div-535"></div>
			<input id="btn-id-next4" class="btn-login3" type="button" value="로그인페이지 이동">
			<div class="div-300"></div>
			<ul class="ul-user-option">
				<li><input type="button" value="회원가입" class="btn-joinform"></li>
				<li class="li-col-line"><div></div></li>
				<li><input type="button" value="비밀번호 찾기" class="btn-findpwd"></li>
				<li class="li-col-line"><div></div></li>
				<li><input type="button" value="아이디찾기" class="btn-findid"></li>
			</ul>
			<div class="blank-41"></div>
		</div>
		<!-- 4. 아이디 확인 끝 -->
		<!-- 아이디 찾기 진행 끝 -->


	</div>
	<!-- container -->

	<!-- 모달 백그라운드 -->
	<div class="modal-bg">
		<!-- 가입창 모달 -회원정보 입력 111 -->
		<div id="div-user-modal" class="sign-modal-containder modal-inner-appear">
			<div class="div-line2-b2 Yaldevi-SemiBold-40y">
				회원가입을 위해<br />정보를 입력해주세요
			</div>
			<!-- 아이디 -->
			<div class="div-180"></div>
			<div class="div-bt-area">
				<div class="Yaldevi-SemiBold-20g">*아이디</div>
				<div id="joinid-yes-no-text" class="div-id-alret Yaldevi-SB-20g-A">사용가능한 아이디 입니다.</div>
			</div>
			<input id="join-userid" name="join-userid" type="text" class="in-txt">
			<!-- 아이디 중복검사 -->
			<div class="div-085"></div>
			<input type="hidden" name="chk" id="idchk" value="N">
			<input id="btn-id-dcheck" class="btn-login2" type="button" value="아이디 중복 검사">
			<!-- 비밀번호 -->
			<div class="div-085"></div>
			<div class="Yaldevi-SemiBold-20g">*비밀번호</div>
			<input id="join-userpwd" name="join-userpwd" type="text" class="in-txt">
			<!-- 비밀번호 확인 -->
			<div class="div-085"></div>
			<div class="div-bt-area">
				<div class="Yaldevi-SemiBold-20g">*비밀번호확인</div>
				<div id="joinpwd-yes-no-text" class="div-pwd-alret2 Yaldevi-SB-20r-A">비밀번호가 다릅니다. 다시입력해주세요</div>
			</div>
			<input id="join-userpwd-re" name="join-userpwd-re" type="text" class="in-txt">
			<!-- 전화번호 -->
			<div class="div-085"></div>
			<div class="Yaldevi-SemiBold-20g">*전화번호</div>
			<input id="join-usertel" name="join-usertel" type="text" class="in-txt" placeholder="숫자만 입력 예)01098761234">
			<!-- btn 취소 /  확인 -->
			<div class="div-435"></div>
			<div class="div-btn-area">
				<input id="btn-modal-cancle" class="btn-back Yaldevi-SB-20w-btn" type="button" value="취소"> 
				<input id="btn-next-tel" class="btn-next Yaldevi-SB-20w-btn" type="button" value="확인">
			</div>
		</div>
		<!-- 가입창 모달-회원정보 입력 끝111 -->

		<!-- 가입창 모달-인증번로 입력222 -->
		<div id="div-telaouth-modal" class="sign-modal-containder ">
			<div class="div-line1-b2 Yaldevi-SemiBold-40y">인증 번호</div>
			<div class="div-050"></div>
			<div class="div-line2-b1 Yaldevi-SB-20y">
				입력하신 번호로 문자가 발송되었습니다. <br> 확인하신 후 번호를 입력해주세요.
			</div>
			<!-- 인증번호 -->
			<div class="div-720"></div>
			<div class="div-bt-area">
				<div class="Yaldevi-SemiBold-20g"></div>
				<div id="joinotp-no-text" class="div-id-alret Yaldevi-SB-20r-A">입력하신 번호가 다릅니다. 다시 입력해주세요.</div>
			</div>
			<div class="div-input-num-area">
				<input class="otp1 joinotp1" type="text" maxlength="1">
				<input class="otp2 joinotp2" type="text" maxlength="1">
				<input class="otp3 joinotp3" type="text" maxlength="1">
				<input class="otp4 joinotp4" type="text" maxlength="1">
				<input class="otp5 joinotp5" type="text"	maxlength="1"> 
				<input class="otp6 joinotp6" type="text" maxlength="1">
			</div>
			<!-- btn 취소 /  확인 -->

			<div class="div-1395"></div>
			<div class="div-btn-area">
				<input id="btn-back-tel" class="btn-back Yaldevi-SB-20w-btn" type="button" value="이전">
				<input id="btn-next-name" class="btn-next Yaldevi-SB-20w-btn" type="button" value="확인">
			</div>
		</div>
		<!-- 가입창 모달-인증번로 입력 끝 222     -->


		<!-- 가입창 모달 333 -->
		<div id="div-name-modal" class="sign-modal-containder">
			<div class="div-line1-b2 Yaldevi-SemiBold-40y">이름</div>
			<div class="div-090"></div>
			<div class="div-line1-b1 Yaldevi-SB-20y">본인 실명을 입력해주세요. 사용자는 닉네임으로 표시됩니다.</div>

			<!-- 이름 
			<div class="div-680"></div>
			<div class="Yaldevi-SemiBold-20g">*이름</div>
			<input id="join-username" name="userpwd" type="password" class="in-txt">
			-->
			<!-- 닉네임 -->
			<div class="div-825"></div>
			<div class="Yaldevi-SemiBold-20g">*닉네임</div>
			<input id="join-usernick" name="join-usernick" type="text" class="in-txt">
			
			
			<!-- 닉네임 중복검사 -->
			<div class="div-130"></div>
			<input type="hidden" name="nickchk" id="nickchk" value="N">
			<input id="btn-nick-dcheck" class="btn-login2" type="button" value="닉네임 중복 검사" placeholder="한글/영어대소문자/숫자만 가능"> 
			<!-- btn 취소 /  확인 -->

			<div class="div-1110"></div>
			<div class="div-btn-area">
				<input id="btn-back-name" class="btn-back Yaldevi-SB-20w-btn" type="button" value="이전">
				<input id="btn-next-welcome" class="btn-next Yaldevi-SB-20w-btn" type="button" value="확인">
			</div>
		</div>
		<!-- 가입창 모달 끝 333     -->
		<!-- 가입창 모달 444 -->
		<div id="div-welcome-modal" class="sign-modal-containder-small">
			<div class="div-line1-b2-noW Yaldevi-SemiBold-40y">환영합니다.</div>
			<div class="div-090"></div>
			<div class="div-line1-b1 Yaldevi-SB-20y">
				Mingle 패밀리가 되신걸 환영합니다.<br>로그인 페이지로 돌아갑니다.
			</div>

			<!-- /  확인 -->

			<div class="div-1010"></div>
			<input id="div-next-login" class="btn-ok Yaldevi-SB-20w-btn" type="button" value="확인">

		</div>
		<!-- 가입창 모달 끝 444     -->

	</div>
	<!-- 모달 백그라운드 끝 -->

</main>
<script src="/mingle/js/layout_resize.js"></script>
<script src="/mingle/js/user.js"></script>
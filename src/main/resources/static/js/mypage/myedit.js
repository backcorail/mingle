

$(function() {

	$(".btn-userdata-common").click(function() {
		const btnStatus = $(this).val();

		var idValue = $(this).attr('id'); // id 값 가져오기
		const btnSubValue = idValue.replace("btn-", "");

		if (btnStatus == "변경") {
			if (btnSubValue == "useraddr") {
				addrPop();
			} else if (btnSubValue == "usergen") {
				console.log("성별체크");
				$("." + btnSubValue).removeAttr("disabled");
			} else {
				$("." + btnSubValue).removeAttr("readonly").focus().each(function() {
					var input = $(this);
					var len = input.val().length;
					input[0].selectionStart = input[0].selectionEnd = len;
				});
			}



			$(this).val("수정");
			return true;
			// 비어있는지 체크
			// 이전 데이터와 비교 들어있는 값비교.
			// 변경사항이 있으면 ajax날림.
			// 변경이 성공하면 알람창 호출 
		}

		if (btnStatus == '수정') {
			switch (btnSubValue) {
				case 'userid':
					// 'btn-userid'에 대한 처리
					console.log("User Password button clicked");
					const id = $("." + btnSubValue).val()
					if (idregcheck(id)) { // 닉네임 유효성검사 
						userDataAjax(btnSubValue, id)
					}
					break;

				case 'userpw':
					// 'userpw'에 대한 처리
					console.log("User Password button clicked");
					const pw = $("." + btnSubValue).val()
					if (pwRegcheck(pw)) { // 닉네임 유효성검사 
						userDataAjax(btnSubValue, pw)
					}
					break;

				case 'usernick':
					// 'usernick'에 대한 처리
					console.log("User Nickname button clicked");
					const nick = $("." + btnSubValue).val()
					if (nickregcheck(nick) && valueCheck(btnSubValue)) { // 닉네임 유효성검사 
						userDataAjax(btnSubValue, nick)
					}
					break;

				case 'usertel':
					// 'usertel'에 대한 처리 + 전화번호 중복검사
					console.log("User Telephone button clicked");
					const tel = $("." + btnSubValue).val()
					if (telRegcheck(tel) && valueCheck(btnSubValue)) { // 닉네임 유효성검사 
						userDataAjax(btnSubValue, tel)
					}
					break;

				case 'useraddr':
					// 'useraddr'에 대한 처리
					console.log("User Address button clicked");
					const addr = $("." + btnSubValue).val()
					if (valueCheck(btnSubValue)) { // 주소
						userDataAjax(btnSubValue, addr)
					}
					break;

				case 'usergen':
					// 'usergen'에 대한 처리
					console.log("User Gender button clicked");
					let gen = '';
					if ($('.usergen').is(':checked')) {
						// 체크박스가 체크되었을 때 실행할 코드
						gen = '1'; // 남자
						console.log("체크박스가 체크되었습니다.");
					} else {
						// 체크박스가 체크되지 않았을 때 실행할 코드
						gen = '2'; // 여자
						console.log("체크박스가 체크되지 않았습니다.");
					}
					userDataAjax(btnSubValue, gen);
					break;

				default:
					// 기타 경우 처리
					console.log("Other button clicked");
					break;
			}// switch	
		}// 수정 if
	}); // 버튼이벤트 공통
	const originData = {
		userid: $(".userid").val(),
		userpw: $(".userpw").val(),
		usernick: $(".usernick").val(),
		usertel: $(".usertel").val(),
		useraddr: $(".useraddr").val(),
		usergen: $(".usergen").val()
	}

	function valueCheck(btnSubValue) {

		var inputValue = $("." + btnSubValue).val();
		var originalValue = originData[btnSubValue];

		// 1) 입력 값이 비어 있는지 확인
		if (!inputValue) {
			alert("값이 비어 있습니다.");
			return false;
		}
		// 2) 값이 있다면 기존의 값과 비교
		if (inputValue === originalValue) {
			alert("입력한 값이 기존의 값과 동일합니다.");
			return false;
		}
		return true;
	}

	function userDataAjax(selData, inputValue) {
		const data = {
			type: selData,
			data: inputValue
		};
		$.ajax({
			url: '/mingle/mypage/user', // 실제 URL로 변경 필요
			type: 'PUT',
			data: JSON.stringify(data), // http body 데이터
			contentType: "application/json; charset=UTF-8",
			success: function(response) {
				var numberString = response.status+"";

				// 끝자리 숫자 추출
				var lastDigit = numberString.charAt(numberString.length - 1);
				if(lastDigit=='1'){
					const selBtnId = "btn-"+selData;
					if(selData=="usergen"){
						$("." + selData).attr("disabled", "disabled");
					}
					$("#"+selBtnId).val("변경");
					// 추가 작업
					alert(response.res);
				}else if(lastDigit=='2'){
					alert(response.res);
				}else if(lastDigit=='3'){
					alert(response.res);
				}
				console.log("데이터 전송 성공: ", response);
			},
			error: function(xhr, status, error) {
				// 에러 처리
				console.error("데이터 전송 실패: ", error);
			}
		});
	}// 정보수정 put 요청


	// 1)아이디 더블 체크
	function idregcheck(id) {
		//아이디 공백 체크
		if (id == "") {
			alert("아이디를 입력하세요");
			return false;
		}
		// 아이디 유효성체크
		var reg = /^\w{8,14}$/;
		if (!reg.test(id)) {
			alert("아이디는 영어대소문자, 숫자, _ 만 허용, 길이는 8~14글자 사이어야 합니다.");
			return false;
		}
		return true;
	};
	function iddcheck(id) {
		console.log("iddcheck check");
		let idcheck = {
			data: id
		}
		$.ajax({
			type: "POST",
			url: "/mingle/user/iddcheck",
			data: JSON.stringify(idcheck), // http body 데이터
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
			success: function(result) {
				console.log(result);
				if (result.status == 101) { // 사용가능 아이디

					return true;
				}
				if (result.status == 102) { // 중복된 아이디.

					return true;
				}

			},
			error: function(error) {
				console.log(error);
			}
		})
	}// 1)아이디 더블체크

	//2)닉네임 더블체크
	function nickregcheck(nick) {
		//닉네임 공백 체크
		if (nick == "") {
			alert("닉네임을를 입력하세요");
			return false;
		}
		// 닉네임 유효성체크
		var reg = /^[가-힣A-Za-z0-9\s]{1,30}$/;
		if (!reg.test(nick)) {
			alert("닉네임은 한글,영어대소문자, 숫자, 공백 포함 30글자 사이어야 합니다.");
			return false;
		}
		return true;
	}
	function nickdcheck(nick) {
		console.log("nickdcheck check");
		let nickcheck = {
			data: nick
		}
		$.ajax({
			type: "POST",
			url: "/mingle/user/nickdcheck",
			data: JSON.stringify(nickcheck), // http body 데이터
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
			success: function(result) {
				console.log(result);
				if (result.status == 121) { // 닉네임 성공
					alert("사용 가능 닉네임 입니다.");
					$("#nickchk").val("Y");
					return true;
				}
				if (result.status == 122) { // 닉네임 인증 실패 
					alert("닉네임 중복");
					return true;
				}

			},
			error: function(error) {
				console.log(error);
			}
		})
	}//2)닉네임 더블체크


	//3) 전화번호 더블체크
	function telRegcheck(tel) {
		//전화번호 있는지 확인 콜백2)
		if (tel == '') {
			alert("전화번호를 입력하세요."); return false;
		}
		const reg = /^\d{11}$/;
		if (!reg.test(tel)) {
			alert("전화번호를 잘못입력했습니다."); return false;
		}
		return true;
	}
	function teldcheck(tel) {
		console.log("teldcheck check");
		let _this = this;
		let telcheck = {
			data: tel
		}
		$.ajax({
			type: "POST",
			url: "/mingle/user/telcheck",
			data: JSON.stringify(telcheck), // http body 데이터
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
			success: function(result) {
				console.log(result);
				if (result.status == 161) { // 등록되지 않은 전화번호
					alert("등록되지 않는 번호입니다.");
					return false;
				}
				if (result.status == 162) { // 등록된 전화번호
					alert("이미 등록되어 있는 번호입니다.");
					// otp 진행 
					_this.sendOtp(tel);
					$(".div-fi-s2").css("display", "none");
					$(".div-fi-s3").css("display", "flex");
					_this.otpClear();
					$("#idotp-no-text").css('display', 'none')
					$(".idotp1").focus();
					return false;
				}

			},
			error: function(error) {
				console.log(error);
			}
		})
	}	//3) 전화번호 더블체크

	//4)비밀번호 유호성체크
	function pwRegcheck(pwd) {
		// 한글이 포함되어 있는지 체크
		let reg = /[ㄱ-ㅎㅏ-ㅣ가-힣]/;
		if (reg.test(pwd)) {
			alert("비밀번호에는 한글이 포함될 수 없습니다.");
			return false;
		}

		if (pwd.length > 20) {
			alert("비밀번호는 최대 20자까지만 허용됩니다.");
			return false;
		}
		// 영어 알파벳이 포함되어 있는지 체크
		reg = /[A-Za-z]/;
		if (!reg.test(pwd)) {
			alert("비밀번호에는 영어 알파벳이 적어도 하나 포함되어야 합니다.");
			return false;
		}
		// 숫자가 포함되어 있는지 체크
		reg = /[0-9]/;
		if (!reg.test(pwd)) {
			alert("비밀번호에는 숫자가 적어도 하나 포함되어야 합니다.");
			return false;
		}
		// 특수문자가 포함되어 있는지 체크
		reg = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/;
		if (!reg.test(pwd)) {
			alert("비밀번호에는 특수문자가 적어도 하나 포함되어야 합니다.");
			return false;
		}
		// 모든 조건을 만족
		return true;
	}	// 4)비밀번호 유호성체크

	//5)주소변경
	function addrPop() {
		new daum.Postcode({
			oncomplete: function(data) {
				let addr = data.sigungu + " " + data.bname;
				console.log(" addr  " + addr);
				$(".useraddr").val(addr);
			},
			onclose: function(state) {
				//state는 우편번호 찾기 화면이 어떻게 닫혔는지에 대한 상태 변수 이며, 상세 설명은 아래 목록에서 확인하실 수 있습니다.
				if (state === 'FORCE_CLOSE') {
					//사용자가 브라우저 닫기 버튼을 통해 팝업창을 닫았을 경우, 실행될 코드를 작성하는 부분입니다.
					// 수정을 변경으로 change
					$("#btn-useraddr").val("변경")
				} else if (state === 'COMPLETE_CLOSE') {
					//사용자가 검색결과를 선택하여 팝업창이 닫혔을 경우, 실행될 코드를 작성하는 부분입니다.
					//oncomplete 콜백 함수가 실행 완료된 후에 실행됩니다.
				}
			}
		}).open();

	}
	//5)주소변경

});// 제이쿼리
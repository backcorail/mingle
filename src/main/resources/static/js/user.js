let index = {
	init: function() {
		// 회원가입 모달
		$(".btn-joinform").on("click", () => {
			/*alert("로그인");*/
			this.userModalDataClean();
			$(".modal-bg").css("display", "block");
			$("#div-user-modal")
				.css("display", "block");
				
		});
		/*비밀번호 찾기*/
		$(".btn-findpwd").on("click", () => {
			$(".div-main-lg").css("display", "none");
			$(".div-fp-s2").css("display", "none");
			$(".div-fp-s3").css("display", "none");
			$(".div-fp-s4").css("display", "none");
			$(".div-fp-s1").css("display", "flex");
		});
		/*비밀번호 찾기 페이지 1- 전호번호 입력 확인*/
		$("#btn-pw-next1").on("click", () => {
			$(".div-fp-s1").css("display", "none");
			$(".div-fp-s2").css("display", "flex");
		});
		/*비밀번호 찾기 페이지 2- 인증번호 확인*/
		$("#btn-pw-next2").on("click", () => {
			$(".div-fp-s2").css("display", "none");
			$(".div-fp-s3").css("display", "flex");
		});
		/*비밀번호 찾기 페이지 3- 비밀번호 변경 확인*/
		$("#btn-pw-next3").on("click", () => {
			//$(".div-fp-s3").css("display", "none");
			$(".div-pw-modal-bg").css("display", "block");
			$(".div-fp-s4").css("display", "flex");
		});
		/*비밀번호 찾기 페이지 4- 로그인페이지로 이동 확인*/
		$("#btn-pw-next4").on("click", () => {
			$(".div-pw-modal-bg").css("display", "none");
			$(".div-fp-s3").css("display", "none");
			$(".div-fp-s4").css("display", "none");
			$(".div-main-lg").css("display", "flex");
		});
			
////////////////////////////////////////////////////////////////////////				
		/*아이디 찾기*/
		$(".btn-findid").on("click", () => {
			$(".div-main-lg").css("display", "none");
			$(".div-fi-s2").css("display", "none");
			$(".div-fi-s3").css("display", "none");
			$(".div-fi-s4").css("display", "none");
			$(".div-fi-s1").css("display", "flex");
		});
		/*비밀번호 찾기 페이지 1- 전호번호 입력 확인*/
		$("#btn-pw-next1").on("click", () => {
			$(".div-fi-s1").css("display", "none");
			$(".div-fi-s2").css("display", "flex");
		});
		/*비밀번호 찾기 페이지 2- 인증번호 확인*/
		$("#btn-pw-next2").on("click", () => {
			$(".div-fi-s2").css("display", "none");
			$(".div-fi-s3").css("display", "flex");
		});
		/*비밀번호 찾기 페이지 3- 비밀번호 변경 확인*/
		$("#btn-pw-next3").on("click", () => {
			//$(".div-fp-s3").css("display", "none");
			$(".div-pw-modal-bg").css("display", "block");
			$(".div-fi-s4").css("display", "flex");
		});
		/*비밀번호 찾기 페이지 4- 로그인페이지로 이동 확인*/
		$("#btn-pw-next4").on("click", () => {
			$(".div-pw-modal-bg").css("display", "none");
			$(".div-fi-s3").css("display", "none");
			$(".div-fi-s4").css("display", "none");
			$(".div-main-lg").css("display", "flex");
		});				

	
/*-----start)div-modal-modal btn---------------- */
		// 가입 진행
		
			
		// 아이디 중복 여부 text
		$("#joinid-yes-no-text").text('');
		// 비밀번호 붕복 여부 text
		$("#joinpwd-yes-no-text").text('');
		// 아이디 중복 확인
		$("#btn-id-dcheck").on("click", () => {
			const id=$("#join-userid").val();
			//this.idregcheck(id) && this.iddcheck(id);
			if(!this.idregcheck(id)) return false;
			let idresult =	this.iddcheck(id);
			console.log(idresult);
		});
		// 중복감사후 변경 체크 
		$("#join-userid").on('input',() => {
			$("#chk").val("N");
		});
				
		$("#btn-modal-cancle").on("click", () => {
			// 모달 창 닫기
			this.userModalDataClean();
			$(".modal-bg").fadeOut(300);
			$("#div-user-modal").fadeOut(300);
			$("#div-telaouth-modal").fadeOut(300);
			$("#div-name-modal").fadeOut(300);
			$("#div-welcome-modal").fadeOut(300);
		});
		
		// 전화번호 인증 전진이동
		$("#btn-next-tel").on("click", () => {
			// 이동전 체크사항 id 붕복 / 비밀번호 일치 / 전화번호 형식
			if( $("#chk").val()==="N" ){// 중복검사
				alert("아이디 중복 검사 하세요");
				return false;
			}
			let reg = /^\w{8,14}$/
			if( !reg.test($("#join-userid").val()) ){
				alert("아이디는 영어대소문자, 숫자, _ 만 허용, 길이는 8~14글자 사이어야 합니다.");
				return false;
			}
			if( $("#join-userpwd").val()=="" || $("#join-userpwd-re").val()==""){// 중복검사
				alert("비밀번로를 입력하세요");
				return false;
			}
			if( $("#join-userpwd").val() != $("#join-userpwd-re").val()){// 중복검사
				alert("비밀번호가 다릅니다.");
				return false;
			}
			reg = /^\d{11}$/;
			const tel = $("#join-usertel").val().trim();
			console.log(tel); // 입력 값 확인
			console.log(tel.length); // 입력 값의 길이 확인

			if(!reg.test(tel)){
				alert("전화번호를 잘못입력했습니다.");
				return false;	
			}
			this.sendOtp(tel);
			// 
			$("#div-user-modal")
				.removeClass("modal-inner-appear")
				.addClass("modal-inner-disappear");

			$("#div-telaouth-modal")
				.css("display", "block")
				.removeClass("modal-inner-disappear")
				.addClass("modal-inner-appear");
		});
/*-----end)div-user-modal btn--------------------- */

/*-----start)div-telaouth-modal btn---------------- */			

		// 전화번호 인증 후진이동
		$("#btn-back-tel").on("click", () => {
			// 서버 인증번호 요청
			
			$("#div-telaouth-modal")			
				.removeClass("modal-inner-appear")
				.addClass("modal-inner-disappear");

				$("#div-user-modal")
				.css("display", "block")
				.removeClass("modal-inner-disappear")
				.addClass("modal-inner-appear");
		});

		// 닉네임 전진이동
		$("#btn-next-name").on("click", () => {
			// 전진 이동정 서버로 인증 번호 전송 및 확인
			console.log($(".joinotp1").val());
			console.log($(".joinotp2").val());
			console.log($(".joinotp3").val());
			console.log($(".joinotp4").val());
			console.log($(".joinotp5").val());
			console.log($(".joinotp6").val());
		
			const otpStr = this.otpSting("joinotp");
			if(otpStr == false && otpStr.length <6) return false;
			this.verifyOtp(otpStr);
					
			
			
			$("#div-telaouth-modal")
				.removeClass("modal-inner-appear")
				.addClass("modal-inner-disappear");

			$("#div-name-modal")
				.css("display", "block")
				.removeClass("modal-inner-disappear")
				.addClass("modal-inner-appear");
		});
/*-----end)div-telaouth-modal btn--------------------- */

/*-----start)div-name-modal btn---------------- */			
		// 이름 인증 후진이동
		$("#btn-back-name").on("click", () => {
			$("#div-name-modal")			
				.removeClass("modal-inner-appear")
				.addClass("modal-inner-disappear");

				$("#div-telaouth-modal")
				.css("display", "block")
				.removeClass("modal-inner-disappear")
				.addClass("modal-inner-appear");
		});
		// 환영 전진이동
		$("#btn-next-welcome").on("click", () => {
			$("#div-name-modal")
				.removeClass("modal-inner-appear")
				.addClass("modal-inner-disappear");

				$("#div-welcome-modal")
				.css("display", "flex")
				.removeClass("modal-inner-disappear")
				.addClass("modal-inner-appear");
		});
/*-----end)div-name-modal btn--------------------- */

/*-----start)div-welcome-modal btn---------------- */	
		$("#div-next-login").on("click", () => {
			// alert("회원가입완료");
			$("#div-welcome-modal")
				.css("display", "none")
				.removeClass("modal-inner-appear")
				.addClass("modal-inner-disappear");
			
			$("#div-user-modal")
			.removeClass("modal-inner-disappear")
			.addClass("modal-inner-appear");

			$(".modal-bg").fadeOut(300);
			$("#div-user-modal").css("display", "none");
			$("#div-telaouth-modal").css("display", "none");
			$("#div-name-modal").css("display", "none");
			$("#div-welcome-modal").css("display", "none");
			
		});
/*-----end)div-telaouth-modal btn--------------------- */

	},
	userModalDataClean:function(){
		// 1. div-user-modal
		// 아이디 중복 여부 text
		$("#joinid-yes-no-text").text('');
		// 비밀번호 붕복 여부 text
		$("#joinpwd-yes-no-text").text('');
		$("#join-userid").val('');
		$("#chk").val('');
		$("#join-userpwd").val('');
		$("#join-userpwd-re").val('');
		$("#join-usertel").val('');
				
	},
	
	idregcheck:function(id){
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
	},

	iddcheck: function(id) {
		console.log("iddcheck check");
		let idcheck ={
			checkid: id
		}
		$.ajax({
			type: "POST",
			url: "/mingle/user/iddcheck",
			data: JSON.stringify(idcheck), // http body 데이터
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
			success: function(result) {
				console.log(result);
				if(result.status==101){ // 인증 성공
					$("#joinid-yes-no-text").text(result.res).removeClass("Yaldevi-SB-20r-A").addClass("Yaldevi-SB-20g-A");
					$("#chk").val("Y");
					return true;	
				}
				if(result.status==102){ // 인증 실패 
					$("#joinid-yes-no-text").text(result.res).removeClass("Yaldevi-SB-20g-A").addClass("Yaldevi-SB-20r-A");
					$("#chk").val("N");
					return true;	
				}
				
			},
			error: function(error) {
				console.log(error);
			}
		})
	},
	sendOtp:function(tel){
		console.log("sendOtp check");
		let otp ={
			phone: tel
		}
		$.ajax({
			type: "POST",
			url: "/mingle/user/send-otp",
			data: JSON.stringify(otp), // http body 데이터
			contentType: "application/json; charset=UTF-8",
		})	
	},
	otpSting:function(joinotp){
 		let otpStrings = '';
    	for (let i = 1; i <= 6; i++) {
        	let position = joinotp + i;
        	otpStrings += $('.' + position).val();
        	console.log("$('.' + position).val(): " + $('.' + position).val());
        	console.log(typeof $('.' + position).val());
    	}
    	console.log("otpStrings: " + otpStrings);
    	return otpStrings;
	},
	getValue: function() {
		return {
			hangle: $("#hangle").val(),
			susu: $("#susu").val(),
			eng: $("#eng").val(),
		};
	},
	verifyOtp:function(otpStr){
		console.log("verifyOtp check");
		let otpStrs ={
			otp: otpStr
		}
		$.ajax({
			type: "POST",
			url: "/mingle/user/verify-otp",
			data: JSON.stringify(otpStrs), // http body 데이터
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
			success: function(result) {
				console.log(result);
				if(result.status==111){ // 사용가능한 아이디
					return true;	
				}
				if(result.status==112){ // 
					return false;	
				}
			},
			error: function(error) {
				console.log(error);
			}
		})
	},
	requestPut: function() {
		console.log("requestPut js 호출");
		let tData = this.getValue();
		$.ajax({
			type: "PUT",
			url: "/mingle/user",
			data: JSON.stringify(tData), // http body 데이터
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
			success: function(r) {
				//console.log("requestPost 리턴 확인");
				console.log(r);
				$("#div-response").text('PUT 요청 리턴값  : '+JSON.stringify(r))
			},
			error: function(error) {
				console.log(error);
			}
		})
	},
	requestDelete: function() {
		console.log("requestDelete js 호출");
		let tData = this.getValue();
		$.ajax({
			type: "DELETE",
			url: "/mingle/user",
			data: JSON.stringify(tData), // http body 데이터
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
			success: function(r) {
				//console.log("requestPost 리턴 확인");
				console.log(r);
				$("#div-response").text('DELETE  요청 리턴값 :  '+JSON.stringify(r))
			},
			error: function(error) {
				console.log(error);
			}
		})
	}
}
index.init();
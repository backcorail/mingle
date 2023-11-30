let index = {
	init: function() {
		$(".div-golo").on('click',()=>{
			// TODO: 이것은 어떻게 실행할지 고민. 중
		})
		// 로그인  
		$("#btn-main-login").on('click',()=>{
			this.login();
			// TODO 로그인 성공후 어디로 이동시킬지 경정해야 함.
		})
			
		// 1) 회원가입 모달 시작
		$(".btn-joinform").on("click", () => {
			/*alert("로그인");*/
			this.userModalDataClean();
			$(".modal-bg").css("display", "block");
			$("#div-user-modal")
				.css("display", "flex");
		});
		// 2) 비밀 번호 찾기 시작
		$(".btn-findpwd").on("click", () => {
			this.pwDataClean();
			$(".div-main-lg").css("display", "none");
			$(".div-fp-s2").css("display", "none");
			$(".div-fp-s3").css("display", "none");
			$(".div-fp-s4").css("display", "none");
			$(".div-fp-s1").css("display", "flex");
		});
		//2-1) 비밀번호 찾기 페이지 1- 전호번호 입력 확인
		$("#btn-pw-next1").on("click", () => {
			// 아이디 있는지 확인 콜백1)
			const id=$("#pw-userid").val();
			if(!this.idregcheck(id)) return false;
			this.pwIdcheck(id);
			// 콜백 3개 중복 			
		});
		/*비밀번호 찾기 페이지 2- 인증번호 확인*/
		$("#btn-pw-next2").on("click", () => {
			
			const otpStr = this.otpSting("pwotp");
			if(otpStr == false && otpStr.length <6) return false;
			this.pwVerifyOtp(otpStr);
			
		});
		/*비밀번호 찾기 페이지 3- 비밀번호 변경 확인*/
		$("#btn-pw-next3").on("click", () => {
			//$(".div-fp-s3").css("display", "none");
			//전화번호 유효성 체크
			if( $("#pw-userpwd").val()=="" || $("#pw-userpwd-re").val()==""){// 
				alert("비밀번로를 입력하세요");
				return false;
			}
			
			// 유효성검증 일단 주석
			// if (!valiPwd($("#pw-userpwd").val())) return false;
			// if (!valiPwd($("#pw-userpwd-re").val())) return false;

			if( $("#pw-userpwd").val() != $("#pw-userpwd-re").val()){// 
				alert("비밀번호가 다릅니다.");
				return false;
			}
			// 서버 비밀번호 업데이트
			this.pwPut($("#pw-userid").val(),$("#pw-userpwd").val())
		});
		/*비밀번호 찾기 페이지 4- 로그인페이지로 이동 확인*/
		$("#btn-pw-next4").on("click", () => {
			$(".div-pw-modal-bg").css("display", "none");
			$(".div-fp-s3").css("display", "none");
			$(".div-fp-s4").css("display", "none");
			$(".div-main-lg").css("display", "flex");
		});
			
////////////////////////////////////////////////////////////////////////				
		//3 아이디 찾기*/
		$(".btn-findid").on("click", () => {
			$(".div-main-lg").css("display", "none");
			$(".div-fi-s2").css("display", "none");
			$(".div-fi-s3").css("display", "none");
			$(".div-fi-s4").css("display", "none");
			$(".div-fi-s1").css("display", "flex");
			this.naverCaptcha();
		});
		//3-1) 아이디 찾기 찾기 페이지 1- 캡차
		$("#btn-id-next1").on("click", () => {
			$(".div-fi-s1").css("display", "none");
			$(".div-fi-s2").css("display", "flex");
		});
		//3-2) 아이디 찾기 페이지 2- 인증번호 확인
		$("#btn-id-next2").on("click", () => {
			$(".div-fi-s2").css("display", "none");
			$(".div-fi-s3").css("display", "flex");
		});
		/*비밀번호 찾기 페이지 3- 비밀번호 변경 확인*/
		$("#btn-id-next3").on("click", () => {
			//$(".div-fp-s3").css("display", "none");
			$(".div-pw-modal-bg").css("display", "block");
			$(".div-fi-s4").css("display", "flex");
		});
		/*비밀번호 찾기 페이지 4- 로그인페이지로 이동 확인*/
		$("#btn-id-next4").on("click", () => {
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
		$("#joinpwd-yes-no-text").css('display','none');
		// 아이디 중복 확인
		$("#btn-id-dcheck").on("click", () => {
			const id=$("#join-userid").val();
			//this.idregcheck(id) && this.iddcheck(id);
			if(!this.idregcheck(id)) return false;
			this.iddcheck(id);
		});
		// 중복감사후 변경 체크 
		$("#join-userid").on('input',() => {
			$("#idchk").val("N");
			$("#joinid-yes-no-text").text('');
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
		
		// 비밀번호 입력 이벤트
		$("#join-userpwd").on('input',() => {
			$("#joinpwd-yes-no-text").css("display", "none");
		});
		$("#join-userpwd-re").on('input',() => {
			$("#joinpwd-yes-no-text").css("display", "none");
		});
	
		//otp 이벤트	
		$(".otp1").on({	focus: function() {$(this).val(''); }, input: function() {	if(this.value.length === 1) { $(this).next('.otp2').focus(); }}	});
		$(".otp2").on({	focus: function() {$(this).val(''); }, input: function() {	if(this.value.length === 1) { $(this).next('.otp3').focus(); }}	});
		$(".otp3").on({	focus: function() {$(this).val(''); }, input: function() {	if(this.value.length === 1) { $(this).next('.otp4').focus(); }}	});
		$(".otp4").on({	focus: function() {$(this).val(''); }, input: function() {	if(this.value.length === 1) { $(this).next('.otp5').focus(); }}	});
		$(".otp5").on({	focus: function() {$(this).val(''); }, input: function() {	if(this.value.length === 1) { $(this).next('.otp6').focus(); }}	});
		$(".otp6").on({	focus: function() {$(this).val(''); } });	
	
		
		
		
		// 전화번호 인증 전진이동
		$("#btn-next-tel").on("click", () => {
			// 이동전 체크사항 id 붕복 / 비밀번호 일치 / 전화번호 형식
			if( $("#idchk").val()==="N" ){// 중복검사
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
			// 유효성검증 일단 주석
			// if (!valiPwd($("#join-userpwd").val())) return false;
			// if (!valiPwd($("#join-userpwd-re").val())) return false;
			if( $("#join-userpwd").val() != $("#join-userpwd-re").val()){// 중복검사
				$("#joinpwd-yes-no-text").css("display", "block");
				//alert("비밀번호가 다릅니다.");
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
			// 전화 번호 중복 체크를 해야 하네 .
			this.idTelcheck(tel)
			
			
		});
/*-----end) 2) div-user-modal btn--------------------- */

/*-----start) 3) div-telaouth-modal btn---------------- */			

		// 전화번호 인증 후진이동
		$("#btn-back-tel").on("click", () => {
			// 서버 인증번호 요청
			$("#joinotp-no-text").css('display','none');
			this.otpClear();
			
			$("#div-telaouth-modal")			
				.removeClass("modal-inner-appear")
				.addClass("modal-inner-disappear");

				$("#div-user-modal")
				.css("display", "flex")
				.removeClass("modal-inner-disappear")
				.addClass("modal-inner-appear");
		});

		// 닉네임 전진이동
		$("#btn-next-name").on("click", () => {
			// 전진 이동정 서버로 인증 번호 전송 및 확인
		
			const otpStr = this.otpSting("joinotp");
			if(otpStr == false && otpStr.length <6) return false;
			this.verifyOtp(otpStr);
			
		});
/*-----end) 2)div-telaouth-modal btn--------------------- */

/*-----start) 3) div-name-modal btn---------------- */
		$("#join-usernick").on('input',() => {
			$("#nickchk").val("N");
		});
				
		$("#btn-nick-dcheck").on('click',()=>{
			const nick=$("#join-usernick").val();
			if(!this.nickregcheck(nick)) return false;
			let nickresult =	this.nickdcheck(nick);
			console.log(nickresult);
		})
		
		// 이름 인증 후진이동
		$("#btn-back-name").on("click", () => {
			// 인증번호 모달로 이동
			$("#joinotp-no-text").css('display','none');
			this.otpClear();
			const tel = $("#join-usertel").val().trim();
			this.sendOtp(tel);
			
			$("#div-name-modal")			
				.removeClass("modal-inner-appear")
				.addClass("modal-inner-disappear");

			$("#div-telaouth-modal")
				.css("display", "flex")
				.removeClass("modal-inner-disappear")
				.addClass("modal-inner-appear");
		});
		
		// 환영 전진이동
		$("#btn-next-welcome").on("click", () => {
			if( $("#nickchk").val()==="N" ){// 중복검사
				alert("아이디 중복 검사 하세요");
				return false;
			}
			this.userPost();
			// 회원가입 request
			
/*			$("#div-name-modal")
				.removeClass("modal-inner-appear")
				.addClass("modal-inner-disappear");

			$("#div-welcome-modal")
				.css("display", "flex")
				.removeClass("modal-inner-disappear")
				.addClass("modal-inner-appear");*/
		});
/*-----end) 3) div-name-modal btn--------------------- */

/*-----start) 4) div-welcome-modal btn---------------- */	
		$("#div-next-login").on("click", () => {
			// alert("회원가입완료");
			this.userModalDataClean();
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
	initOtp(){
			
	},
	userModalDataClean:function(){
		// 1. div-user-modal
		// 아이디 중복 여부 text
		$("#joinid-yes-no-text").text('');
		// 비밀번호 붕복 여부 text
		$("#joinpwd-yes-no-text").css('display','none');
		$("#join-userid").val('');
		$("#idchk").val('');
		$("#nickchk").val('');
		$("#join-userpwd").val('');
		$("#join-userpwd-re").val('');
		$("#join-usertel").val('');
		$("#joinotp-no-text").css('display','none');
		this.otpClear();
				
	},
	pwDataClean:function(){
		$("#pw-userid").val('');
		$("#pw-usertel").val('');
		$("#pw-userpwd").val('');
		$("#pw-userpwd-re").val('');
		this.otpClear();
		$("#pwotp-no-text").css('display','none');
		$("#pw-dno-text").css('display','none');
		
	}
	,
	
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
				if(result.status==101){ // 인증 성공
					$("#joinid-yes-no-text").text(result.res).removeClass("Yaldevi-SB-20r-A").addClass("Yaldevi-SB-20g-A");
					$("#idchk").val("Y");
					return true;	
				}
				if(result.status==102){ // 인증 실패 
					$("#joinid-yes-no-text").text(result.res).removeClass("Yaldevi-SB-20g-A").addClass("Yaldevi-SB-20r-A");
					$("#idchk").val("N");
					return true;	
				}
				
			},
			error: function(error) {
				console.log(error);
			}
		})
	},
	pwIdcheck: function(id) {
		console.log("pwIdcheck check");
		let idcheck ={
			data: id
		}
		let _this=this;
		$.ajax({
			type: "POST",
			url: "/mingle/user/iddcheck",
			data: JSON.stringify(idcheck), // http body 데이터
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
			success: function(result) {
				console.log(result);
				if(result.status==101){ // 아이디 없음
					alert("없는 아이디 입니다.");
					return true;	
				}
				if(result.status==102){ // 아이디 있음
					// alert("아이디가 존재합니다.");
					//전화번호 있는지 확인 콜백2)
					const reg = /^\d{11}$/;
					const tel = $("#pw-usertel").val().trim();
					if(!reg.test(tel)){
						alert("전화번호를 잘못입력했습니다.");
						return true;	
					}
					_this.pwIdTelcheck(id, tel);
					return true;	
				}
				
			},
			error: function(error) {
				console.log(error);
			}
		})
	},
	valiPwd: function (pwd) {
	
		if (pwd.length > 20) {
        alert("비밀번호는 최대 20자까지만 허용됩니다.");
        return false;
   		 }
	    // 영어 알파벳이 포함되어 있는지 체크
	    const reg = /[A-Za-z]/;
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
	    regl = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/;
	    if (!reg.test(pwd)) {
	        alert("비밀번호에는 특수문자가 적어도 하나 포함되어야 합니다.");
	        return false;
	    }
	    // 모든 조건을 만족
	    return true;
	},
	idTelcheck: function(tel) {
		console.log("idTelcheck check");
		let _this=this;
		let idcheck ={
			data: tel
		}
		$.ajax({
			type: "POST",
			url: "/mingle/user/telcheck",
			data: JSON.stringify(idcheck), // http body 데이터
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
			success: function(result) {
				console.log(result);
				if(result.status==161){ // 등록되지 않은 전화번호
					alert("등록되지 않는 번호입니다.");
					// otp 진행 
					_this.sendOtp(tel);
					// 
					$("#div-user-modal")
						.removeClass("modal-inner-appear")
						.addClass("modal-inner-disappear");
		
					$("#div-telaouth-modal")
						.css("display", "flex")
						.removeClass("modal-inner-disappear")
						.addClass("modal-inner-appear");
					
					$("#joinotp-no-text").css('display','none');
					$(".joinotp1").focus();
					//
					return true;
				}
				if(result.status==162){ // 등록된 전화번호
					alert("이미 등록되어 있는 번호입니다.");
					return false;	
				}
				
			},
			error: function(error) {
				console.log(error);
			}
		})
	},
	pwIdTelcheck: function(id,tel) {
		console.log("telcheck check");
		let _this=this;
		let idcheck ={
			userid: id,
			usertel: tel
		}
		$.ajax({
			type: "POST",
			url: "/mingle/user/idTelcheck",
			data: JSON.stringify(idcheck), // http body 데이터
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
			success: function(result) {
				console.log(result);
				if(result.status==151){ // 사용자가 등록한 전화번호 불일치
					alert("등록된 전화번호와 일치 하지 알습니다.");
					return false;
				}
				if(result.status==152){ // 사용자가 등록한 전화번호와 일치
					// 전화번호 otp 요청 콜백3)
					_this.sendOtp(tel)
					// 화면 갱신 콜백4)
					alert("사용자가 등록한 전화번호와 일치.");
					$(".div-fp-s1").css("display", "none");
					$(".div-fp-s2").css("display", "flex");
					$(".pwotp1").focus();
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
	otpClear:function(){
		console.log("otpClear");
		for (let i = 1; i <= 6; i++) {
        	//let position = 'joinotp' + i;
        	let position = 'otp' + i;
        	$('.' + position).val('');
    	}
	}
	,
	otpSting:function(joinotp){
		console.log("otpSting 함수 전달받은 인자"+joinotp);
		console.log(typeof joinotp);
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
	verifyOtp:function(otpStr){
		console.log("verifyOtp check");
		let otpStrs ={
			data: otpStr
		}
		$.ajax({
			type: "POST",
			url: "/mingle/user/verify-otp",
			data: JSON.stringify(otpStrs), // http body 데이터
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
			success: function(result) {
				console.log(result);
				if(result.status==111){ //
					$("#div-telaouth-modal")
						.removeClass("modal-inner-appear")
						.addClass("modal-inner-disappear");
		
					$("#div-name-modal")
						.css("display", "flex")
						.removeClass("modal-inner-disappear")
						.addClass("modal-inner-appear");
							return true;	
				}
				if(result.status==112){ // 
					//alert("입력하신 인증번호가 일치하지 않습니다.");
					$("#joinotp-no-text").css('display','block');
				}
			},
			error: function(error) {
				console.log(error);
			}
		})
	},
	pwVerifyOtp:function(otpStr){
		console.log("pwVerifyOtp check");
		let _this=this;
		let otpStrs ={
			data: otpStr
		}
		$.ajax({
			type: "POST",
			url: "/mingle/user/verify-otp",
			data: JSON.stringify(otpStrs), // http body 데이터
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
			success: function(result) {
				console.log(result);
				if(result.status==111){ //
					$("#pwotp-no-text").css('display','none');
					_this.otpClear();
					$(".div-fp-s2").css("display", "none");
					$(".div-fp-s3").css("display", "flex");
					return true;	
				}
				if(result.status==112){ // 
					alert("입력하신 인증번호가 일치하지 않습니다.");
					$("#pwotp-no-text").css('display','block');
				}
			},	error: function(error) { console.log(error);	}
		})
	},
	nickregcheck:function(nick){
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
	},
	nickdcheck: function(id) {
		console.log("nickdcheck check");
		let nickcheck ={
			data: id
		}
		$.ajax({
			type: "POST",
			url: "/mingle/user/nickdcheck",
			data: JSON.stringify(nickcheck), // http body 데이터
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
			success: function(result) {
				console.log(result);
				if(result.status==121){ // 닉네임 성공
					alert("사용 가능 닉네임 입니다.");
					$("#nickchk").val("Y");
					return true;	
				}
				if(result.status==122){ // 닉네임 인증 실패 
					alert("닉네임 중복");
					return true;	
				}
				
			},
			error: function(error) {
				console.log(error);
			}
		})
	},
	getValue: function() {
		return {
			userid : $("#join-userid").val(),
			userpwd : $("#join-userpwd").val(),
			usertel : $("#join-usertel").val(),
			usernick : $("#join-usernick").val()
		};
	},
	pwPut: function(id,pwd){
		console.log("pwPut check");
		let _this=this;
		let idpwd ={
			userid: id,
			userpwd: pwd
		}
		console.log(idpwd);
		$.ajax({
			type: "PUT",
			url: "/mingle/user/idpwd",
			data: JSON.stringify(idpwd), // http body 데이터
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
			success: function(result) {
				console.log(result);
				if(result.status==171){ // 사용자가 비밀번호 변경 성공
					alert("비밀변호 변경 성공");
					$(".div-pw-modal-bg").css("display", "block");
					$(".div-fp-s4").css("display", "flex");
					return false;
				}
				if(result.status==172){ // 사용자가 비밀전호 변경 실패
					alert("비밀변호 변경 실패");
					return true;	
				}	
			},
			error: function(error) {
				console.log(error);
			}
		})
	},
	userPost: function() {
		console.log("userPost  호출");
		const userData = this.getValue();
		console.log(userData);
		$.ajax({
			type: "POST",
			url: "/mingle/user",
			data: JSON.stringify(userData), // http body 데이터
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
			success: function(result) {
				//console.log("requestPost 리턴 확인");
				console.log(result);
				if(result.status==131){ // 가입 성공
					$("#div-name-modal")
						.removeClass("modal-inner-appear")
						.addClass("modal-inner-disappear");

					$("#div-welcome-modal")
						.css("display", "flex")
						.removeClass("modal-inner-disappear")
						.addClass("modal-inner-appear");
					return true;	
				}
				if(result.status==132){ // 가입 실패 
					return true;	
				}
			},
			error: function(error) {
				console.log(error);
			}
		})
	},
	//시큐리티 이전 로그인 방식.
	login: function() {
		console.log("login js 호출");
		let data = {
			userid: $("#userid").val(),
			userpwd: $("#userpwd").val()
		};
		$.ajax({
			type: "POST",
			url: "/mingle/user/login",
			data: JSON.stringify(data), // http body 데이터 
			contentType: "application/json; charset=UTF-8",//body에 실어 보내는 데이터가 어떤 타입인지(MIME)
			dataType:"json",
			success: function(result) {
				if(result.status==141){ // 로그인 성공
					location.href="http://localhost:9998/mingle/"
					return true;	
				}
				if(result.status==142){ // 로그인 실패 
					alert("아이디와 비밀번호를 확인해주세요.")
					return true;	
				}
			},
			error: function(error) {
				console.log(error);
			}	
		})
	},
	naverCaptcha:function(){
		console.log("naverCaptcha js 호출");
		$.ajax({
			type: "GET",
			url: "/mingle/user/captcha",
			success: function(result) {
				console.log(result);
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
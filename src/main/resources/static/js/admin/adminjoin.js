let index = {
	init: function() {
		// 로그인  
		$("#btn-admin-login").on('click',()=>{
			//this.login();
			this.adminloginproc();
			// TODO 로그인 성공후 어디로 이동시킬지 경정해야 함.
		})				
	},
	adminloginproc: function() {
		console.log("adminloginproc js 호출");
		const _this=this;
		
		let loginprocData = {
			adminid: $("#adminid").val(),
			adminpwd: $("#adminpwd").val()
		};
		console.log(loginprocData);
		$.ajax({
			type: "POST",
			url: "/mingle//myadmin/loginproc",
			data: loginprocData, // http body 데이터
			dataType:"json",
			success: function(result) {
				console.log(result);
				if(result.status==141){ // 로그인 성공
					console.log("로그인 성공");
					location.reload(true);
					location.href="http://localhost:9998/mingle/"
					return true;	
				}
				if(result.status==101){ // 아이디 없음 
					alert(result.res);
					console.log("아이디가 업습니다. ");
					return true;	
				}
				if(result.status==192){ // 비밀번호 불일치 
					alert(result.res);
					console.log("비밀번호가 다릅니다.");
					return true;	
				}
				if(result.status==143){ // 캡차 로그인 페이지로이동 
					alert(result.res);
					console.log("143 로그인 실패 ");
					_this.captchaLoginPage();
					return true;	
				}
			},
			error: function(error) {
				console.log(error);
			}	
		})
	},
}
index.init();
let index = {
	init: function() {
		$("#btn-get").on("click", () => {
			this.requestGet();
		});
		$("#btn-post").on("click", () => {
			this.requestPost();
		});		
		
		$("#btn-put").on("click", () => {
			this.requestPut();
		});
		
		$("#btn-delete").on("click", () => {
			this.requestDelete();
		});
	},
	getValue: function() {
		return {
			hangle: $("#hangle").val(),
			susu: $("#susu").val(),
			eng: $("#eng").val(),
		};
	},
	requestGet: function() {
		console.log("requestGet js 호출");
		let tData = this.getValue();
		$.ajax({
			type: "GET",
			url: "/user",
			data: tData, // 제이쿼리가 키-밸류값으로 변경해준다.
			success: function(r) {
				//console.log("requestGet 리턴 확인");
				console.log(r);
				$("#div-response").text('GET 요청 리턴값 : '+JSON.stringify(r))
			},
			error: function(e) {
				alert(e);
			}
		})
	},
	requestPost: function() {
		console.log("requestPost js 호출");
		let tData = this.getValue();
		$.ajax({
			type: "POST",
			url: "/user",
			data: JSON.stringify(tData), // http body 데이터
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
			success: function(r) {
				//console.log("requestPost 리턴 확인");
				console.log(r);
				$("#div-response").text('POST 요청 리턴값 : '+JSON.stringify(r))
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
			url: "/user",
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
			url: "/user",
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
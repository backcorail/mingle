$(document).ready(function() {
	var url = window.location.search;
	var urlParams = new URLSearchParams(url);
	var tabs = urlParams.get("tabs");
	switch(tabs) {
		case "1" :
		 	$.get("style/ranking", function(d) {
				const data = $(d).find(".all_select");
				$("#tabs").html(data);
			});
			break;
		case "2" :
			$.get("style/styles", function(d) {
				const data = $(d).find(".all_select");
				$("#tabs").html(data);
			});
			break;
		case "3" :
			$.get("style/trend", function(d) {
				const data = $(d).find(".all_select");
				$("#tabs").html(data);
			});
			break;
		default :
	}
	
	if(!tabs) {tabs = 1};
	$.ajax({
		type:"GET",
		url:"style",
		data:{tabs:tabs}
	});
});


$(document).ready(function() {
	$("body").on('click', '.img', function() {
		console.log("in");
        window.location.href = "/mingle/style/trend/info";
    });
});


// 좋아요 기능
$('#heart-Btn').click(function() {
    $.ajax({
        url: 'http://localhost:9998/mingle/style?tabs=2', // '좋아요'를 업데이트할 서버의 URL
        type: 'POST', // HTTP 메소드
        data: { 
            like: 1 // 예를 들어 '좋아요'를 1 증가시키는 요청을 보냅니다
        }, 
        success: function(response) {
            // 요청이 성공적으로 이루어졌을 때 '좋아요'의 수를 업데이트합니다
            // 'response'는 서버에서 보내준 응답 데이터입니다
            // 이 예제에서는 'response'가 새로운 '좋아요'의 수라고 가정합니다
            $('#style_likes_check').text(response);
            console.log("asd");
        },
        error: function(jqXHR, textStatus, errorThrown) {
            // 요청이 실패했을 때 오류를 출력합니다
            console.log(textStatus, errorThrown);
        }
    });
});
// 스크롤
window.onscroll = function() {
	var hiddenDivs = document.getElementsByClassName('board_items_hidden');
	for (var i = 0; i < hiddenDivs.length; i++) {
		if (hiddenDivs[i].getBoundingClientRect().top <= window.innerHeight) {
			hiddenDivs[i].style.opacity = "1";
		}
	}
};

// info 이동
$(document).ready(function() {
    $(".board_items").click(function() {
        window.location.href = "http://localhost:9998/mingle/style/trend/info";
    });
});

// 좋아요 기능
$('#like-button').click(function() {
    $.ajax({
        url: '/mingle/style/styles', // '좋아요'를 업데이트할 서버의 URL
        type: 'POST', // HTTP 메소드
        data: { 
            like: 1 // 예를 들어 '좋아요'를 1 증가시키는 요청을 보냅니다
        }, 
        success: function(response) {
            // 요청이 성공적으로 이루어졌을 때 '좋아요'의 수를 업데이트합니다
            // 'response'는 서버에서 보내준 응답 데이터입니다
            // 이 예제에서는 'response'가 새로운 '좋아요'의 수라고 가정합니다
            $('#like-count').text(response);
            console.log("asd");
        },
        error: function(jqXHR, textStatus, errorThrown) {
            // 요청이 실패했을 때 오류를 출력합니다
            console.log(textStatus, errorThrown);
        }
    });
});
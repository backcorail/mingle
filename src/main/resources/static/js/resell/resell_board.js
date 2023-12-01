
$(document).ready(function() {
	/* 최상단 카테고리 선택 */
	$(".choose").click(function() {
        $(".choose").removeClass("active");
        $(this).addClass("active");
    });
    
	$("#clothes_click1>img").addClass("opacity");
	
	$(".clothes_click>img").click(function() {
		var data = $(this)[0].currentSrc;
		// 작은 사진이 커지는 애니메이션
		$(".main_img").fadeOut(100, function() {
			// 이미지 변경 후 페이드 인
			$(".main_img").attr("src", data).fadeIn(200);
		});
		$(".clothes_click>img").removeClass("opacity");
		$(this).addClass("opacity");
	});
	
	$(".clothes_click>img").hover(
		function() { // 마우스 오버 시
			$(this).css("box-shadow", "0 0 10px gray"); // 그림자 효과 추가
		},
		function() { // 마우스 아웃 시
			$(this).css("box-shadow", "none"); // 그림자 효과 제거
		}
	);
	
	$(".buy_button>button").hover(
		function() { // 마우스 오버 시
			$(this).css("color", "blue"); // 그림자 효과 추가
		},
		function() { // 마우스 아웃 시
			$(this).css("color", "white"); // 그림자 효과 제거
		}
	);
	
	$(".buy_button").click({
		
	})
});

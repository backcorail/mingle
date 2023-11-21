	// 더보기 관리
	$(".moreview").click(function() {
		
		if($(this).text() === "더보기") {
			$(this).text("접기");
		}
		else if($(this).text() === "접기") {
			$(this).text("더보기");
		}
	});
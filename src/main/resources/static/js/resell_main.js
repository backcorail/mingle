
$(document).ready(function() {
	// 하위 카테고리 숨기기
	$("#category1").hide();
	$("#category2").hide();
	$("#category3").hide();
	
	//변수 선언 - 탭메뉴 버튼
	const btn1 = document.getElementById("moreView1");
	const btn2 = document.getElementById("moreView2");
	const btn3 = document.getElementById("moreView3");
	
	// 각각의 탭 종류 클릭시 보여주기/닫기
	$("#moreView1").click(function() {
		$("#category1").slideToggle(300);
		btn1.style.transition = "transform 0.3s linear"
		btn1.style.transform += "rotate(45deg)";
		
	});
	$("#moreView2").click(function() {
		$("#category2").slideToggle(300);
		btn2.style.transition = "transform 0.3s linear"
		btn2.style.transform += "rotate(45deg)";
	});
	$("#moreView3").click(function() {
		$("#category3").slideToggle(300);
		btn3.style.transition = "transform 0.3s linear"
		btn3.style.transform += "rotate(45deg)";
	});
	
	$(".choose").click(function() {
        $(".choose").removeClass("active");
        $(this).addClass("active");
    });
    
    // 검색창 애니메이션
    $(".resell_search>img").click(function() {
		var width_change = parseInt($("#search_bar").css("width"), 10);
		if(width_change == 38) {
			$("#search_bar").css("width","495px");
			$("#search_bar").css("color","black");
			$("#search_bar").prop("placeholder", "여기에 검색어 입력.");
			$("#search_bar").css("padding","0px 10px 0px 36px");
		} else {
			$("#search_bar").css("width","38px");
			$("#search_bar").css("color","white");
			$("#search_bar").prop("placeholder", "");
			$("#search_bar").css("padding","0px");
		}
    });
});

$(document).ready(function() {
    $('.list_box .recell_time').each(function() {
        var now = new Date();
        var dateTime = now.toISOString().slice(0, 19).replace("T", " ");
        $(this).text(dateTime);
    });
});


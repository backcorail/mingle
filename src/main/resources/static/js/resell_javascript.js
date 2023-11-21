/*
$(document).click(function() {
	anime({
    	targets:".test",
    	translateX: 250
	});
	$(".test2").css("transform",'translateX(250px)');
	//$(".category1").css("transform",'translateY(250px)');
});
*/


$(document).ready(function() {
	// 하위 카테고리 숨기기
	$("#category1").hide();
	$("#category2").hide();
	$("#category3").hide();
	
	
	
	// 각각의 탭 종류 클릭시 보여주기/닫기
	$("#moreView1").click(function() {
		$("#category1").slideToggle(200);
	});
	$("#moreView2").click(function() {
		$("#category2").slideToggle(200);
	});
	$("#moreView3").click(function() {
		$("#category3").slideToggle(200);
	});
	
	$(".choose").click(function() {
        $(".choose").removeClass("active");
        $(this).addClass("active");
    });
});

$(document).ready(function() {
    $('.list_box .recell_time').each(function() {
        var now = new Date();
        var dateTime = now.toISOString().slice(0, 19).replace("T", " ");
        $(this).text("날짜 : "+dateTime);
    });
});
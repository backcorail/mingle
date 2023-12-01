
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
		if(width_change <= 38) {
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

function timeDiff(time) {
	time = new Date(time);
	var currentTime = new Date();
	var diff = Math.floor((currentTime - time)/60000);
	
	if(diff<1) {
		return "방금전";
	} else if(diff < 60) {
		return diff+"분전";
	} else if(diff < 1440) {
		return Math.floor(diff/60)+"시간전";
	} else if(diff < 10080) {
		return Math.floor(diff/1440)+"일전";
	} else if(diff < 43200) {
		return Math.floor(diff/10080)+"주전";
	} else if(diff < 525600) {
		return Math.floor(diff/43200)+"달전";
	} else {
		return ""
	}
}

$(document).ready(function() {
	// 현재 페이지 URL 가져오기
	var url = window.location.search;
	var urlParams = new URLSearchParams(url);
	var nowPage = urlParams.get("page"); 
	if(!nowPage) { nowPage = 1; }
	
	$.ajax({
		type : "GET",
		url : "resell?page="+nowPage,
		data : { 
			page:nowPage
		},
		success : function(data) {
			
		},
		error : function(error) {
			console.log(error);
		}
	})
});


$(document).ready(function() {
	$(".page_now").parent().css("background","#FFC107");
	$(".page_box").parent().hover(
		function() {
			$(this).css("background","#FFC107");
		},
		function() {
			$(this).css("background","");
		}
	);
});

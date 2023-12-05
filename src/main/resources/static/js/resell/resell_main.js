// 각종 스타일 변경
$(document).ready(function() {
	
	// 각각의 탭 종류 클릭시 보여주기/닫기
	$(".moreView").click(function() {
		$(this).parent().next().slideToggle(300);
		var rad = $(this).data("rotation") || 0;
		var newRad = rad + 45;
		$(this).data("rotation",newRad);
		$(this).css("transform","rotate("+newRad+"deg)");
	});
	
	// 상단탭 클릭시 효과
	$(".category_type").click(function() {
		$(".category_type").removeClass("active");
		$(this).addClass("active");
	});
	
	// 검색바 값 여부에 따른 애니메이션 초기 속성 조정
	if($("#search_bar").val() != "") {
		console.log("값이 있음");
		$("#search_bar").css({
			"width":"495px",
			"color":"black",
			"padding":"0px 10px 0px 36px",
		});
		$("#search_magnifier").css("transform","translateX(457px)");
		$("#search_slide").css("transform","rotate(180deg)");
	}
	
    // 검색창 애니메이션
    $("#search_slide").click(function() {
		$("#search_bar").css("transition","width 0.3s ease-in-out");
		$("#search_magnifier").css("transition","transform 0.3s ease-in-out");
		$("#search_slide").css("transition","transform 0.3s ease-in-out");
		var width_change = parseInt($("#search_bar").css("width"), 10);
		var rad = $(this).data("rotation") || 0 || 180;
		var newRad = rad + 180;
		$(this).data("rotation",newRad);
		if(width_change <= 38) {
			$("#search_magnifier").css("transform","translateX(457px)");
			$("#search_bar").css("width","495px");
			$("#search_bar").css("color","black");
			$("#search_bar").prop("placeholder", "여기에 검색어 입력.");
			$("#search_bar").css("padding","0px 10px 0px 36px");
		} else {
			$("#search_magnifier").css("transform","translateX(0px)");
			$("#search_bar").css("width","38px");
			$("#search_bar").css("color","white");
			$("#search_bar").prop("placeholder", "");
			$("#search_bar").css("padding","0px");
		}
		$(this).css("transform","rotate("+newRad+"deg)");
    });
    
    $("#search_magnifier").click(function() {
		$(".resell_search form").submit();
	});
});

// 시간 계산 함수
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



// 검색 관련 함수
function search() {
	var url = window.location.search;
	var urlParams = new URLSearchParams(url);
	var nowSearch = urlParams.get("search");
	var nowPage = urlParams.get("page");
	var searchValue = $("#search_bar").val();
	var searchUrl = window.location.origin + window.location.pathname;
	if(searchValue == "") { // 값이 없을시
		alert("검색어를 입력해주세요.");
	} 
	else { // 값이 있을시
		if(!nowPage) {nowPage = 1; console.log("페이지 확인");}
		if(!nowSearch) {nowSearch = searchValue; console.log("검색어 확인");}
		searchUrl += "?page=1&search="+searchValue;
		window.location.href = searchUrl;
	}
	$.ajax({
		type : "GET",
		url : "resell?page="+nowPage+"&search="+searchValue,
		data : {search:searchValue},
	});
	return false;
}



// URL 변수 받기
$(document).ready(function() {
	// 현재 페이지 URL 가져오기
	var url = window.location.search;
	var urlParams = new URLSearchParams(url);
	var nowPage = urlParams.get("page"); 
	var searchValue = urlParams.get("search");
	if(!nowPage) { nowPage = 1; };
	if(!searchValue) {searchValue = ""};
	$.ajax({
		type : "GET",
		url : "resell?page="+nowPage+"&search="+searchValue,
		data : {page:nowPage},
	});
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

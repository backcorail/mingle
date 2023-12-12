
$(document).ready(function() {
	// ===========================================================
	// -----< 공통 변수 지정 >-----
	
	var url = window.location.origin + window.location.pathname;
	var params = window.location.search;
	var urlParams = new URLSearchParams(params);
	var page = urlParams.get("page");
	var search = urlParams.get("search");
	var category = urlParams.get("category");
	var detail = urlParams.get("detail");
	var sort = urlParams.get("sort");
	
	// -----< 공통 변수 지정 >-----
	// ===========================================================
	// -----< 상단 카테고리 부분 >-----

	// 상단 카테고리 초기값 애니메이션 지정
	$(".category_type").removeClass("select");
	if(!category) {$(".All").addClass("select")}
	if(category == 1) {$(".Men").addClass("select")}
	if(category == 2) {$(".Women").addClass("select")}
	if(category == 3) {$(".Other").addClass("select")}
	url = window.location.origin+"/mingle/resell";
	// 상단 카테고리 부분
	$(".category_type").click(function() {
		// 클릭 효과
		$(".category_type").removeClass("select");
		$(this).addClass("select");
		// 데이터 보내기
		var categoryNum = $(this).attr("id");
		if(categoryNum == 3) {
			URLData(url+"?", 1, null, categoryNum, 0, null);
		} else {
			URLData(url+"?", 1, null, categoryNum, null, null);
		}
	});
	
	// -----< 상단 카테고리 부분 >-----
	// ===========================================================
	// -----< 중간 게시글 부분 >-----
	
	// 메인 옷 선택 애니메이션
	$("#clothes_click0 > img").addClass("opacity");
	$(".clothes_click > img").click(function() {
		var data = $(this)[0].currentSrc;
		// 작은 사진이 커지는 애니메이션
		$(".main_img").fadeOut(100, function() {
			// 이미지 변경 후 페이드 인
			$(".main_img").attr("src", data).fadeIn(200);
		});
		$(".clothes_click>img").removeClass("opacity");
		$(this).addClass("opacity");
	});
	// 왼쪽 작은 사진 효과
	$(".clothes_click > img").hover(
		function() {$(this).css("box-shadow", "0 0 10px gray");},
		function() {$(this).css("box-shadow", "none");}
	);
	
	// 목록으로 돌아가기
	$(".board_list").click(function() {
		url = window.location.origin+"/mingle/resell";
		URLData(url+"?", 0, null, null, null, null, null);
	});
	// 게시글 수정하기
	$(".board_update").click(function() {
		url = window.location.origin+"/mingle/resell/write";
		URLData(url+"?", null, 0, "", 0, 0, "");
	});
	// 게시글 삭제하기
	$(".board_delete").click(function() {
		
	});
	
	
	// 구매 요청 버튼 효과
	$(".buy_button > button").hover(
		function() {$(this).css("color", "blue");},
		function() {$(this).css("color", "white");}
	);
	
	$(".buy_button").click({
		
	})
});



// ===========================================================

// 비동기식(ajax) 데이터 보내기 및 데이터 판별
function URLData(url, no, page, search, category, detail, sort) {
	// 작성 틀 : URLData(url, null, null, null, null, null, null);
	// 값 제거 : URLData(url, 0, 0, "", 0, 0, "");
	// null값을 넣으면 기존의 주소 유지, 초기값을 넣으면 제거

	// 필요한 변수 및 데이터
	var params = window.location.search;
	var urlParams = new URLSearchParams(params);
	var newURL = url;
	var count = 0;
	
	// 입력한 값이 있는지 판정(없으면 우선 주소창값으로 변경)
	if(no == null) {no = urlParams.get("no")}
	if(page == null) {page = urlParams.get("page")}
	if(search == null) {search = urlParams.get("search")}
	if(category == null) {category = urlParams.get("category")}
	if(detail == null) {detail = urlParams.get("detail")}
	if(sort == null) {sort = urlParams.get("sort")}
	
	// 변경할 URL주소 만들기
	if(no) {
		if(count>=1) {newURL += "&"}
		newURL += "no="+no;
		count++;
	}
	if(page) {
		if(count>=1) {newURL += "&"}
		newURL += "page="+page;
		count++;
	}
	if(search) {
		if(count>=1) {newURL += "&"}
		newURL += "search="+search;
		count++;
	}
	if(category && category != 0) {
		if(count>=1) {newURL += "&"}
		newURL += "category="+category;
		count++;
	}
	if(detail) {
		if(count>=1) {newURL += "&"}
		newURL += "detail="+detail;
		count++;
	}
	if(sort && sort != "latest") {
		if(count>=1) {newURL += "&"}
		newURL += "sort="+sort;
		count++;
	}

	// 새로만든 주소 적용하기
	window.location.href = newURL;
	
	// search부분이 컨트롤러에서는 배열로 받지만, 여기서는 값을
	// 쉼표로 구분해서 하나의 문자열로 보내는데, 컨트롤러에서 
	// 자동으로 배열로 넣어준다고 함.
	
	return false;
}

// ===========================================================


$(document).ready(function() {
	/* 최상단 카테고리 선택 */
	
	// ===========================================================
	// -----< 상단 카테고리 부분 >-----

	// 상단 카테고리 초기값 애니메이션 지정
	$(".category_type").removeClass("select");
	if(!category) {$(".All").addClass("select")}
	if(category == 1) {$(".Men").addClass("select")}
	if(category == 2) {$(".Women").addClass("select")}
	if(category == 3) {$(".Other").addClass("select")}
	// 상단 카테고리 부분
	$(".category_type").click(function() {
		// 클릭 효과
		$(".category_type").removeClass("select");
		$(this).addClass("select");
		// 데이터 보내기
		var categoryNum = $(this).attr("id");
		if(categoryNum == 3) {
			URLData(url+"?", null, null, categoryNum, 0, null);
		} else {
			URLData(url+"?", null, null, categoryNum, null, null);
		}
	});
	
	// -----< 상단 카테고리 부분 >-----
	// ===========================================================
	
	
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



// ===========================================================

// 비동기식(ajax) 데이터 보내기 및 데이터 판별
function URLData(url, page, search, category, detail, sort) {
	// 작성 틀 : URLData(url, null, null, null, null, null);
	// 초기 값 : URLData(url, 1, "", 1, 0, "latest";)

	// 필요한 변수 및 데이터
	var params = window.location.search;
	var urlParams = new URLSearchParams(params);
	var newURL = url;
	var count = 0;
	
	// 입력한 값이 있는지 판정(없으면 우선 주소창값으로 변경)
	if(page == null) {page = urlParams.get("page")}
	if(search == null) {search = urlParams.get("search")}
	if(category == null) {category = urlParams.get("category")}
	if(detail == null) {detail = urlParams.get("detail")}
	if(sort == null) {sort = urlParams.get("sort")}
	
	// 변경할 URL주소 만들기
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

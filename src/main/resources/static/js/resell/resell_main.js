// 기타 변수들 관리
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
	// -----< 초기 값 지정 >-----
	
	
	
	// -----< 초기 값 지정 >-----
	// ===========================================================
	// -----< 페이지 부분 >-----
	
	// 데이터 보내기
	$(".page_box").click(function() {
		var pageNum = $(this).attr("id");
		URLData(url+"?", pageNum, null, null, null, null);
	});
	
	// -----< 페이지 부분 >-----
	// ===========================================================
	// -----< 상단검색바 부분 >-----
	
	// 검색창 열고 닫는 애니메이션
    $("#search_slide").click(function() {
		var width_change = parseInt($("#search_bar").css("width"), 10);
		var rad = $(this).data("rotation") || 0;
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
    // 검색바 돋보기 이미지 누를때도 submit적용
    $("#search_magnifier").click(function() {
		$(".resell_search form").submit();
	});
	// 검색어 지우기
	$(".search_word").on("click", ".search_delete", function() {
		var removeText = $(this).prev().text().trim();
    	var searchArray = search.split(",");
    	var newArray = searchArray.filter(function(item) {
			return item.trim() != removeText;
		});
		var newSearch = newArray.join(",");
    	$(this).closest("li").remove();
    	URLData(url+"?", 1, newSearch, null, null, null);
	});
	
	// -----< 상단검색바 부분 >-----
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
			URLData(url+"?", 1, null, categoryNum, 0, null);
		} else {
			URLData(url+"?", 1, null, categoryNum, null, null);
		}
	});
	
	// -----< 상단 카테고리 부분 >-----
	// ===========================================================
	// -----< 좌특 카테고리 부분 >-----
	
	// 옆쪽 카테고리 열고 닫는 애니메이션 
	$(".moreView").click(function() {
		var visible = $(this).parent().next();
		$(".search_detail").not(visible).slideUp(300);
		visible.slideToggle(300);
		var rad = $(this).data("rotation") || 0;
		var newRad = rad + 45;
		$(this).data("rotation",newRad);
		$(this).css("transform","rotate("+newRad+"deg)");
	});
	// 데이터 보내기
	$(".category_detail").click(function() {
		var detailNum = $(this).attr("id");
		URLData(url+"?", 1, null, null, detailNum, null);
	});
	
	// -----< 좌특 카테고리 부분 >-----
	// ===========================================================
	// -----< 상단 정렬 부분 >-----
	
	// 페이지 실행시 숨기기
	$(".sort_list").hide();
	// 정렬 탭 열고 닫는 애니메이션
	$(".sort_button").click(function() {
		$(".sort_list").animate({width:"toggle"},200);
		var rad = $(".sort_button > img").data("rotation") || 0;
		var newRad = rad + 180;
		$(".sort_button > img").data("rotation", newRad);
		$(".sort_button > img").css("transform","rotate("+newRad+"deg)");
	});
	// 오름차순 버튼 누를때 클래스 변경
	var latest = $(".sort_list").children(":first");
	var name = $(".sort_list").children(":nth-child(2)");
	var price = $(".sort_list").children(":nth-child(3)");
	$("#order_asc").click(function() {
		// 클래스 삭제
		latest.removeClass("latest_desc");
		name.removeClass("name_asc");
		price.removeClass("price_asc");
		$(this).removeClass("order_asc");
		// 클래스 생성
		latest.addClass("latest_asc");
		name.addClass("name_desc");
		price.addClass("price_desc");
		$(this).addClass("order_desc");
		// 기타 설정
		$(this).text("내림차순");
		$(this).children("img").css("transform","rotate(180deg)");
	});
	// 내림차순 버튼 누를때
	$("#order_desc").click(function() {
		// 클래스 삭제
		latest.removeClass("latest_asc");
		name.removeClass("name_desc");
		price.removeClass("price_desc");
		$(this).removeClass("order_desc");
		// 클래스 생성
		latest.addClass("latest_desc");
		name.addClass("name_asc");
		price.addClass("price_asc");
		$(this).addClass("order_asc");
		// 기타 설정
		$(this).text("오름차순");
		$(this).children("img").css("transform","rotate(0deg)");
	});
	// 정렬 데이터 보내기
	$(".resell_sort").click(function() {
		var sortNum = $(this).attr("id");
		if(!sort) {sort="latest_desc"}
		if(sortNum.startsWith("order")) {
			var part = sort.split("_");
			if(part[1] == "asc") {part[1] = "desc"}
			else if(part[1] == "desc") {part[1] = "asc"}
			sortNum = part[0]+"_"+part[1];
		}
		URLData(url+"?", null, null, null, null, sortNum);
	});
	
	// -----< 상단 정렬 부분 >-----
	// ===========================================================
	
	// 게시글 이동 url
	$(".board_view").click(function() {
		var boardNum = $(this).attr("id");
		url += "/board?no="+boardNum+"&";
		URLData(url, null, null, null, null, null);
	});	
});

// ===========================================================
	
// 시간 계산 함수
function timeDiff(time) {
	time = new Date(time);
	var currentTime = new Date();
	var diff = Math.floor((currentTime - time)/60000);
	
	if(diff<1) {return "방금전"}
	else if(diff < 60) {return diff+"분전"}
	else if(diff < 1440) {return Math.floor(diff/60)+"시간전"}
	else if(diff < 10080) {return Math.floor(diff/1440)+"일전"}
	else if(diff < 43200) {return Math.floor(diff/10080)+"주전"}
	else if(diff < 525600) {return Math.floor(diff/43200)+"달전"}
	else {return Math.floor(diff/525600)+"년전"}
}

// ===========================================================

// 검색 관련 함수
function search() {
	var url = window.location.origin + window.location.pathname;
	var params = window.location.search;
	var urlParams = new URLSearchParams(params);
	var search = urlParams.get("search");
	var addSearch = $("#search_bar").val().trim();
	
	// null값 방지
	if(!search) {search=""}
	var newSearch = search;
	
	// 검색어 관련 
	if(addSearch == "") { // 값이 없을시
		alert("검색어를 입력해주세요.");
		return false;
	} else { // 값이 있을시
		var count = (search ? (search.match(/,/g) || []).length : 0);
		if(count==2) { // 검색어 3개 이상 입력하려 할시
			alert("검색어는 최대 3개까지 작성하실수 있습니다.");
			return false;
		}
		// 대소문자 구분 없이 중복 검사
		var duplicate = search.split(",").some(function(item) {
			return item.trim().toLowerCase() === addSearch.toLowerCase();
		});
        if (duplicate) { // 검색어 중복검사
            alert("중복된 검색어입니다. 다시 작성해주세요.");
            return false;
        }
        // 검색어 합치기(쉼표로 구별)
		if(search == null || search == "") {
			newSearch = addSearch;
		} else {
			newSearch += ","+addSearch;
		}
		// URLData(O, O, X, X, X); - 페이지 1로 초기화 되야됨
		URLData(url+"?", 1, newSearch, null, null, null);
	}
	return false;
}

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
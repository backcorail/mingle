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
		$(".category_type").removeClass("select");
		$(this).addClass("select");
	});
	
    // 검색창 애니메이션
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
	var addSearch = $("#search_bar").val().trim();
	var newSearch = search || "";
	
	if(addSearch == "") { // 값이 없을시
		alert("검색어를 입력해주세요.");
		return false;
	} else { // 값이 있을시
		var count = (search ? (search.match(/,/g) || []).length : 0);
		if(count==2) {
			alert("검색어는 최대 3개까지 작성하실수 있습니다.");
			return false;
		}
		// 대소문자 구분 없이 중복 검사
		var duplicate = newSearch.split(",").some(function(item) {
			return item.trim().toLowerCase() === addSearch.toLowerCase();
		});
		
        if (duplicate) {
            alert("중복된 검색어입니다. 다시 작성해주세요.");
            return false;
        }
        
		if(search == null) {
			newSearch = addSearch;
		} else {
			newSearch += ","+addSearch;
		}
		if(!page) {page = 1};
	}

}



// 검색어 지우기
$(document).ready(function() {
	$(".search_word").on("click", ".search_delete", function() {
    	var removeText = $(this).prev().text().trim();
    	var searchUrl = window.location.search;
		var urlParams = new URLSearchParams(searchUrl);
		var search = urlParams.get("search");
		var page = urlParams.get("page");
		var url = window.location.origin + window.location.pathname;
		
    	var searchArray = search.split(",");
    	var newArray = searchArray.filter(function(item) {
			return item.trim() != removeText;
		});
		var newSearch = newArray.join(",");
		var newUrl;
		if(newSearch =="") {
			newUrl = url+"?page="+page;
		} else {
    		newUrl = url+"?page="+page+"&search="+newSearch;
    	}
    	window.location.href = newUrl;
    	$(this).closest("li").remove();
    	
    	$.ajax({
			type : "GET",
			url : "resell",
			data : {
				page:page,
				search:newSearch.split(","),
			}
		});
		return false;
	});
});



$(document).ready(function() {
	$(".sort_list").hide();
	$(".sort_button").click(function() {
		$(".sort_list").animate({width:"toggle"},200);
		var rad = $(".sort_button > img").data("rotation") || 0;
		var newRad = rad + 180;
		$(".sort_button > img").data("rotation", newRad);
		$(".sort_button > img").css("transform","rotate("+newRad+"deg)");
	});
});



// 비동기식(ajax) 데이터 보내기 및 데이터 판별
function URLData(page, search, category, detail, sort) {
	// page - 0 : 값 없음(초기값=1) / !0 : 값 있음
	// search - "" : 값 없음(초기값="") / !"" : 값 있음
	// category - 0 : 값 없음(초기값=1) / !0 : 값 있음
	// detail - 0 : 값 없음(초기값=0) / !0 : 값 있음
	// sort - "" : 값 없음(초기값="latest") /  : 값 있음
	
	// 필요한 변수 및 데이터
	var url = window.location.origin + window.location.pathname;
	var params = window.location.search;
	var urlParams = new URLSearchParams(params);
	
	var newURL = url+"?";
	var count = 0;
	
	// 바꿀값이 없으면 주소에 있는 값 불러오기
	if(page == 0) {page = urlParams.get("page")}
	if(search == "") {search = urlParams.get("search")}
	if(category == 0) {category = urlParams.get("category")}
	if(detail == 0) {detail = urlParams.get("detail")}
	if(sort == "") {sort = urlParams.get("sort")}
	
	// 변경할 URL주소 만들기
	if(!page) {
		if(count>=1) {newURL += "&"}
		newURL += "page="+page;
		count++;
	}
	if(!search) {
		if(count>=1) {newURL += "&"}
		newURL += "search="+search;
		count++;
	}
	if(!category) {
		if(count>=1) {newURL += "&"}
		newURL += "category="+category;
		count++;
	}
	if(!detail) {
		if(count>=1) {newURL += "&"}
		newURL += "detail="+detail;
		count++;
	}
	if(!sort) {
		if(count>=1) {newURL += "&"}
		newURL += "sort="+sort;
		count++;
	}
	
	// 바꿀 값, 현재 주소의 값 둘다 없을 때 보낼 데이터 초기값 정해주기 
	if(!page) {page=1};
	if(!search) {search=""};
	if(!category) {category=0};
	if(!detail) {category=1};
	if(!sort) {sort="latest"};
	
	// 새로만든 주소 적용하기
	window.location.href = newURL;
	
	// 비동기식 데이터 보내기
	$.ajax({
		type : "GET",
		url : "resell",
		data : {
			page : page,
			search : search,
			category : category,
			detail : detail,
			sort : sort
		},
		success : function(d) {
			console.log("전송 완료");
		},
		error : function(d) {
			console.log("전솔 실패");
		}
	});
}
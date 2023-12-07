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
	var searchUrl = window.location.search;
	var urlParams = new URLSearchParams(searchUrl);
	var search = urlParams.get("search");
	var page = urlParams.get("page");
	var addSearch = $("#search_bar").val().trim();
	var url = window.location.origin + window.location.pathname;
	var newSearch = search || "";
	console.log(search);
	
	
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
		var isDuplicate = newSearch.split(",").some(function(item) {
			return item.trim().toLowerCase() === addSearch.toLowerCase();
		});
		
        if (isDuplicate) {
            alert("중복된 검색어입니다. 다시 작성해주세요.");
            return false;
        }
        
		if(search == null) {
			newSearch = addSearch;
		} else {
			newSearch += ","+addSearch;
		}
		if(!page) {page = 1};
		var newUrl = url+"?page="+page+"&search="+newSearch;
		window.location.href = newUrl;
	}
	$.ajax({
		type : "GET",
		url : "resell",
		data : {
			page:page,
			search:newSearch.split(","),
		}
	});
	return false;
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



// URL 변수 받기
$(document).ready(function() {
	// 현재 페이지 URL 가져오기
	var url = window.location.search;
	var urlParams = new URLSearchParams(url);
	var nowPage = urlParams.get("page"); 
	var searchValue = urlParams.get("search");
	
	if(!nowPage) { nowPage = 1; };
	if(!searchValue) {searchValue = ""};
	
	var searchArray = searchValue.split('/');
	var searchNum = searchArray.length;
	
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

//탭관련 변수
$(document).ready(function() {
	const hot = document.getElementById('hot');
	const daily = document.getElementById('daily');
	const weekly = document.getElementById('weekly');
	var url = window.location.search;
	var urlParams = new URLSearchParams(url);
	var tabs2 = urlParams.get("tabs2");
	switch(tabs2) {
		case "1" :
			hot.style.cssText = 'background: linear-gradient(90deg, rgba(255,214,0,1) 0%, rgba(155,255,0,1) 35%, rgba(0,255,184,1) 100%);color: white; font-weight: bold; pointer-events: none;';
			
		 	$.get("style/ranking", function(d) { 
				const data = $(d).find(".all_select");
				$("#tabs2").html(data);
			});
			break;
		case "2" : 
			daily.style.cssText = 'background: linear-gradient(90deg, rgba(255,214,0,1) 0%, rgba(155,255,0,1) 35%, rgba(0,255,184,1) 100%);color: white; font-weight: bold; pointer-events: none;';
			$.get("style/ranking", function(d) {
				const data = $(d).find(".all_select");
				$("#tabs2").html(data);
			});
			break;
		case "3" :
			weekly.style.cssText = 'background: linear-gradient(90deg, rgba(255,214,0,1) 0%, rgba(155,255,0,1) 35%, rgba(0,255,184,1) 100%);color: white; font-weight: bold; pointer-events: none;';
			$.get("style/ranking", function(d) {
				const data = $(d).find(".all_select");
				$("#tabs2").html(data);
			});
			break;
		default :
	}
	
	if(!tabs2) {tabs2 = 1};
	$.ajax({
		type:"GET",
		url:"style",
		data:{tabs2:tabs2}
	});
	
	//헤더 css 변경
	const headerDiv = document.getElementById('headerDiv');
	const header_logo = document.getElementById('header_logo');
	const header_loginArea = document.getElementById('header_loginArea').querySelector("a");
	const logout = document.getElementById('logout');
	
	headerDiv.style.cssText = 'background-color:white;';
	header_logo.style.cssText = 'color:black;';
	header_loginArea.style.cssText = 'color:black;';
	logout.style.cssText = 'color:black;';
});

// 더보기 (순서 오류로 jsp에 직접 넣음)
/*$('#moreview1').on('click', function() {
    var boardListNowHidden = $(this).parent().find('.board_list_now_hidden').first();
    if (boardListNowHidden.css('display') == 'none' || boardListNowHidden.css('display') == '') {
        boardListNowHidden.css('display', 'flex');
        $(this).text('접기');
    } else {
        boardListNowHidden.css('display', 'none');
        $(this).text('더보기');
    }
});*/
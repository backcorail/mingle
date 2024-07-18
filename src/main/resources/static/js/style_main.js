$(document).ready(function() {
	const ranking = document.getElementById('ranking_tab');
	const style = document.getElementById('style_tab');
	const trend = document.getElementById('trend_tab');
	const request = document.getElementById('request_tab');
	var url = window.location.search;
	var urlParams = new URLSearchParams(url);
	var tabs = urlParams.get("tabs");
	switch(tabs) {
		case "1" :
			ranking.style.cssText = 'background: linear-gradient(90deg, rgba(255,214,0,1) 0%, rgba(155,255,0,1) 35%, rgba(0,255,184,1) 100%);color: transparent;-webkit-background-clip: text; font-weight: bold; pointer-events: none; border-bottom: 3px solid rgba(0,255,184,1);';
		 	$.get("style/ranking", function(d) {
				const data = $(d).find(".all_select");
				$("#tabs").html(data);
			});
			break;
		case "2" : 
			style.style.cssText = 'background: linear-gradient(90deg, rgba(255,214,0,1) 0%, rgba(155,255,0,1) 35%, rgba(0,255,184,1) 100%);color: transparent;-webkit-background-clip: text; font-weight: bold; pointer-events: none; border-bottom: 3px solid rgba(0,255,184,1);';
			$.get("style/styles", function(d) {
				const data = $(d).find(".all_select");
				$("#tabs").html(data);
			});
			break;
		case "3" :
			trend.style.cssText = 'background: linear-gradient(90deg, rgba(255,214,0,1) 0%, rgba(155,255,0,1) 35%, rgba(0,255,184,1) 100%);color: transparent;-webkit-background-clip: text; font-weight: bold; pointer-events: none; border-bottom: 3px solid rgba(0,255,184,1);';
			$.get("style/trend", function(d) {
				const data = $(d).find(".all_select");
				$("#tabs").html(data);
			});
			break;
		case "4" :
			console.log("hello");
			request.style.cssText = 'background: linear-gradient(90deg, rgba(255,214,0,1) 0%, rgba(155,255,0,1) 35%, rgba(0,255,184,1) 100%);color: transparent;-webkit-background-clip: text; font-weight: bold; pointer-events: none; border-bottom: 3px solid rgba(0,255,184,1);';
			$.get("style/request", function(d) {
				const data = $(d).find(".all_select");
				$("#tabs").html(data);
			});
			break;
		default :
	}
	
	if(!tabs) {tabs = 1};
	$.ajax({
		type:"GET",
		url:"style",
		data:{tabs:tabs}
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






$(document).ready(function() {
	var url = window.location.search;
	var urlParams = new URLSearchParams(url);
	var tabs = urlParams.get("tabs");
	switch(tabs) {
		case "1" :
		 	$.get("style/ranking", function(d) {
				const data = $(d).find(".all_select");
				$("#tabs").html(data);
			});
			break;
		case "2" :
			$.get("style/styles", function(d) {
				const data = $(d).find(".all_select");
				$("#tabs").html(data);
			});
			break;
		case "3" :
			$.get("style/trend", function(d) {
				const data = $(d).find(".all_select");
				$("#tabs").html(data);
			});
			break;
		case "4" :
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
	
	if(!tabs) {tabs = 2};
	$.ajax({
		type:"GET",
		url:"style",
		data:{tabs:tabs}
	});
	
	if(!tabs) {tabs = 3};
	$.ajax({
		type:"GET",
		url:"style",
		data:{tabs:tabs}
	});
	
	if(!tabs) {tabs = 4};
	$.ajax({
		type:"GET",
		url:"style",
		data:{tabs:tabs}
	});
});






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
		default :
	}
	
	if(!tabs) {tabs = 1};
	$.ajax({
		type:"GET",
		url:"style",
		data:{tabs:tabs}
	});
});


$(document).ready(function() {
	$("body").on('click', '.board_items', function() {
		console.log("in");
        window.location.href = "/mingle/style/trend/info";
    });
});

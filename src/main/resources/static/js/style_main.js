$(function() {

    $("#style_tabs").tabs({
        activate: function(event, ui) {
            var tabId = ui.newPanel.attr('id');
            switch(tabId) {
                case 'tabs-1':
                    $.get("ranking", function(data) {
						const rankData = $(data).find(".all_select");
						console.log(rankData.html());
						$("#tabs-1").html(rankData);
					});
                    break;
                case 'tabs-2':
					$.get("styles", function(data) {
						const rankData = $(data).find(".all_select");
						console.log(rankData.html());
						$("#tabs-2").html(rankData);
					});
                    break;
                case 'tabs-3':
                    $.get("trend", function(data) {
						const rankData = $(data).find(".all_select");
						console.log(rankData.html());
						$("#tabs-3").html(rankData);
					});
                    break;
                case 'tabs-4':
					$.get("request", function(data) {
						const rankData = $(data).find(".all_select");
						console.log(rankData.html());
						$("#tabs-4").html(rankData);
					});
                    break;
            }
        }
    });
});

$(document).ready(function() {
	$.get("ranking", function(data) {
		const rankData = $(data).find(".all_select");
		console.log(rankData.html());
		$("#tabs-1").html(rankData);
	});
});

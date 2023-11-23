$(function() {
    $("#style_tabs").tabs({
        activate: function(event, ui) {
            var tabId = ui.newPanel.attr('id');
            $(".tab").removeClass("active"); // 모든 탭에서 active 클래스 제거
            $('a[href="#' + tabId + '"]').parent().addClass("active"); 
            // 현재 탭에 active 클래스 추가
            
            var baseURL = "/mingle/style/"; // 기본 URL 설정
            switch(tabId) {
                case 'tabs-1':
                    $.get(baseURL + "ranking", function(data) {
						const rankData = $(data).find(".all_select");
						console.log(rankData.html());
						$("#tabs-1").html(rankData);
					});
                    break;
                case 'tabs-2':
					$.get(baseURL + "styles", function(data) {
						const rankData = $(data).find(".all_select");
						console.log(rankData.html());
						$("#tabs-2").html(rankData);
					});
                    break;
                case 'tabs-3':
                    $.get(baseURL + "trend", function(data) {
						const rankData = $(data).find(".all_select");
						console.log(rankData.html());
						$("#tabs-3").html(rankData);
					});
                    break;
                case 'tabs-4':
					$.get(baseURL + "request", function(data) {
						const rankData = $(data).find(".all_select");
						console.log(rankData.html());
						$("#tabs-4").html(rankData);
					});
                    break;
            }
        }
    });
});

// 첫 번째 탭의 콘텐츠 로드
$(document).ready(function() {
	var baseURL = "/mingle/style/";
	$.get(baseURL + "ranking", function(data) {
		const rankData = $(data).find(".all_select");
		console.log(rankData.html());
		$("#tabs-1").html(rankData);
	});
});

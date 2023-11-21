$(function() {
    // 첫 번째 탭의 콘텐츠를 직접 로드
    loadTabContent('tabs-1', '/mingle/style/ranking');

    $("#style_tabs").tabs({
        activate: function(event, ui) {
            var tabId = ui.newPanel.attr('id');
            var contentUrl;
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
						$("#tabs-1").html(rankData);
					});
                    break;
                case 'tabs-3':
                    $.get("trend", function(data) {
						const rankData = $(data).find(".all_select");
						console.log(rankData.html());
						$("#tabs-1").html(rankData);
					});
                    break;
                case 'tabs-4':
					$.get("request", function(data) {
						const rankData = $(data).find(".all_select");
						console.log(rankData.html());
						$("#tabs-1").html(rankData);
					});
                    contentUrl = '/mingle/style/request';
                    break;
            }
            // AJAX 요청을 보내서 JSP 파일을 가져오고 해당 내용을 채움
            loadTabContent(tabId, contentUrl);
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


function loadTabContent(tabId, contentUrl) {
    // AJAX 요청을 보내서 JSP 파일을 가져오고 해당 내용을 채움
    $.ajax({
        url: contentUrl,
        success: function(data) {
            $("#" + tabId).html(data); // 탭 콘텐츠를 업데이트
        },
        error: function() {
            $("#" + tabId).html("데이터를 불러올 수 없습니다."); // 오류 처리
        }
    });
}

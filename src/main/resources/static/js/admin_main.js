$(function() {
    $("#admin_tabs").tabs({
        activate: function(event, ui) {
            var tabId = ui.newPanel.attr('id');
            $(".tab").removeClass("active"); // 모든 탭에서 active 클래스 제거
            $('a[href="#' + tabId + '"]').parent().addClass("active"); 
            
            var baseURL = "/mingle/admin/"; // 기본 URL 설정
            switch(tabId) {
                case 'tabs-1':
                    $.get(baseURL + "members", function(data) {
                        var content = $(data).find(".all_select").html();
                        console.log(content);
                        $("#tabs-1").html(content);
                    });
                    break;
                case 'tabs-2':
                    $.get(baseURL + "admin_2.jsp", function(data) {
                        var content = $(data).find(".all_select").html();
                        console.log(content);
                        $("#tabs-2").html(content);
                    });
                    break;
                case 'tabs-3':
                    $.get(baseURL + "admin_3.jsp", function(data) {
                        var content = $(data).find(".all_select").html();
                        console.log(content);
                        $("#tabs-3").html(content);
                    });
                    break;
                case 'tabs-4':
                    $.get(baseURL + "products", function(data) {
                        var content = $(data).find(".all_select").html();
                        console.log(content);
                        $("#tabs-4").html(content);
                    });
                    break;
                case 'tabs-5':
                    $.get(baseURL + "admin_3.jsp", function(data) {
                        var content = $(data).find(".all_select").html();
                        console.log(content);
                        $("#tabs-5").html(content);
                    });
                    break;
                case 'tabs-6':
                    $.get(baseURL + "transactions", function(data) {
                        var content = $(data).find(".all_select").html();
                        console.log(content);
                        $("#tabs-6").html(content);
                    });
                    break;
                case 'tabs-7':
                    $.get(baseURL + "admin_3.jsp", function(data) {
                        var content = $(data).find(".all_select").html();
                        console.log(content);
                        $("#tabs-7").html(content);
                    });
                    break;
                case 'tabs-8':
                    $.get(baseURL + "admin_posts", function(data) {
                        var content = $(data).find(".all_select").html();
                        console.log(content);
                        $("#tabs-8").html(content);
                    });
                    break;
                case 'tabs-9':
                    $.get(baseURL + "admin_3.jsp", function(data) {
                        var content = $(data).find(".all_select").html();
                        console.log(content);
                        $("#tabs-9").html(content);
                    });
                    break;
                case 'tabs-10':
                    $.get(baseURL + "admin_3.jsp", function(data) {
                        var content = $(data).find(".all_select").html();
                        console.log(content);
                        $("#tabs-10").html(content);
                    });
                    break;
                case 'tabs-11':
                    $.get(baseURL + "admin_3.jsp", function(data) {
                        var content = $(data).find(".all_select").html();
                        console.log(content);
                        $("#tabs-11").html(content);
                    });
                    break;
                case 'tabs-12':
                    $.get(baseURL + "admin_3.jsp", function(data) {
                        var content = $(data).find(".all_select").html();
                        console.log(content);
                        $("#tabs-12").html(content);
                    });
                    break;
                case 'tabs-13':
                    $.get(baseURL + "server", function(data) {
                        var content = $(data).find(".all_select").html();
                        console.log(content);
                        $("#tabs-13").html(content);
                    });
                    break;
                // 추가 탭에 대한 처리 추가
            }
        }
    });
});

/* 첫 번째 탭의 콘텐츠 로드
$(document).ready(function() {
    var baseURL = "/mingle/admin/";
    $.get(baseURL + "members", function(data) {
        var content = $(data).find(".all_select").html();
        console.log(content);
        $("#tabs-1").html(content);
    });
});
*/
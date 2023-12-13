// 스크롤
window.onscroll = function() {
	var hiddenDivs = document.getElementsByClassName('board_items_hidden');
	for (var i = 0; i < hiddenDivs.length; i++) {
		if (hiddenDivs[i].getBoundingClientRect().top <= window.innerHeight) {
			hiddenDivs[i].style.opacity = "1";
		}
	}
};

// info 이동
$(document).ready(function() {
    $(".hashtag").click(function() {
        window.location.href = "/mingle/style/trend/info";
    });
});

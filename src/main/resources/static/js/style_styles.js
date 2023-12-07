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
    $(".img").click(function() {
        window.location.href = "/mingle/style/trend/info";
    });
});


// 좋아요 기능
$('.heart-btn').click(function() {
    var likesDiv = $(this).siblings('.style_likes_check');

    $.ajax({
        url: '/mingle/style?tabs=2',
        type: 'POST',
        data: { 
            like: 1
        },
        success: function(response) {
            likesDiv.text(response); 
            console.log("aasd");
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);
        	console.log(jqXHR, textStatus, errorThrown);
        }
    });
});
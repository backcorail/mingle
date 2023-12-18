// 스크롤
window.onscroll = function() {
    var hiddenDivs = document.getElementsByClassName('board_items_hidden');
    for (var i = 0; i < hiddenDivs.length; i++) {
        if (hiddenDivs[i].getBoundingClientRect().top <= window.innerHeight) {
            hiddenDivs[i].style.opacity = "1";
        }
    }
};


$(document).on('click', '.likeLink1, .likeLink2', function(e) {
    e.preventDefault();
    console.log('asd');
    
      var $this = $(this);
        var $img = $this.find('img.like1');
        var $span = $this.find('span');
        var count = parseInt($span.text(), 10);

        if ($img.attr('src') === '/mingle/img/img_mingle/page_recell/icon_heart.png') {
            // 하트가 비워져 있을 경우
            $img.attr('src', '/mingle/img/style/찬하트 사진.jpg'); // 하트 채우기
            $span.text(count + 1); // span 값 1 증가
        } else {
            // 하트가 채워져 있을 경우
            $img.attr('src', '/mingle/img/img_mingle/page_recell/icon_heart.png'); // 하트 비우기
            $span.text(count - 1); // span 값 1 감소
        }
    });
   

$(document).ready(function() {
	$("body").on('click', '.hashtag', function() {
		console.log("in");
    });
});
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
    
   
    });

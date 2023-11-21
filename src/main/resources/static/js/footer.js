$(function() {
    $(window).scroll(function() {
        if ($(this).scrollTop() > 100) {
            $('#area_sideBtn').fadeIn();
        } else {
            $('#area_sideBtn').fadeOut();
        }
    });
    
    $("#MOVE_TOP_BTN").click(function() {
        $('html, body').animate({
            scrollTop : 0
        }, 400);
        return false;
    });
});
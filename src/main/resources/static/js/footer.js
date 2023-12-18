$(function() {
    $(window).scroll(function() {
        if(window.location.pathname=="/mingle/"){
			if ($(this).scrollTop() > 100) {
	            $('#area_sideBtn').fadeIn();
	        } else {
	            $('#area_sideBtn').fadeOut();
	        }
		}else{
			$('#area_sideBtn').fadeIn();
		}
    });
    
    $("#MOVE_TOP_BTN").click(function() {
        $('html, body').animate({
            scrollTop : 0
        }, 400);
        return false;
    });
});
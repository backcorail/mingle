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
    
    $("#sideBtn_3").click(function() {
        $('html, body').animate({
            scrollTop : 0
        }, 400);
        return false;
    });
});

////////////////////////////
//채팅 파트
//채팅 보이기/닫기
let isScrollInitialized = false;
function showChat(){
	const chat = document.getElementById("root");
	if(chat.style.display == "block"){
		chat.style.display = "none";
	}else{
		chat.style.display = "block";
	}
	if (!isScrollInitialized) {
        scrollToBottom();
        isScrollInitialized = true;
    }
}
function closeChat(){
	const chat = document.getElementById("root");
	chat.style.display = "none";
}
//채팅리스트 보이기
function showChatlist(){
	const room = document.getElementById("chatRoom");
	const list = document.getElementById("chatList");
	room.style.display = "none";
	list.style.display = "block";
}
//스크롤 맨아래로
function scrollToBottom() {
    const chatContent = document.getElementById('chatContent');
    chatContent.scrollTop = chatContent.scrollHeight;
}
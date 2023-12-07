//좌상단 메뉴 토글 버튼
function toggleBtn(){
	const tab = document.getElementById("tabMenu_header");
	if(tab.style.display == "block"){
		tab.style.display = "none";
	}else{
		tab.style.display = "block";
	}
}
//오버시 - onmouseover
function showSubMenu(n){
	document.getElementById("area_tabMenu_"+n).style.lineHeight = "normal";
	document.getElementById("subMenu_"+n).style.display = "block";
 }
//아웃시 - onmouseout 
function showSubHidden(n){
	document.getElementById("area_tabMenu_"+n).style.lineHeight = "300px";
	document.getElementById("subMenu_"+n).style.display = "none";
}
//로그아웃 클릭. - 현제 페이지로 이동.
$(function(){
	$('#logout').click(function(e) {
        e.preventDefault();  // 기본 링크 동작을 방지합니다.

        const href = $(this).attr('href'); // href 속성을 가져옵니다.
		console.log("this 의 주인공"+ this);
		console.log(this);
		
       $.ajax({
            url: href,
            type: 'POST',
            success: function(response) {
                // 요청이 성공적일 경우 여기에서 처리합니다.
                console.log(response);
                history.go(0); // 새로고침.
            },
            error: function(xhr, status, error) {
                // 에러 처리
                console.error('Request failed: ' + status + ', ' + error);
            }
        }); //ajax
    }); // 클릭 이벤트
})// 제이쿼리 끝

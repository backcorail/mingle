// 주소 선택 api

$(document).ready(function() {
	$(".addr_post").hide();
	$(".addr_box").hide();
	var addr = $(".addr_post").val();
	if(addr != "") {
		updateUI(addr);
		initMap(addr);
	}
});

function searchAddr() {
	new daum.Postcode({
		oncomplete : function(data) {
			var addr = data.sigungu + " " + data.bname;
			updateUI(addr);
			initMap(addr);
		}
	}).open();
}

function updateUI(addr) {
	console.log("주소변경 - "+addr);
	$(".addr_post").val(addr);
	$(".addr_box").text(addr);
	$(".addr_box").show();
	$("#map").show();
}

function initMap(addr){
	var mapContainer = document.getElementById('map') // 지도를 표시할 div 
	var mapOption = {
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 5 // 지도의 확대 레벨
	    };  
	
	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
	var mapTypeControl = new kakao.maps.MapTypeControl();
	
	// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
	// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
	map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
	
	// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
	var zoomControl = new kakao.maps.ZoomControl();
	map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch(addr, function(result, status) {
	
	    // 정상적으로 검색이 완료됐으면 
	    if (status === kakao.maps.services.Status.OK) {
	
		    var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		
	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });
	
	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: '<div class="marker_info">'+addr+'</div>'
	        });
	        infowindow.open(map, marker);
	
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	        
	        var marker = $(".marker_info").parent().parent();
			marker.css("height","30px");
			marker.css("border-radius","5px");
			marker.css("width","200px");
		}
	});
}

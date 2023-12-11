var container = document.getElementById('currentMap');
var options = {
	center: new kakao.maps.LatLng(36.000701, 127.570667),
	level: 14
};
var map = new kakao.maps.Map(container, options);

var MARKER_WIDTH = 33, // 기본, 클릭 마커의 너비
    MARKER_HEIGHT = 36, // 기본, 클릭 마커의 높이
    OFFSET_X = 12, // 기본, 클릭 마커의 기준 X좌표
    OFFSET_Y = MARKER_HEIGHT, // 기본, 클릭 마커의 기준 Y좌표
    OVER_MARKER_WIDTH = 40, // 오버 마커의 너비
    OVER_MARKER_HEIGHT = 42, // 오버 마커의 높이
    OVER_OFFSET_X = 13, // 오버 마커의 기준 X좌표
    OVER_OFFSET_Y = OVER_MARKER_HEIGHT, // 오버 마커의 기준 Y좌표
    SPRITE_WIDTH = 126, // 스프라이트 이미지 너비
    SPRITE_HEIGHT = 146, // 스프라이트 이미지 높이
    SPRITE_GAP = 10; // 스프라이트 이미지에서 마커간 간격

var markerSize = new kakao.maps.Size(MARKER_WIDTH, MARKER_HEIGHT), // 기본, 클릭 마커의 크기
    markerOffset = new kakao.maps.Point(OFFSET_X, OFFSET_Y), // 기본, 클릭 마커의 기준좌표
    overMarkerSize = new kakao.maps.Size(OVER_MARKER_WIDTH, OVER_MARKER_HEIGHT), // 오버 마커의 크기
    overMarkerOffset = new kakao.maps.Point(OVER_OFFSET_X, OVER_OFFSET_Y), // 오버 마커의 기준 좌표
    spriteImageSize = new kakao.maps.Size(SPRITE_WIDTH, SPRITE_HEIGHT); // 스프라이트 이미지의 크기

var	city="";


var arr = [
	['Seoul', 37.566667, 126.978056, "서울"],
	['Incheon', 37.4562557, 126.7052062, "인천"],
	['Gyeonggi-do', 37.275052, 127.009447, "경기도"],
	['Gangwon-do', 37.88557, 127.730186, "강원도"],
	['Chungcheongnam-do', 36.658827, 126.672835, "충청남도"],
	['Chungcheongbuk-do', 36.635684, 127.49139, "충청북도"],
	['Jeollanam-do', 34.816862, 126.464532, "전라남도"],
	['Jeollabuk-do', 35.820358, 127.108726, "전라북도"],
	['Gyeongsangnam-do', 35.236591, 128.690441,"경상남도"],
	['Gyeongsangbuk-do', 36.25, 128.75,"경상북도"],
	['Jeju', 33.5, 126.516667,"제주도"],
	['Busan', 35.179444, 129.075556,"부산"],
	['Daegu', 35.871389, 128.601389,"대구"],
	['Gwangju', 35.159444, 126.8525,"광주"],
	['Daejeon', 36.350833, 127.385,"대전"],
	['Ulsan', 35.538333, 129.311389,"울산"]];

// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다 
var positions = [
    {
        content: '<div style="color:black;">'+arr[0][3]+'</div>', 
        latlng: new kakao.maps.LatLng(arr[0][1], arr[0][2])
    },
    {
        content: '<div style="color:black">'+arr[1][3]+'</div>', 
        latlng: new kakao.maps.LatLng(arr[1][1], arr[1][2])
    },
    {
        content: '<div style="color:black">'+arr[2][3]+'</div>', 
        latlng: new kakao.maps.LatLng(arr[2][1], arr[2][2])
    },
    {
        content: '<div style="color:black">'+arr[3][3]+'</div>',
        latlng: new kakao.maps.LatLng(arr[3][1], arr[3][2])
    },
    {
        content: '<div style="color:black">'+arr[4][3]+'</div>', 
        latlng: new kakao.maps.LatLng(arr[4][1], arr[4][2])
    },
    {
        content: '<div style="color:black">'+arr[5][3]+'</div>', 
        latlng: new kakao.maps.LatLng(arr[5][1], arr[5][2])
    },
    {
        content: '<div style="color:black">'+arr[6][3]+'</div>', 
        latlng: new kakao.maps.LatLng(arr[6][1], arr[6][2])
    },
    {
        content: '<div style="color:black">'+arr[7][3]+'</div>', 
        latlng: new kakao.maps.LatLng(arr[7][1], arr[7][2])
    },
    {
        content: '<div style="color:black">'+arr[8][3]+'</div>', 
        latlng: new kakao.maps.LatLng(arr[8][1], arr[8][2])
    },
    {
        content: '<div style="color:black">'+arr[9][3]+'</div>', 
        latlng: new kakao.maps.LatLng(arr[9][1], arr[9][2])
    },
    {
        content: '<div style="color:black">'+arr[10][3]+'</div>', 
        latlng: new kakao.maps.LatLng(arr[10][1], arr[10][2])
    },
    {
        content: '<div style="color:black">'+arr[11][3]+'</div>', 
        latlng: new kakao.maps.LatLng(arr[11][1], arr[11][2])
    },
    {
        content: '<div style="color:black">'+arr[12][3]+'</div>', 
        latlng: new kakao.maps.LatLng(arr[12][1], arr[12][2])
    },
    {
        content: '<div style="color:black">'+arr[13][3]+'</div>', 
        latlng: new kakao.maps.LatLng(arr[13][1], arr[13][2])
    },
    {
        content: '<div style="color:black">'+arr[14][3]+'</div>', 
        latlng: new kakao.maps.LatLng(arr[14][1], arr[14][2])
    },
    {
        content: '<div style="color:black">'+arr[15][3]+'</div>', 
        latlng: new kakao.maps.LatLng(arr[15][1], arr[15][2])
    }
], selectedMarker = null; // 클릭한 마커를 담을 변수;

// 지도 위에 마커를 표시합니다
for (var i = 0; i < positions.length; i++) {
    var gapX = (MARKER_WIDTH + SPRITE_GAP), // 스프라이트 이미지에서 마커로 사용할 이미지 X좌표 간격 값
        originY = (MARKER_HEIGHT + SPRITE_GAP) * i, // 스프라이트 이미지에서 기본, 클릭 마커로 사용할 Y좌표 값
        overOriginY = (OVER_MARKER_HEIGHT + SPRITE_GAP) * i, // 스프라이트 이미지에서 오버 마커로 사용할 Y좌표 값
        normalOrigin = new kakao.maps.Point(0, originY), // 스프라이트 이미지에서 기본 마커로 사용할 영역의 좌상단 좌표
        clickOrigin = new kakao.maps.Point(gapX, originY), // 스프라이트 이미지에서 마우스오버 마커로 사용할 영역의 좌상단 좌표
        overOrigin = new kakao.maps.Point(gapX * 2, overOriginY); // 스프라이트 이미지에서 클릭 마커로 사용할 영역의 좌상단 좌표
        
    // 마커를 생성하고 지도위에 표시합니다
    addMarker(positions[i].latlng, i);
    
    // 마커에 표시할 인포윈도우를 생성합니다 
}

// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
function makeOverListener(map, marker, infowindow) {
    return function() {
        infowindow.open(map, marker);
    };
}

// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
function makeOutListener(infowindow) {
    return function() {
        infowindow.close();
    };
}



// 마커를 생성하고 지도 위에 표시하고, 마커에 mouseover, mouseout, click 이벤트를 등록하는 함수입니다
function addMarker(position, number) {

    // 기본 마커이미지, 오버 마커이미지, 클릭 마커이미지를 생성합니다
    
    // 마커를 생성하고 이미지는 기본 마커 이미지를 사용합니다
    var marker = new kakao.maps.Marker({
        map: map,
        position: position,
	});

    // 마커에 click 이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'click', function() {

        // 클릭된 마커가 없고, click 마커가 클릭된 마커가 아니면
        // 마커의 이미지를 클릭 이미지로 변경합니다
        if (!selectedMarker || selectedMarker !== marker) {
			city = arr[number][0];
			console.log(city);
        }

        // 클릭된 마커를 현재 클릭된 마커 객체로 설정합니다
        selectedMarker = marker;
    });
    
     var infowindow = new kakao.maps.InfoWindow({
        content: positions[i].content // 인포윈도우에 표시할 내용
    });

    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
}

// MakrerImage 객체를 생성하여 반환하는 함수입니다
function createMarkerImage(markerSize, offset, spriteOrigin) {
    var markerImage = new kakao.maps.MarkerImage(
        markerSize, // 마커의 크기
        {
            offset: offset, // 마커 이미지에서의 기준 좌표
            spriteOrigin: spriteOrigin, // 스트라이프 이미지 중 사용할 영역의 좌상단 좌표
            spriteSize: spriteImageSize // 스프라이트 이미지의 크기
        }
    );
    
    return markerImage;
}



function printCityWeather(){
	if(city==""){
		alert("거주지를 선택해 주세요.");
	}else{
		var check = $(this).attr('name');
		$(this).attr("href", "cody_board?city="+city+"&situation="+check);
	}
	
}

$(document).ready(function(){
	$('#exercise').on('click',printCityWeather);
	$('#wedding').on('click',printCityWeather);
	$('#business').on('click',printCityWeather);
	$('#daily').on('click',printCityWeather);
	
	
});





















			
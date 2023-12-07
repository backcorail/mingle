<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="/mingle/css/cody/cody.css">

<div class="background">
	<div class="where"><b>현재 거주하는 지역을 선택해주세요</b>
		<div class="currentMap" id="currentMap"></div>
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1a837c752e79af40c0be818db797f371"></script>
		<script>
			var container = document.getElementById('currentMap');
			var options = {
			center: new kakao.maps.LatLng(36.000701, 127.570667),
			level: 14
			};
			var map = new kakao.maps.Map(container, options);
			
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
			];
			
			for (var i = 0; i < positions.length; i ++) {
			    // 마커를 생성합니다
			    var marker = new kakao.maps.Marker({
			        map: map, // 마커를 표시할 지도
			        position: positions[i].latlng // 마커의 위치
			    });

			    // 마커에 표시할 인포윈도우를 생성합니다 
			    var infowindow = new kakao.maps.InfoWindow({
			        content: positions[i].content // 인포윈도우에 표시할 내용
			    });

			    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
			    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
			    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
			    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
			    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
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
			
			
			
		</script>
	</div>
	<div class="today_concept"><b>오늘의 컨셉은?</b>
		<a href="cody_board"><div class="exercise">
			<span>운동</span><br>
			<img src="/mingle/img/cody/background/exercise.jpg">
		</div></a>
		<a href="cody_board"><div class="wedding"><span>결혼식</span><br>
			<img src="/mingle/img/cody/background/wedding.jpg">
		</div></a>
		<a href="cody_board"><div class="business"><span>비즈니스</span><br>
			<img src="/mingle/img/cody/background/business.jpg">
		</div></a>
		<a href="cody_board"><div class="daily"><span>일상</span><br>
			<img src="/mingle/img/cody/background/daily.jpg">
		</div></a>
	</div>
</div>
    
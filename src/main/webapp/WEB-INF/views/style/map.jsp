<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>주소로 장소 표시하기</title>
    
</head>
<body>
<div style="margin-top : 100px;">
<p style="margin-top:-12px">
    <em class="link">
        <a href="javascript:void(0);" onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">
            혹시 주소 결과가 잘못 나오는 경우에는 여기에 제보해주세요.
        </a>
    </em>
</p>

<form id="searchForm">
    <input type="text" id="addressInput" placeholder="주소를 입력하세요">
    <input type="submit" value="검색">
</form>

<div id="map" style="width:1000px;height:350px;"></div>


</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=43f789e75b8922b41ac6921c8e130658&libraries=services"></script>


<script>
document.getElementById('searchForm').addEventListener('submit', function(e) {
    e.preventDefault();  // 폼 제출을 막아 페이지 새로고침을 방지합니다
    var address = document.getElementById('addressInput').value;  // 사용자가 입력한 주소를 가져옵니다
    geocoder.addressSearch(address, function(result, status) {  // 사용자가 입력한 주소로 검색합니다
       // 나머지 코드는 이전과 동일합니다
    	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
        mapOption = {
            center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };  

    // 지도를 생성합니다    
    var map = new kakao.maps.Map(mapContainer, mapOption); 

    // 주소-좌표 변환 객체를 생성합니다
    var geocoder = new kakao.maps.services.Geocoder();

    // 주소로 좌표를 검색합니다
    geocoder.addressSearch('제주특별자치도 제주시 첨단로 242', function(result, status) {

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
                content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
            });
            infowindow.open(map, marker);

            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            map.setCenter(coords);
        } 
    });
       
       
    });
});

</script>








</body>
</html>
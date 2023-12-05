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
    
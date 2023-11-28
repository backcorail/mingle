<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/mingle/css/cody_board.css">
<script src="/mingle/js/cody_board.js"></script>

<div class="codyboard_background" style="background-image:url('/mingle/img/cody/day_sunny/background.png');">
	<div class="weather">
		<span>오늘의 날씨</span>
		<div class="today" id="today">
		<h1 id="dateName"></h1>
		<a id="date"></a><br>
		<img id="weather_Icon" style="width:60px;height:60px;"/><br>
		<a id="min_temperature" class="min_temperature"></a><a style="color:#D8D8D8">/</a><a id="max_temperature" class="max_temperature"></a><br>
		<a></a>
		</div>
	</div>
	<div class="codiTap">
		<h2 style="color:#FF1493; text-align:center;"><b>추천 코디</b></h2>
		<img class="codi" src="/mingle/img/cody/2.jpg"><br>
		
		<a>무난무난하고 깔끔한 데일리 켐퍼스룩</a>
		</div>
	<div class="cody_item">
		<div class="slide">
		<h1 class="category_h1">자켓</h1>
	      	<ul class="slide_list">
	      		<li class="rightBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
	        	<c:forEach var="n" begin="1" end="4">
					<li class="slide_item">
	        			<img src="/mingle/img/cody/jk.jpg">
	        		</li>
				</c:forEach>
	        	<li class="leftBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
	      </ul>
	   </div>
	   <div class="slide">
	   <h1 class="category_h1">맨투맨</h1>
	      	<ul class="slide_list">
	      		<li class="rightBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
	        	<c:forEach var="n" begin="1" end="4">
					<li class="slide_item">
	        			<img src="/mingle/img/cody/mtm.jpg">
	        		</li>
				</c:forEach>
	        	<li class="leftBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
	      </ul>
	   </div>
	   <div class="slide">
	   <h1 class="category_h1">데님팬츠</h1>
	      	<ul class="slide_list">
	      		<li class="rightBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
		        <c:forEach var="n" begin="1" end="4">
					<li class="slide_item">
	        			<img src="/mingle/img/cody/dp.jpg">
	        		</li>
				</c:forEach>
	        	<li class="leftBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
	      </ul>
	   </div>
	   <div class="slide">
	   <h1 class="category_h1">스니커즈</h1>
	      	<ul class="slide_list">
	      		<li class="rightBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
	        	<c:forEach var="n" begin="1" end="4">
					<li class="slide_item">
	        			<img src="/mingle/img/cody/snk.jpg">
	        		</li>
				</c:forEach>
	        	<li class="leftBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
	      </ul>
		</div>
	</div>
</div>
<input type="button" class="homeBtn" name="homeBtn" value="Main" onclick="location.href='/mingle'" >

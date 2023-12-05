<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/mingle/css/cody_board.css">
<script src="/mingle/js/cody_board.js"></script>
<hr>
<div style="height: 150%"></div>
<div class="codyboard_background" id="codyboard_background">
	<div class="weather">
		<span><b>오늘의 날씨</b></span>
		<div class="today" id="today">
		<h1 id="dateName"></h1>
		<a id="date"></a><br>
		<img id="weather_Icon" style="width:70px;height:70px;"/><br>
		<b><a id="min_temperature" class="min_temperature"></a><a style="color:#D8D8D8">/</a><a id="max_temperature" class="max_temperature"></a></b><br>
		<a></a>
		</div>
	</div>
	<div class="codiTap">
		<h2 style="text-align:center;"><b>추천 코디</b></h2>
		<img class="codi" src="/mingle/img/cody/2.jpg"><br>
		
		<a>무난무난하고 깔끔한 데일리 켐퍼스룩</a>
		</div>
	<div class="cody_item">
		<div class="slide">
		<h1 class="category_h1">자켓</h1>
		<div class="rightBtn"><img class="BtnImg" style="width:24px; height:24px;"></div>
	      	<ul class="slide_list">
	        	<c:forEach var="n" begin="1" end="4">
					<li class="slide_item slide_item_${n}" id="slide_item">
	        			<img src="/mingle/img/cody/jk.jpg">
	        			<a>자켓${n}</a>
	        		</li>
				</c:forEach>
				<div class="leftBtn"><img class="BtnImg" style="width:24px; height:24px;"></div>
	      </ul>
	      
	   </div>
	   <div class="slide">
	   <h1 class="category_h1">맨투맨</h1>
	   <div class="rightBtn"><img class="BtnImg" style="width:24px; height:24px;"></div>
	      	<ul class="slide_list">
	        	<c:forEach var="n" begin="1" end="4">
					<li class="slide_item">
	        			<img src="/mingle/img/cody/mtm.jpg">
	        			<a>맨투맨${n}</a>
	        		</li>
				</c:forEach>
	        	<div class="leftBtn"><img class="BtnImg" style="width:24px; height:24px;"></div>
	      </ul>
	      
	   </div>
	   <div class="slide">
	   <h1 class="category_h1">데님팬츠</h1>
	   
	   <div class="rightBtn"><img class="BtnImg" style="width:24px; height:24px;"></div>
	      	<ul class="slide_list">
		        <c:forEach var="n" begin="1" end="4">
					<li class="slide_item">
	        			<img src="/mingle/img/cody/dp.jpg">
	        			<a>데님팬츠${n}</a>
	        		</li>
				</c:forEach>
	        	<div class="leftBtn"><img class="BtnImg" style="width:24px; height:24px;"></div>
	      </ul>
	      
	   </div>
	   <div class="slide">
	   <h1 class="category_h1">스니커즈</h1>
	   <div class="rightBtn"><img class="BtnImg"  style="width:24px; height:24px;"></div>
	      	<ul class="slide_list">
	        	<c:forEach var="n" begin="1" end="4">
					<li class="slide_item">
	        			<img src="/mingle/img/cody/snk.jpg">
	        			<a>스니커즈${n}</a>
	        		</li>
				</c:forEach>
	      </ul>
	      <div class="leftBtn"><img class="BtnImg" style="width:24px; height:24px;"></div>
		</div>
	</div>
</div>
<input type="button" class="homeBtn" name="homeBtn" value="Main" onclick="location.href='/mingle'" >

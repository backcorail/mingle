<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="/mingle/css/cody/cody_board.css">
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
	<div class="leftBtn" data-btn="0"><img class="BtnImg"></div>
		<div class="slide">
		<h1 class="category_h1">자켓</h1>
	      	<div class="slide_list">
	        	<c:forEach var="n" begin="1" end="10">
					<div class="slide_item1 slide_item${n}" id="slide_item">
	        			<img class="item-img" src="/mingle/img/cody/jk.jpg">
	        			<a>자켓${n}</a>
	        		</div>
				</c:forEach>
	      </div>
	      <div class="rightBtn" data-btn="1"><img class="BtnImg"></div>
	   </div>
	   <div class="leftBtn2" data-btn="0"><img class="BtnImg"></div>
	   <div class="slide">
	   <h1 class="category_h1">맨투맨</h1>
	      	<div class="slide_list2">
	        	<c:forEach var="n" begin="1" end="10">
					<div class="slide_item2">
	        			<img class="item-img" src="/mingle/img/cody/mtm.jpg">
	        			<a>맨투맨${n}</a>
	        		</div>
				</c:forEach>
	      </div>
	      <div class="rightBtn2" data-btn="1"><img class="BtnImg"></div>
	   </div>
	   <div class="leftBtn3" data-btn="0"><img class="BtnImg"></div>
	   <div class="slide">
	   <h1 class="category_h1">데님팬츠</h1>
	      	<div class="slide_list3">
		        <c:forEach var="n" begin="1" end="10">
					<div class="slide_item3">
	        			<img class="item-img" src="/mingle/img/cody/dp.jpg">
	        			<a>데님팬츠${n}</a>
	        		</div>
				</c:forEach>
	      </div>
	      <div class="rightBtn3" data-btn="1"><img class="BtnImg" style=></div>
	   </div>
	   <div class="leftBtn4" data-btn="0"><img class="BtnImg"></div>
	   <div class="slide">
	   <h1 class="category_h1">스니커즈</h1>
	      	<div class="slide_list4">
	        	<c:forEach var="n" begin="1" end="6">
					<div class="slide_item4">
	        			<img class="item-img" src="/mingle/img/cody/snk.jpg">
	        			<a>스니커즈${n}</a>
	        		</div>
				</c:forEach>
	      </div>
	      <div class="rightBtn4" data-btn="1"><img class="BtnImg"></div>
		</div>
	</div>
</div>
<input type="button" class="homeBtn" name="homeBtn" value="Main" onclick="location.href='/mingle'" >
<script src="/mingle/js/cody/cody_board.js"></script>
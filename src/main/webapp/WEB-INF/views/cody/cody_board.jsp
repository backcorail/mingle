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
		<img class="codi" src="${imgUrl}"><br>
		
		<a><b>#${detail[0]}#${detail[1]}#${detail[2]}#${detail[3]}${gender}</b></a>
		</div>
	<div class="cody_item">
	<c:forEach varStatus="n1" items="${detail}" var="detail">
	<div class="leftBtn${n1.count}" data-btn="0"><img class="BtnImg"></div>
		<div class="slide">
		<h1 class="category_h1">${detail}</h1>
	      	<div class="slide_list${n1.count}">
	      	<c:set var="cody_boardData" value="cody_boardData${n1.count}" />
	        	<c:forEach varStatus="n" items="${requestScope[cody_boardData]}" var="data">
					<div class="slide_item${n1.count} slideex${n.count}" id="slide_item">
	        			<img class="item-img" referrerpolicy="no-referrer" src="${data.item_image}">
	        			<a>${data.item_name}</a>
	        		</div>
				</c:forEach>
	      </div>
	      <div class="rightBtn${n1.count}" data-btn="1"><img class="BtnImg"></div>
	   </div>
	   </c:forEach>
	</div>
</div>
<input type="button" class="homeBtn" name="homeBtn" value="Main" onclick="location.href='/mingle'" >
<script src="/mingle/js/cody/cody_board.js"></script>
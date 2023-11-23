<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="/mingle/css/resell_board.css">

<!-- 위쪽 부분 -->
<div class="resell_board_top">
	<div class="resell_board_img">
		<div class="resell_left_img">
			<c:forEach var="n" begin="1" end="4">
				<img src="/mingle/img/resell/sample.jpg">
			</c:forEach>
		</div>
		<div class="resell_right_img">
			<img class="main_img" src="/mingle/img/resell/sample.jpg">
			<img class="select_img" src="/mingle/img/resell/icon_heart.png">
			<img class="select_img" src="/mingle/img/resell/icon_shopBag.png">
		</div>
	</div>
	<div class="center_line"></div>
	<div class="resell_board_info">
		<ul>
			<li><h4>구매가</h4></li>
			<li><h2>50,000원</h2></li>
			<li class="blank"></li>
			<li class="resell_item_name">
				<div>물품에 대한 설명(영어)</div>
				<div>물품에 대한 설명(한글)</div>
			</li>
			<li class="blank"></li>
			<li><button class="buy_button">구매요청하기</button></li>
			<li class="blank"></li>
			<li><h2>판매 희망 지역</h2></li>
			<li><h4>(주소)</h4></li>
			<li><div class="resell_map">(맵 화면)</div></li>
		</ul>
	</div>
</div>
<div class="middle_line"></div>
<div class="resell_board_bottom">
	<div class="resell_board_bottom_img">
		<img src="/mingle/img/resell/sample.jpg">
		<img src="/mingle/img/resell/sample.jpg">
		<img src="/mingle/img/resell/sample.jpg">
	</div>
	<div class="resell_board_bottom_text">
	(여기가 물품 설명글)
	</div>
</div>

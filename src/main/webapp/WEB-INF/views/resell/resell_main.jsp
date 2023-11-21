<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="/mingle/css/resell_main.css">
<script src="/mingle/js/resell.js"></script>

	
<div class="test"></div>
<div class="test2"></div>

<!-- 위쪽 카테고리 선택부분 -->
<div>
	<ul class="resell_top">
		<li class="resell_search">
			<form>
				<input type="text" id="search_bar">
			</form>
			<img src="/mingle/img/resell/magnifier.png">
		</li>
		<li id="choose_men" class="choose"><h3>Men</h3></li>
		<li id="choose_women" class="choose"><h3>Women</h3></li>
		<li id="choose_shoes" class="choose"><h3>Shoes</h3></li>
		<li id="choose_bag" class="choose"><h3>Bag</h3></li>
		<li id="choose_other" class="choose"><h3>Other</h3></li>
	</ul>
</div>

<div class="resell_main">
<!-- 왼쪽 탭 부분 -->
	<div class="resell_left">
	
		<!-- TOP 부분 -->
		<div class="resell_left_top">
			<div class="resell_left_topic">
				<h2>TOP</h2>
				<div id="moreView1" class="moreView">...</div>
			</div>
			<ul id="category1" class="category">
				<li>맨투맨/스웨트 셔츠</li>
				<li>니트/스웨터</li>
				<li>긴소매 티셔츠</li>
				<li>카라 티셔츠</li>
				<li>반소매 티셔츠</li>
				<li>민소매 티셔츠</li>
				<li>스포츠 상의</li>
				<li>셔츤</li>
			</ul>
		</div>
		
		<!-- BOTTOM 부분 -->
		<div class="resell_left_bottom">
			<div class="resell_left_topic">
				<h2>BOTTOM</h2>
				<div id="moreView2" class="moreView">...</div>
			</div>
			<ul id="category2" class="category">
				<li>데님팬츠</li>
				<li>코튼 팬트</li>
				<li>슈트 팬츠/슬랙스</li>
				<li>트레이닝/조거 팬츠</li>
				<li>숏 팬츠</li>
				<li>스포츠 하의</li>
				<li>기타 바지</li>
				<li>점프 슈트/오버올</li>
			</ul>
		</div>
		
		<!-- OUTER 부분 -->
		<div class="resell_left_outer">
			<div class="resell_left_topic">
				<h2>OUTER</h2>
				<div id="moreView3" class="moreView">...</div>
			</div>
			<ul id="category3" class="category">
				<li>후드 집업</li>
				<li>블루종</li>
				<li>라이더 재킷</li>
				<li>트리커 재킷</li>
				<li>슈트/블레이저 재킷</li>
				<li>무스탕/퍼</li>
				<li>카디건</li>
				<li>아노락</li>
				<li>코트</li>
				<li>패딩</li>
				<li>나일론/코치 재킷</li>
			</ul>
		</div>
	</div>
	
	<!-- 리셀 부분 -->
	<div class="resell_list">
		<c:forEach var="n" begin="1" end="12">
			<div class="list_box">
				<img src="/mingle/img/resell/sample.jpg"/>
				<a href="">평상복의류(흰색)</a>
				<div class="recell_price">가격 : 50,000원</div>
				<div class="recell_time"></div>
			</div>
		</c:forEach>

		<!-- 페이지수 -->
		<div class="page_select">
			<div>◀</div>
			<div class="page_numbering">
				<c:forEach var="n" begin="1" end="5">
					<a href="" class="page_box">${n}</a>
				</c:forEach>
			</div>
			<div>▶</div>
		</div>
	</div>
</div>


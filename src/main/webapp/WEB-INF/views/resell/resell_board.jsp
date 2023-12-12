<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="authUser"/>
</sec:authorize>

<link rel="stylesheet" href="/mingle/css/resell/resell_board.css">
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@900&display=swap&family=Nanum+Pen+Script&display=swap&family=Abril+Fatface&family=Kanit:ital,wght@1,500&family=Noto+Sans+KR:wght@300" rel="stylesheet">
<script src="/mingle/js/resell/resell_board.js"></script>

<!-- 위쪽 부분 -->
<div class="search_category">
	<c:forEach var="n" items="${main}" varStatus="n0">
		<div class="category_type ${n}" id="${n0.index}">${n}</div>
	</c:forEach>
</div>
<div class="resell_board_top">
	<div class="resell_board_img">
		<div class="resell_mini_img">
			<c:forEach var="n" begin="0" end="5">
				<div id="clothes_click${n}" class="clothes_click">
					<c:if test="${n == 0}">
						<img referrerpolicy="no-referrer" src="${boardData.item_image}">
					</c:if>
					<c:if test="${n != 0}">
						<img src="/mingle/img/resell/cloth_sam${n}.jpg">
					</c:if>
				</div>
			</c:forEach>
		</div>
		<div class="resell_main_img">
			<img class="main_img" src="${boardData.item_image}">
			<img class="select_img" src="/mingle/img/resell/icon_heart.png">
			<img class="select_img" src="/mingle/img/resell/icon_shopBag.png">
		</div>
	</div>
	<div class="column_line"></div>
	<div class="resell_board_info">
		<ul>
			<li>
				<div class="purchase_price">
					<div>구매가</div>
					<c:set var="format" value="${boardData.item_price}"/>
					<fmt:formatNumber var="formatPrice" value="${format}" pattern="#,###원"/>
					<div>${formatPrice}</div>
				</div>
				<div class="modify_remove">
					<div class="board_list">목록</div>
					<c:if test="${not empty authUser}">
						<div class="board_update">수정</div>
						<div class="board_delete">삭제</div>
					</c:if>
				</div>
			</li>
			<li class="blank_line"></li>
			<li class="resell_item_name">
				<div>${boardData.item_name}</div>
				<div>${boardData.item_name}</div>
			</li>
			<li class="blank_line"></li>
			<li class="buy_button"><button>구매요청하기</button></li>
			<li class="blank_line"></li>
			<li class="blank_line"></li>
			<li class="resell_locate"><div>판매 희망 지역</div></li>
			<li class="resell_addr"><div>전라북도 익산시 익산대로 460</div></li>
			<li class="resell_map">
				<img src="/mingle/img/resell/map_sample.png">
			</li>
		</ul>
	</div>
</div>
<div class="row_line"></div>

<!-- 글 내용 부분 -->
<div class="resell_board_bottom">
	<div class="resell_board_bottom_img">
		<img src="/mingle/img/resell/sample.jpg">
		<img src="/mingle/img/resell/sample.jpg">
		<img src="/mingle/img/resell/sample.jpg">
	</div>
	<div class="resell_board_bottom_text">
	(여기가 물품 설명글)
	</div>
	<div class="row_line"></div>
</div>


<!-- 댓글 부분 -->
<div class="row_line"></div>

<div class="resell_reply">
	<div class="resell_reply_main">
		<h2>댓글 5개</h2>
		<button>댓글 작성하기</button>
	</div>
	<div class="row_line"></div>
	<ul class="resell_reply_list">
		<c:forEach var="n" begin="1" end="5">
			<li class="resell_reply_each">
				<img src="/mingle/img/resell/magnifier.png">
				<div>
					<div>brobaro</div>
					<div>
						<div>${n} - 댓글 내용입니다.</div>
						<div>2023.11.23 13:49</div>
					</div>
				</div>
			</li>
			<div class="row_line"></div>
		</c:forEach>
	</ul>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="/mingle/css/resell/resell_board.css">
<script src="/mingle/js/resell/resell_board.js"></script>

<!-- 위쪽 부분 -->
<div>
	<c:forEach var="n" items="${main}" varStatus="n0">
		<div class="category_type ${n}" id="${n0.index}">${n}</div>
	</c:forEach>
</div>
<div class="resell_board_top">
	<div class="resell_board_img">
		<div class="resell_mini_img">
			<c:forEach var="n" begin="1" end="5">
				<div id="clothes_click${n}" class="clothes_click">
					<img src="/mingle/img/resell/cloth_sam${n}.jpg">
				</div>
			</c:forEach>
		</div>
		<div class="resell_main_img">
			<img class="main_img" src="/mingle/img/resell/cloth_sam1.jpg">
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
					<div>50,000원</div>
				</div>
				<div class="modify_remove">
					<div href="/mingle/resell?page=${rVO.nowPage}<c:if test="${rVO.searchWord!=null}">&search=${rVO.searchWord}</c:if>">목록</div>
					<div>수정</div>
					<div>삭제</div>
				</div>
			</li>
			<li class="blank_line"></li>
			<li class="resell_item_name">
				<div>${rVO.item_name}</div>
				<div>${rVO.item_name}</div>
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
<!-- 
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
 -->
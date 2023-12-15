<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="authUser"/>
</sec:authorize>

<link rel="stylesheet" href="/mingle/css/resell/resell_board.css">
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@900&display=swap&family=Nanum+Pen+Script&display=swap&family=Abril+Fatface&family=Kanit:ital,wght@1,500&family=Noto+Sans+KR:wght@300" rel="stylesheet">

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=32c66affb1cc55e17a82c794a21905ab&libraries=services,clusterer,drawing"></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
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
			<c:choose>
				<c:when test="${empty imageData}">
					<!-- 이미지 데이터 없을때 -->
					<c:forEach var="n" begin="0" end="5">
						<div id="clothes_click${n}" class="clothes_click">
							<c:if test="${n == 0}">
								<img referrerpolicy="no-referrer" src="${itemData.getItem_image()}">
								<c:set var="mainImg" value="${itemData.getItem_image()}"/>
							</c:if>
							<c:if test="${n != 0}">
								<img src="/mingle/img/resell/cloth_sam${n}.jpg">
							</c:if>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<!-- 이미지 데이터 있을때 -->
					<c:forEach var="n" items="${imageData}" varStatus="num">
						<div id="clothes_click${num.index}" class="clothes_click">
							<img src="${pageContext.request.contextPath}/uploadfile/${n}">
							<c:if test="${num.index == 0}">
								<c:set var="mainImg" value="${pageContext.request.contextPath}/uploadfile/${n}"/>
							</c:if>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="resell_main_img">
			<img class="main_img" src="${mainImg}">
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
					<c:set var="format" value="${itemData.getItem_price()}"/>
					<fmt:formatNumber var="formatPrice" value="${format}" pattern="#,###원"/>
					<div>${formatPrice}</div>
				</div>
				<div class="modify_remove">
					<div class="board_list">목록</div>
					<c:if test="${authUser.userVO.user_id == boardData.resell_seller}">
						<div class="board_update">수정</div>
						<div class="board_delete">삭제</div>
					</c:if>
				</div>
			</li>
			<li class="blank_line"></li>
			<li class="resell_item_name">
				<c:if test="${boardData.getResell_name() == null}">
					<div>${itemData.getItem_name()}</div>
				</c:if>
				<c:if test="${boardData.getResell_name() != null}">
					<div>${boardData.getResell_name()}</div>
				</c:if>
				<div>${itemData.getItem_name()}</div>
			</li>
			<li class="blank_line"></li>
			<li class="seller_data">
				<div>
					<c:if test="${not empty userData.getUser_img()}">
						<img src="${userData.getUser_img()}">
					</c:if>
					<c:if test="${empty userData.getUser_img()}">
						<img src="/mingle/img/resell/profileEX.png">
					</c:if>
				</div>
				<div class="seller_nick">
					<c:if test="${not empty userData.getUser_nick()}">
						<div>판매자</div>
						<div>${userData.getUser_nick()}</div>
					</c:if>
					<c:if test="${empty userData.getUser_nick()}">
						<div>관리자</div>
						<div>admin</div>
					</c:if>
				</div>
				<div class="writedate">
					<c:if test="${not empty boardData.getResell_writedate()}">
						<div>글 작성일</div>
						<div>${boardData.getResell_writedate()}</div>
					</c:if>
					<c:if test="${empty boardData.getResell_writedate()}">
						<div>글 작성일</div>
						<div>${itemData.getItem_postdate()}</div>
					</c:if>
				</div>
			</li>
			<li class="buy_button">
				<c:choose>
					<c:when test="${empty authUser}">
						<c:set var="buy_status" value="loginNo_buy"/>
					</c:when>
					<c:when test="${boardData.getResell_buyer() == userData.getUser_id()}">
						<c:set var="buy_status" value="buyer_buy"/>
					</c:when>
					<c:when test="${not empty boardData.getResell_buyer()}">
						<c:set var="buy_status" value="exist_buy"/>
					</c:when>
					<c:otherwise>
						<c:set var="buy_status" value="loginOk_buy"/>
					</c:otherwise>
				</c:choose>
				<button id="${buy_status}">구매요청하기</button>
			</li>
			<li class="blank_line"></li>
			<li class="blank_line"></li>
			<li class="resell_locate"><div>판매 희망 지역</div></li>
			<li class="resell_addr"><div>${boardData.getResell_addr()}</div></li>
			<li class="resell_map">
				<div id="map"></div>
			</li>
		</ul>
	</div>
</div>
<div class="row_line"></div>

<!-- 글 내용 부분 -->
<div class="resell_board_bottom">
	<div>${boardData.getResell_comment()}</div>
	<div class="row_line"></div>
</div>


<!-- 댓글 부분 -->

<div class="resell_reply">
	<div class="resell_reply_main">
		<h2>구매 신청 현황</h2>
	</div>
	<div class="row_line"></div>
	<ul class="resell_reply_list">
		<li class="resell_reply_each">
			<c:choose>
				<c:when test="${empty boardData.getResell_buyer()}">
					<div>상품을 신청한 유저가 없습니다.</div>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${empty userData.getUser_img()}">
							<img src="/mingle/img/resell/profileEX.png">
							<div>
								<div>${userData.getUser_nick()}님께서 구매신청을 하였습니다.</div>
								<div>2023.12.15 13:24</div>
							</div>
						</c:when>
						<c:otherwise>
							<img src="${pageContext.request.contextPath}/uploadfile/${userData.getUser_img()}">
							<div>
								<div>${userData.getUser_nick()}님께서 구매신청을 하였습니다.</div>
								<div>2023.12.15 13:24</div>
							</div>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</li>
		<div class="row_line"></div>
	</ul>
</div>
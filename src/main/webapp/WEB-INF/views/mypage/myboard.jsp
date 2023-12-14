<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="authUser" />
</sec:authorize>
<link rel="stylesheet" href="/mingle/css/mypage/mypage_init.css">
<link rel="stylesheet" href="/mingle/css/mypage/mypage_board.css">
<main>
	<div class="container">
		<!-- side 메뉴 -->
		<%@ include file="myaside.jspf"%>
		<!-- mypage main -->
		<div class="div-mypage-main">
			<div class="Kanit-SemiBold-28">게시글</div>

			<div class="div-ub-bold">
				<div class="Kanit-Regular-25b">위치</div>
				<div>
					<div class="Kanit-Regular-25b">제목</div>
				</div>
				<div class="Kanit-Regular-25b">등록일</div>
			</div>
			<div class="div-item-list-area">
				<!-- 2 track -->
				<input id="requestno" type="hidden" value="${lastmap['리퀘스트']}">
				<input id="styleno" type="hidden" value="${lastmap['스타일']}">
				<input id="resellno" type="hidden" value="${lastmap['리셀']}">
				<!-- 맵에서 특정 키에 해당하는 값을 가져오기 -->
				
				<c:forEach var="actInfo" items="${actInfos}">
				<div class="div-track">
					<div class="div-board-cate-area">
						<div class="div-board-cate Inika-bold-18">${actInfo.type}</div>
					</div>
					<div class="div-board-title-area">
						<a href="http://localhost:9998/mingle/resell/board?no=${actInfo.no}">
						<div class="div-board-title Inika-Regular-16-l2">${actInfo.title}</div>
						</a>
					</div>
					<div class="div-board-date-area">
						<div class="div-board-date Inika-Regular-20">${actInfo.writeDate}</div>
					</div>
				</div>
				</c:forEach>
				<!-- track 끝 -->
			</div>
			<div class="div-blank-45"></div>
			<input id="btn-more-board" type="button" value="더보기" class="btn-more-data Inika-bold-20w">
			<div class="div-blank-45"></div>
		</div>
		<!-- mypage main 끝  -->
	</div>
	<!-- container -->
	<script src="/mingle/js/layout_resize.js"></script>
</main>
<script src="/mingle/js/layout_resize.js"></script>
<script src="/mingle/js/mypage/myboard.js"></script>
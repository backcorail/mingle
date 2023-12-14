<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/mingle/css/mypage/mypage_init.css">
<link rel="stylesheet" href="/mingle/css/mypage/mypage_reply.css">
<main>
	<div class="container">
		<!-- side 메뉴 -->
		<%@ include file="myaside.jspf"%>
		<!-- mypage main -->
		<div class="div-mypage-main">
			<div class="Kanit-SemiBold-28">댓글</div>

			<div class="div-ub-bold">
				<div class="Kanit-Regular-25b">위치</div>
				<div class="Kanit-Regular-25b">제목</div>
				<div class="Kanit-Regular-25b">댓글내용</div>
				<div class="Kanit-Regular-25b">등록일</div>
			</div>
			<div class="div-item-list-area">
				<!-- 1 track -->
				<div class="div-track">
					<div class="div-board-cate-area">
						<div class="div-board-cate Inika-bold-18">스타일</div>
					</div>
					<div class="div-board-title-area">
						<div class="div-board-title Inika-Regular-16-l2">Stone Island 40723 Garment Dyed Crinkle Reps Recycled Nylon Hooded Down Jacket Black - 23FW</div>
					</div>
					<div class="div-reply-content-area">
						<div class="div-reply-content Inika-Regular-20">혹시 이 제품 에누리 가능할까요??.......</div>
					</div>
					<div class="div-board-date-area">
						<div class="div-board-date Inika-Regular-20">2023.05.10</div>
					</div>
				</div>
				<!-- track 끝 -->
				<input id="requestno" type="hidden" value="${lastmap['리퀘스트']}">
				<input id="styleno" type="hidden" value="${lastmap['스타일']}">
				<!-- 2 track -->
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
					<div class="div-reply-content-area">
						<div class="div-reply-content Inika-Regular-20">${actInfo.contents}</div>
					</div>
					<div class="div-board-date-area">
						<div class="div-board-date Inika-Regular-20">${actInfo.writeDate}</div>
					</div>
				</div>
				</c:forEach>				
				<!-- track 끝 -->
			</div>
			<div class="div-blank-45"></div>
			<input id="btn-more-reply" type="button" value="더보기" class="btn-more-data Inika-bold-20w">
			<div class="div-blank-45"></div>
		</div>
		<!-- mypage main 끝  -->
	</div>
	<!-- container -->
</main>
<script src="/mingle/js/layout_resize.js"></script>
<script src="/mingle/js/mypage/myreply.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300" rel="stylesheet">
<link rel="stylesheet" href="/mingle/css/style/request_board.css">
<script src="/mingle/js/style/request_board.js"></script>

<div class="page request_board">
	<div class="top">
		<div class="content_wrapper">
				본문내용 테스트 중 ...123455
		</div>
		<div class="side_wrapper">
			<div class="profile_wrapper">
				<div class="profileImg_wrapper">
					<img src="/mingle/img/home/icon_profile.png" class="profileImg">
				</div>
				<div class="nameDate_wrapper">
					<div class="profile_nickname">web짱123</div>
					<div class="writeDate">2023-12-07</div>
				</div>
				<div class="scrap">스크랩</div>
			</div>
			<div class="title_wrapper">
				<div class="title_text">TITLE</div>
				<div class="title">'Jordan 11 Retro Gratitude' 이 제품 구해요</div>
				<c:set var="request_type" value="2" />
				<c:if test="${request_type eq 1}">
					<div class="boardType">요청</div>
				</c:if>
				<c:if test="${request_type eq 2}">
					<div class="boardType">질문</div>
				</c:if>
				</div>
		</div>
	</div>
	<div class="bottom">
		<div class="reply_wrapper">
			<div class="replyTitle">Reply</div>
			<div class="replyWrite">
					<!--<form method="post" id="replyForm">-->
						<input type="hidden" name="boardno" value="${vo.boardno }">
	           	  	    <input type="text" id="comment_input" name="coment" placeholder="댓글을 입력하세요...">
	                    <button class="btnWrite">작성</button>
	               	<!-- </form> -->
            </div>
            <ul id="replyList">
            </ul>
		</div>
		<div class="reply_area1"></div>
		<div class="reply_area2"></div>
	</div>
</div>
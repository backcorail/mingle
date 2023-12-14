<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300" rel="stylesheet">
<link rel="stylesheet" href="/mingle/css/style/request_board.css">
<script src="/mingle/js/style/request_board.js"></script>

<div class="page request_board">
	<div class="top">
		<div class="content_wrapper">
				${vo.request_comment}
		</div>
		<div class="side_wrapper">
			<div class="profile_wrapper">
				<div class="profileImg_wrapper">
					<img src="/mingle/img/home/icon_profile.png" class="profileImg">
				</div>
				<div class="nameDate_wrapper">
					<div class="profile_nickname">${vo.user_id}</div>
					<div class="writeDate">${vo.request_writedate}</div>
				</div>
				<div class="scrap">스크랩</div>
			</div>
			<div class="title_wrapper">
				<div class="title_text">TITLE</div>
				<div class="title">${vo.request_name}</div>
				<c:if test="${vo.request_type eq 1}">
					<div class="boardType">요청</div>
				</c:if>
				<c:if test="${vo.request_type eq 2}">
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
						<input type="hidden" name="boardno" value="">
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
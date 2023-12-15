<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="/mingle/css/style/Style_trendinfo.css">








<!-- 슬라이드 완료 -->
<div class="page">
	<div class="slider-container">
		<div class="slider">
			<div class="slide-show">
				<c:forEach var="asdff" items="${info.files}">
					<div class="slide">
						<div class="info-box">
							<img class="profile-img-info" src="${info.user_img}" />
							<div class="info">
								<p class="text-info">${info.user_nick}</p>
							</div>
						</div>
						<img class="img" src="/mingle/uploadfile/${asdff.style_file_name}"
							alt="Image 3" />
					</div>
				</c:forEach>
				<div class="slide">
					<div class="info-box">

						<img class="profile-img-info" src="/mingle/img/style/aaa.jpg" />

						<div class="info">
							<p class="text-info">${info.user_nick}</p>
						</div>
					</div>
					<img class="img"
						src="/mingle/uploadfile/${info.files[0].style_file_name}"
						alt="Image 3" />
				</div>
				<div class="slide">
					<div class="info-box">
						<img class="profile-img-info" src="/mingle/img/style/aaa.jpg" />
						<div class="info">
							<p class="text-info">${info.user_nick}</p>
						</div>
					</div>
					<img class="img"
						src="/mingle/uploadfile/${info.files[0].style_file_name}"
						alt="Image 3" />
				</div>
			</div>
			<button class="slide-btn" id="prevBtn">❮</button>
			<button class="slide-btn" id="nextBtn">❯</button>
			<div class="pagination"></div>
		</div>
	</div>


	<div class="tag-items">
		<div class="tag">태그상품</div>
	</div>

	<!-- 태그 상품 완료 -->
	<div class="tag-slider-container">
		<div class="tag-slider">
			<div class="tag-slide-show">
				<div class="tag-slide">
					<c:forEach begin="1" end="5">
						<div class="tag-items-infobox">
							<img class="tag-img" src="/mingle/img/style/aaa.jpg"
								alt="Image 3" />
							<div class="tag-items-info">Asics x Cecilie Bahnsen GT-2160
								White</div>
						</div>
					</c:forEach>
				</div>
				<div class="tag-slide">
					<c:forEach begin="1" end="5">
						<div class="tag-items-infobox">
							<img class="tag-img" src="/mingle/img/style/aaa.jpg"
								alt="Image 3" />
							<div class="tag-items-info">Asics x Cecilie Bahnsen GT-2160
								White</div>
						</div>
					</c:forEach>
				</div>
				<div class="tag-slide">
					<c:forEach begin="1" end="5">
						<div class="tag-items-infobox">
							<img class="tag-img" src="/mingle/img/style/aaa.jpg"
								alt="Image 3" />
							<div class="tag-items-info">Asics x Cecilie Bahnsen GT-2160
								White</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<button class="tag-slide-btn" id="tag-prevBtn">❮</button>
			<button class="tag-slide-btn" id="tag-nextBtn">❯</button>
		</div>
	</div>


	<!-- 태그 아래 완료  -->

	<div class="imote">

		<button type="button" class="reply-btn">
			<img class="reply"
				src="/mingle/img/img_mingle/page_style/icon_reply.png" />
		</button>


		<button type="button" class="heart-btn">
			<img class="heart"
				src="/mingle/img/img_mingle/page_style/icon_heart.png" />
		</button>


		<button type="button" class="scrap-btn">
			<img class="scrap"
				src="/mingle/img/img_mingle/page_style/icon_scrap.png" />
		</button>

	</div>


	<div class="like-cnt">좋아요 ${sVO.style_likes_no}개</div>

	<div class="hashtag">${info.style_name}</div>

	<div class="reply-cnt">댓글 ${info.style_reply_no}개</div>

	<div class="reply-box">
		<textarea id="commentInput" placeholder="댓글을 입력하세요..."></textarea>
		<div id="reply_btn_div">
			<button id="reply_btn">등록</button>
		</div>
		<div id="comments_box">
			<div id="comments">
				<c:forEach var="com" items="${info.comment}">
					<div class="comment">
						<img class="profile-pic" src="${com.user_img}"
							alt="User Profile Pic"> <span class="usernic">${com.user_nick}</span>
						<p class="comment-text">${com.style_reply_comment}</p>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
<input id="test3" type="hidden"
	value="${!empty authUser.userVO.user_id ? authUser.userVO.user_id : ''}">
<input id="test" type="hidden"
	value="${!empty authUser.userVO.user_img ? authUser.userVO.user_img : '/mingle/img/user/profileEX.png'}">
<input id="test2" type="hidden"
	value="${!empty authUser.userVO.user_nick ? authUser.userVO.user_nick : ''}">
<input id="test4" type="hidden" value="${info.style_no}">

<script src="/mingle/js/style_trendinfo.js"></script>
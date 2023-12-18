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
					
						<div class="tag-items-infobox">
							<img class="tag-img" src="/mingle/img/trend/zzz10.jpg"
								alt="Image 3" />
							<div class="tag-items-info">윈터 와이드 스웨트 팬츠[그레이]
								White</div>
						</div>
						<div class="tag-items-infobox">
							<img class="tag-img" src="/mingle/img/trend/zzz11.jpg"
								alt="Image 3" />
							<div class="tag-items-info">와이드 데님 팬츠[미디엄 블루]
								White</div>
						</div>
						<div class="tag-items-infobox">
							<img class="tag-img" src="/mingle/img/trend/zzz9.jpg"
								alt="Image 3" />
							<div class="tag-items-info">사계절 트레이닝 팬츠
								Gray</div>
						</div>
						<div class="tag-items-infobox">
							<img class="tag-img" src="/mingle/img/trend/zzz5.jpg"
								alt="Image 3" />
							<div class="tag-items-info">컴포터블 벌룬핏 다운 롱 패딩 블랙 COOSJP038BLACK
								</div>
						</div>
						<div class="tag-items-infobox">
							<img class="tag-img" src="/mingle/img/trend/zzz7.jpg"
								alt="Image 3" />
							<div class="tag-items-info">ORIGINAL WINTER BOOTS SHORT
								</div>
						</div>
				</div>
				<div class="tag-slide">
					
						<div class="tag-items-infobox">
							<img class="tag-img" src="/mingle/img/trend/zzz1.jpg"
								alt="Image 3" />
							<div class="tag-items-info">몬스터 다운 파카 Black
								</div>
						</div>
						<div class="tag-items-infobox">
							<img class="tag-img" src="/mingle/img/trend/zzz2.jpg"
								alt="Image 3" />
							<div class="tag-items-info">보아퍼 롱 패딩_PHD4JP2469
								</div>
						</div>
						<div class="tag-items-infobox">
							<img class="tag-img" src="/mingle/img/trend/zzz3.jpg"
								alt="Image 3" />
							<div class="tag-items-info">클럽 팀 풋볼 벤치 롱 패딩 2color
								</div>
						</div>
						<div class="tag-items-infobox">
							<img class="tag-img" src="/mingle/img/trend/zzz6.jpg"
								alt="Image 3" />
							<div class="tag-items-info">크레미니 인도어 패딩 슬리퍼 FLFDDF3U01
								</div>
						</div>
						<div class="tag-items-infobox">
							<img class="tag-img" src="/mingle/img/trend/zzz4.jpg"
								alt="Image 3" />
							<div class="tag-items-info"> [DUCK DOWN] 몬스터 롱 파카 블랙_COOSJP028BLACK
								</div>
						</div>
					
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
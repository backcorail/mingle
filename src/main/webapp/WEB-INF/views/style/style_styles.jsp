<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"></script>
<script src="/mingle/js/style_main.js"></script>
<script src="/mingle/js/style_styles.js"></script>
<link rel="stylesheet" href="/mingle/css/style/style_main.css">
<link rel="stylesheet" href="/mingle/css/style/style_ranking.css">
<link rel="stylesheet" href="/mingle/css/style/style_trendinfo.css">


<div class="page">



	<div class="all_select">

		<div class="board-wrap">
			<!-- <a class="board-name">🔥 실시간 랭킹</a> -->
			<div class="board_list_now">
				<c:forEach var="n" items="${klist}">
					<div class="board_items">
						<div class="imgdiv">
							<img class="img" src="${n.item_image}" />
						</div>
						<div class="board-content">
							<img class="profile-img" src="/mingle/img/style/aaa.jpg" /> <a
								class="username" href="">hws_10_</a>
							<button type="button" class="heart-btn">
								<img class="heart" src="/mingle/img/img_mingle/page_style/icon_heart.png" />
							</button>
							<div class="style_likes_check">${n.style_likes_check}</div>
							<a class="hashtag" href="/mingle/style/trend/info?no=${vo.item_no}">드뎌 겨울 #아우터코디 #OOTD #데일리 슈즈 #일교차패션
								#FW신발 #핫아이템</a>
						</div>
					</div>
				</c:forEach>
			</div>

			<div class="board_list_now">
				<c:forEach var="n" items="${klist}">
					<div class="board_items_hidden">
						<div class="imgdiv">
							<img class="img" src="${n.item_image}" />
						</div>
						<div class="board-content">
							<img class="profile-img" src="/mingle/img/style/aaa.jpg" /> <a
								class="username" href="">hws_10_</a>
							<button type="button" class="heart-btn">
								<img class="heart" src="/mingle/img/img_mingle/page_style/icon_heart.png" />
							</button>
							<div class="style_likes_check">${n.style_likes_check}</div>
							<div class="hashtag">드뎌 겨울 #아우터코디 #OOTD #데일리 슈즈 #일교차패션
								#FW신발 #핫아이템</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<!--  <button class ="moreview">더보기</button> -->
		</div>

	</div>
</div>

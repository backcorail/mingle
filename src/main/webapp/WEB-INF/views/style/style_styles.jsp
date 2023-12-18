<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"></script>
<script src="/mingle/js/style_main.js"></script>
<script src="/mingle/js/style_styles.js"></script>
<link rel="stylesheet" href="/mingle/css/style/style/style_main.css">
<link rel="stylesheet" href="/mingle/css/style/style_ranking.css">


<div class="page">
	<div class="all_select">

		<div class="board-wrap">
			<!-- <a class="board-name">🔥 실시간 랭킹</a> -->
			<div class="board_list_now">						
				<c:forEach var="style" items="${styles}">
					<div class="board_items" data-item-no="${style.style_no}">
						<div class="imgdiv">
							<img class="img" referrerpolicy="no-referrer"
								src="/mingle/uploadfile/${style.style_file_name}" />
						</div>
						<div class="board-content">
							<img class="profile-img" src="${style.user_img}" /> 
							<a class="username" href="">${style.user_nick}</a>

							<a href="#" class="likeLink1">
  								  <img class="like1" src="/mingle/img/img_mingle/page_recell/icon_heart.png"><span>0</span>
							</a>												
							<a class="hashtag" href="/mingle/style/trend/info/${style.style_no}">${style.style_name}</a>
							
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="board_list_now">						
				<c:forEach var="style"  begin='15' end='36' items="${styles}">
					<div class="board_items_hidden" data-item-no="${style.style_no}">
						<div class="imgdiv">
							<img class="img" referrerpolicy="no-referrer"
								src="/mingle/uploadfile/${style.style_file_name}" />
						</div>
						<div class="board-content">
							<img class="profile-img" src="${style.user_img}" /> 
							<a class="username" href="">${style.user_nick}</a>

							<a href="#" class="likeLink1">
  								  <img class="like1" src="/mingle/img/img_mingle/page_recell/icon_heart.png"><span>0</span>
							</a>												
							<a class="hashtag" href="/mingle/style/trend/info/${style.style_no}">${style.style_name}</a>
							
						</div>
					</div>
				</c:forEach>
			</div>
			<!--  <button class ="moreview">더보기</button> -->
		</div>
	</div>
</div>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="/mingle/css/style_ranking.css">
<script src="/mingle/js/style_ranking.js"></script>




<div class="page">
	<div class="all_select">
		<!-- 실시간 랭킹 -->
		<div class="board-wrap">
			<a class="board-name">🔥 실시간 랭킹</a>
			<div class="board_list_now">
				<c:forEach var="n" begin="1" end="8">
					<div class="board_items">
						<div class="imgdiv">
							<img class="img" src="/mingle/img/style/aaa.jpg" />
						</div>
						<div class="board-content">
							<img class="profile-img" src="/mingle/img/style/aaa.jpg" /> <a
								class="username" href="">hws_10_</a>
							<button class="heart">♥</button>
							<div class="hashtag">드뎌 겨울 #아우터코디 #OOTD #데일리 슈즈 #일교차패션
								#FW신발 #핫아이템</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<!-- 숨겨진 div -->

			<script>
			document.getElementById('moreview1').addEventListener('click', function() {
				  var boardListNowHidden = this.parentElement.getElementsByClassName('board_list_now_hidden')[0];
				  if (boardListNowHidden.style.display == 'none' || boardListNowHidden.style.display == '') {
				    boardListNowHidden.style.display = 'flex';
				    this.textContent = '접기';
				  } else {
				    boardListNowHidden.style.display = 'none';
				    this.textContent = '더보기';
				  }
				});
			</script>

			<div class="board_list_now_hidden">
				<c:forEach var="n" begin="1" end="8">
					<div class="board_items">
						<div class="imgdiv">
							<img class="img" src="/mingle/img/style/aaa.jpg" />
						</div>
						<div class="board-content">
							<img class="profile-img" src="/mingle/img/style/aaa.jpg" /> <a
								class="username" href="">hws_10_</a>
							<button class="heart">♥</button>
							<div class="hashtag">드뎌 겨울 #아우터코디 #OOTD #데일리 슈즈 #일교차패션
								#FW신발 #핫아이템</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<button id="moreview1">더보기</button>


		</div>

		<!-- 주간 랭킹 -->
		<div class="board-wrap">
			<a class="board-name">🗓 주간 랭킹</a>
			<div class="board_list_now">
				<c:forEach var="n" begin="1" end="8">
					<div class="board_items">
						<div class="imgdiv">
							<img class="img" src="/mingle/img/style/aaa.jpg" />
						</div>
						<div class="board-content">
							<img class="profile-img" src="/mingle/img/style/aaa.jpg" /> <a
								class="username" href="">hws_10_</a>
							<button class="heart">♥</button>
							<div class="hashtag">드뎌 겨울 #아우터코디 #OOTD #데일리 슈즈 #일교차패션
								#FW신발 #핫아이템</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<!-- 숨겨진 div -->

			<script>
			document.getElementById('moreview2').addEventListener('click', function() {
				  var boardListNowHidden = this.parentElement.getElementsByClassName('board_list_now_hidden')[0];
				  if (boardListNowHidden.style.display == 'none' || boardListNowHidden.style.display == '') {
				    boardListNowHidden.style.display = 'flex';
				    this.textContent = '접기';
				  } else {
				    boardListNowHidden.style.display = 'none';
				    this.textContent = '더보기';
				  }
				});
			</script>

			<div class="board_list_now_hidden">
				<c:forEach var="n" begin="1" end="8">
					<div class="board_items">
						<div class="imgdiv">
							<img class="img" src="/mingle/img/style/aaa.jpg" />
						</div>
						<div class="board-content">
							<img class="profile-img" src="/mingle/img/style/aaa.jpg" /> <a
								class="username" href="">hws_10_</a>
							<button class="heart">♥</button>
							<div class="hashtag">드뎌 겨울 #아우터코디 #OOTD #데일리 슈즈 #일교차패션
								#FW신발 #핫아이템</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<button id="moreview2">더보기</button>


		</div>
	</div>

	<!-- 월간 랭킹 -->
	<div class="board-wrap">
		<a class="board-name">🗓 월간 랭킹</a>
		<div class="board_list_now">
			<c:forEach var="n" begin="1" end="8">
				<div class="board_items">
					<div class="imgdiv">
						<img class="img" src="/mingle/img/style/aaa.jpg" />
					</div>
					<div class="board-content">
						<img class="profile-img" src="/mingle/img/style/aaa.jpg" /> <a
							class="username" href="">hws_10_</a>
						<button class="heart">♥</button>
						<div class="hashtag">드뎌 겨울 #아우터코디 #OOTD #데일리 슈즈 #일교차패션 #FW신발
							#핫아이템</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<button id="moreview3">더보기</button>
	</div>
</div>




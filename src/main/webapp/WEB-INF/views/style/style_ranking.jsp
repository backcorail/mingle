<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"></script>
<script src="/mingle/js/style_main.js"></script>
<script src="/mingle/js/style_ranking.js"></script>
<link rel="stylesheet" href="/mingle/css/style/style_main.css">
<link rel="stylesheet" href="/mingle/css/style/style_ranking.css">


<main class="style_main">
<div class="style_title_container">
		<h2 class="style_title">STYLE</h2>
		<!-- 제목 -->
	</div>
	<div id="style_tabs" style="width:1280px;">
		<ul class="style_tabs_list">
			<li class="tab"><a href="#tabs-1" id="ranking_tab">RANKING</a></li>
			<li class="tab"><a href="#tabs-2" id="style_tab">STYLE</a></li>
			<li class="tab"><a href="#tabs-3" id="trend_tab">TREND</a></li>
			<li class="tab"><a href="#tabs-4" id="request_tab">REQUEST</a></li>
		</ul>
		<hr class="style_header_line">
		<!-- 수평선 -->
		<hr class="style_tab_line">
		<!-- 탭의 내용을 구분하는 선 -->
		</div>

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
</main>



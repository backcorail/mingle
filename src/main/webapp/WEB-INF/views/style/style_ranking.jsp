<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="page">
	<div class="all_select"> <!-- all_select 하위 컨텐츠만 화면에 표시 -->
		<div class="ranking">
			<div class="period_rank">
				<a href="/mingle/style?tabs=1&tabs2=1" id="hot" class="period">HOT</a>
				<a href="/mingle/style?tabs=1&tabs2=2" id="daily" class="period">DAILY</a>
				<a href="/mingle/style?tabs=1&tabs2=3" id="weekly" class="period">WEEKLY</a>
				<script>
					var url = window.location.search;
					var urlParams = new URLSearchParams(url);
					var tabs2 = urlParams.get("tabs2");
					var toptitle2 = document.getElementsByClassName("top_title_2");
					switch(tabs2){
						case "1":
							toptitle2.innerText("hello");
							break;
						default;
					}
				</script>
			</div>
			<div class="text_update">UPDATE <span id="nowDate"></span></div>
			<!-- 업데이트 기준 시간 출력 -->
			<script>
				//날짜관련 변수
				let today = new Date();
				console.log(today);
				let month = today.getMonth() + 1;  // 월
				let date = today.getDate();  // 날짜
				let hours = today.getHours(); // 시
				let minutes = today.getMinutes(); //분
				if(minutes.toString().length<2){
					minutes = '0'+minutes; 
				}
				var msg = month+"."+date+" "+hours+":"+minutes+" 기준";
				console.log(msg);
				var nowDate = document.getElementById('nowDate');	
				nowDate.innerText = msg;
			</script>
		</div>
		<hr class="ranking_header_line"/>
		<div class="board-wrap">
			<div class="ranking_content">
				<div class="top">
					<div class="top_title">
						<div class="top_title_1">RANKING_HOT</div>
						<div class="top_title_2">(최근 3일 내 조회수가 가장 많은 게시물 순)</div>
					</div>
				</div>
				<div class="swiper mySwiper">
					<div class="swiper-wrapper">						
						<c:forEach var="style" begin='0' end='20' items="${styles}">
							<a class="swiper-slide" data-item-no="${style.style_no}" href="/mingle/style/trend/info/${style.style_no}">
								<img class="slider_img" src="/mingle/uploadfile/${style.style_file_name}"/>
								<div class="slider_board-content">
									<div class="slider_user">
										<img class="slider_profileImg" src="${style.user_img}" /> 
										<div class="slider_username">${style.user_nick}</div>
									</div>										
									<div class="slider_title">${style.style_name}</div>
								</div>
							</a>
							<c:if test="${style.style_no eq '1'}">
								<img class="medal gold" src="/mingle/img/style/gold.png"/>
							</c:if>
							<c:if test="${style.style_no eq '2'}">
								<img class="medal silver" src="/mingle/img/style/silver.png"/>
							</c:if>
							<c:if test="${style.style_no eq '3'}">
								<img class="medal bronze" src="/mingle/img/style/bronze.png"/>
							</c:if>
						</c:forEach>
					</div>
					<!-- If we need pagination -->
					<div class="swiper-pagination"></div>
					<!-- If we need navigation buttons -->
					<div class="swiper-button-prev"></div>
					<div class="swiper-button-next"></div>
				</div>
				<div class="left">
					<div class="left_title">
						<a class="left_title_1" href="/mingle/style?tabs=2">STYLE</a>
						<div class="left_title_2">01<span class="left_title_2_span">/3</span></div>
					</div>
				</div>
			</div>
			<hr class="ranking_middle_line"/>
			<div class="ranking_content" id="trend_rank">
				<div class="swiper mySwiper">
					<div class="swiper-wrapper">						
						<c:forEach var="style" begin='0' end='20' items="${styles}">
							<a class="swiper-slide" data-item-no="${style.style_no}" href="/mingle/style/trend/info/${style.style_no}">
								<img class="slider_img" src="/mingle/uploadfile/${style.style_file_name}"/>
								<div class="slider_board-content">
									<div class="slider_user">
										<img class="slider_profileImg" src="${style.user_img}" /> 
										<div class="slider_username">${style.user_nick}</div>
									</div>										
									<div class="slider_title">${style.style_name}</div>
								</div>
							</a>
							<c:if test="${style.style_no eq '1'}">
								<img class="medal gold" src="/mingle/img/style/gold.png"/>
							</c:if>
							<c:if test="${style.style_no eq '2'}">
								<img class="medal silver" src="/mingle/img/style/silver.png"/>
							</c:if>
							<c:if test="${style.style_no eq '3'}">
								<img class="medal bronze" src="/mingle/img/style/bronze.png"/>
							</c:if>
						</c:forEach>
					</div>
					<!-- If we need pagination -->
					<div class="swiper-pagination"></div>
					<!-- If we need navigation buttons -->
					<div class="swiper-button-prev"></div>
					<div class="swiper-button-next"></div>
				</div>
				<div class="left">
					<div class="left_title">
						<a class="left_title_1" href="/mingle/style?tabs=3">TREND</a>
						<div class="left_title_2">02<span class="left_title_2_span">/3</span></div>
					</div>
				</div>
			</div>
			<hr class="ranking_middle_line"/>
			<div class="ranking_content" id="request_rank">
				<div class="swiper mySwiper">
					<div class="swiper-wrapper">						
						<c:forEach var="style" begin='0' end='20' items="${styles}">
							<a class="swiper-slide" data-item-no="${style.style_no}" href="/mingle/style/trend/info/${style.style_no}">
								<img class="slider_img" src="/mingle/uploadfile/${style.style_file_name}"/>
								<div class="slider_board-content">
									<div class="slider_user">
										<img class="slider_profileImg" src="${style.user_img}" /> 
										<div class="slider_username">${style.user_nick}</div>
									</div>										
									<div class="slider_title">${style.style_name}</div>
								</div>
							</a>
							<c:if test="${style.style_no eq '1'}">
								<img class="medal gold" src="/mingle/img/style/gold.png"/>
							</c:if>
							<c:if test="${style.style_no eq '2'}">
								<img class="medal silver" src="/mingle/img/style/silver.png"/>
							</c:if>
							<c:if test="${style.style_no eq '3'}">
								<img class="medal bronze" src="/mingle/img/style/bronze.png"/>
							</c:if>
						</c:forEach>
					</div>
					<!-- If we need pagination -->
					<div class="swiper-pagination"></div>
					<!-- If we need navigation buttons -->
					<div class="swiper-button-prev"></div>
					<div class="swiper-button-next"></div>
				</div>
				<div class="left">
					<div class="left_title">
						<a class="left_title_1" href="/mingle/style?tabs=4">REQUEST</a>
						<div class="left_title_2">03<span class="left_title_2_span">/3</span></div>
					</div>
					<!--
					<div class="board_list_now">						
						<c:forEach var="style" begin='1' end='8' items="${styles}">
							<div class="board_items" data-item-no="${style.style_no}">
								<div class="imgdiv">
									<img class="img" src="/mingle/uploadfile/${style.style_file_name}"/>
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
					-->
				</div>
			</div>
		</div>
		<script src="/mingle/js/style_ranking.js"></script>
		<script>
			const swiper = new Swiper('.swiper', {
			  // Optional parameters
			  slidesPerView: 6,
		      freeMode: true,
			  // keyboard control
			  /*
			  keyboard: {
		        enabled: true,
		      },
			  
			  // If we need pagination
			  pagination: {
			    el: '.swiper-pagination',
			    clickable: true,
			  },
			  */
			  // Navigation arrows
			  navigation: {
			    nextEl: '.swiper-button-next',
			    prevEl: '.swiper-button-prev',
			  },
			});
		</script>
	</div>
</div>
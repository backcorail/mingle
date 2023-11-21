<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
	<link rel="stylesheet" href="/mingle/css/home.css">
	<link href="https://fonts.googleapis.com/css2?amily=Vina+Sans&display=swap&family=Poppins:ital@1&display=swap&family=Nanum+Pen+Script&display=swap&family=Kanit:ital,wght@1,500&family=DM+Sans:opsz@9..40&family=Noto+Sans+KR:wght@300" rel="stylesheet">
	<script src="./js/home.js"></script>
</head>
<div id="page_home">
	<!-- banner -->
	<div id="background_homeBanner">
		<div id="banner_body">
			<a href="#" class="photo">
			  <h1>FASHION</h1>
			    <img src="/mingle/img/home/main_banner.png"/>
			  <div class="glow-wrap">
			    <i class="glow"></i>
			  </div>
			</a>
		</div>
		<div id="text_homeBanner">Welcome to my world!!!</div>
	</div>
	<!-- main -->
	<ul id="category_homeRecell">
		<li id="men_HC">
			<a href="">
				<div class="main-content" id="main-content">
				    <div class="titleCont">
				        <h1 class="main-title" id="main-title">
				            <span>MEN</span>
				        </h1>
				    </div>
				    <canvas id="noise" class="noise"></canvas>
				  <div class="vignette"></div>
				</div>
			</a>
		</li>
		<li id="women_HC">
			<a href="">
				<div id="body_women_HC">
					<svg viewbox="0 0 100 20" id="svg_women_HC">
					  <defs>
					    <linearGradient id="gradient" x1="0" x2="0" y1="0" y2="1">
					      <stop offset="95%" stop-color="blue"/>
					      <stop offset="5%" stop-color="white"/>
					    </linearGradient>
					    <pattern id="wave" x="0" y="0" width="120" height="20" patternUnits="userSpaceOnUse">
					      <path id="wavePath" d="M-40 9 Q-30 7 -20 9 T0 9 T20 9 T40 9 T60 9 T80 9 T100 9 T120 9 V20 H-40z" mask="url(#mask)" fill="url(#gradient)"> 
					        <animateTransform
					            attributeName="transform"
					            begin="0s"
					            dur="1.5s"
					            type="translate"
					            from="0,0"
					            to="40,0"
					            repeatCount="indefinite" />
					      </path>
					    </pattern>
					  </defs>
					  <text text-anchor="middle" x="50" y="15" font-size="17" fill="url(#wave)"  fill-opacity="0.6">WOMEN</text>
					  <text text-anchor="middle" x="50" y="15" font-size="17" fill="url(#gradient)" fill-opacity="0.1">WOMEN</text>
					</svg>
				</div>
			</a>
		</li>
		<li id="shoes_HC">
			<div id="body_shoes_HC">
				<span>S</span><span>H</span><span>O</span><span>E</span><span>S</span>
			</div>
		</li>
		<li id="bag_HC">Bag</li>
		<li id="other_HC">Other</li>
	</ul>
	<div id="homeContent">
		<div class="area_homeContent">
			<div class="area_ListContent">
				<div class="homeTitle">Recell items</div> 
				<div class="homeSubtitle">리셀 상품</div>
				<!-- List -->
				<div id="area_List_home">
					<div class="homePost_recell">
						<a href="">
							<img src="" class="homePostImg_recell"/>
							<div class="homePostTitle_recell">불꽃 핫바지 조거 트레이닝 팬츠</div>
							<div class="textBottom_homePost">
								<div class="homePostPrice_recell">25000</div>
								<div class="homePostTime_recell">2023.05.10</div>
							</div>
						</a>
					</div>
					<div class="homePost_recell">
						<a href="">
							<img src="" class="homePostImg_recell"/>
							<div class="homePostTitle_recell">불꽃 핫바지 조거 트레이닝 팬츠</div>
							<div class="textBottom_homePost">
								<div class="homePostPrice_recell">25000</div>
								<div class="homePostTime_recell">2023.05.10</div>
							</div>
						</a>
					</div>
					<div class="homePost_recell">
						<a href="">
							<img src="" class="homePostImg_recell"/>
							<div class="homePostTitle_recell">불꽃 핫바지 조거 트레이닝 팬츠</div>
							<div class="textBottom_homePost">
								<div class="homePostPrice_recell">25000</div>
								<div class="homePostTime_recell">2023.05.10</div>
							</div>
						</a>
					</div>
					<div class="homePost_recell">
						<a href="">
							<img src="" class="homePostImg_recell"/>
							<div class="homePostTitle_recell">불꽃 핫바지 조거 트레이닝 팬츠</div>
							<div class="textBottom_homePost">
								<div class="homePostPrice_recell">25000</div>
								<div class="homePostTime_recell">2023.05.10</div>
							</div>
						</a>
					</div>
					<div class="homePost_recell">
						<a href="">
							<img src="" class="homePostImg_recell"/>
							<div class="homePostTitle_recell">불꽃 핫바지 조거 트레이닝 팬츠</div>
							<div class="textBottom_homePost">
								<div class="homePostPrice_recell">25000</div>
								<div class="homePostTime_recell">2023.05.10</div>
							</div>
						</a>
					</div>
				</div>
				<a href="#" class="homeMore">더보기</a>
			</div>
			<div class="area_advContnet" id="adv_cody">
				<div class="topArea_adv"><img src="/mingle/img/home/main_banner_cody.jpg" id="bannerImg_cody"/></div>
				<div class="bottomArea_adv">
					<div id="homeContentTitle_cody">오늘 뭐 입지 고민될때?</div>
					<a href="#" id="homeContentLink_cody">옷 추천받기</a> 
				</div>
			</div>
		</div>
		<div class="area_homeContent">
			<div class="area_ListContent">
				<div class="homeTitle">Daily style</div>
				<div class="homeSubtitle"">#일주일 코디 배틀</div>
				<div id="homePost_style">
					<div class="homePostImg_style">
						<img src="/mingle/img/home/img_homeList_style.jpg"/>
						<div class="onContent_img">
							<img src="/mingle/img/home/icon_profile.png" class="homePostImg_profile_style"/>
							<div class="homePostImg_userid_style">@d3fi5g</div>
						</div>
					</div>
					<div class="homePostImg_style">
						<img src="/mingle/img/home/img_homeList_style.jpg"/>
						<div class="onContent_img">
							<img src="/mingle/img/home/icon_profile.png" class="homePostImg_profile_style"/>
							<div class="homePostImg_userid_style">@d3fi5g</div>
						</div>
					</div>
					<div class="homePostImg_style">
						<img src="/mingle/img/home/img_homeList_style.jpg"/>
						<div class="onContent_img">
							<img src="/mingle/img/home/icon_profile.png" class="homePostImg_profile_style"/>
							<div class="homePostImg_userid_style">@d3fi5g</div>
						</div>
					</div>
					<div class="homePostImg_style">
						<img src="/mingle/img/home/img_homeList_style.jpg"/>
						<div class="onContent_img">
							<img src="/mingle/img/home/icon_profile.png" class="homePostImg_profile_style"/>
							<div class="homePostImg_userid_style">@d3fi5g</div>
						</div>
					</div>
					<div class="homePostImg_style">
						<img src="/mingle/img/home/img_homeList_style.jpg"/>
						<div class="onContent_img">
							<img src="/mingle/img/home/icon_profile.png" class="homePostImg_profile_style"/>
							<div class="homePostImg_userid_style">@d3fi5g</div>
						</div>
					</div>
					<div class="homePostImg_style">
						<img src="/mingle/img/home/img_homeList_style.jpg"/>
						<div class="onContent_img">
							<img src="/mingle/img/home/icon_profile.png" class="homePostImg_profile_style"/>
							<div class="homePostImg_userid_style">@d3fi5g</div>
						</div>
					</div>
					
				</div>
				<a href="#" class="homeMore">더보기</a>
			</div>
			<div class="area_advContnet" id="adv_style">
				<div class="topArea_adv"><img src="/mingle/img/home/banner_style_3.jpg" id="bannerImg_style"/></div>
				<div class="bottomArea_adv">
					<div id="homeContentTitle_style">트렌디한 힙합 패션 정보는?</div>
					<a href="#" id="homeContentLink_style">STYLE 바로가기</a> 
				</div>
			</div>
		</div>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
	<link rel="stylesheet" href="/mingle/css/home/home.css">
	<link href="https://fonts.googleapis.com/css2?family=Shadows+Into+Light&display=swap&family=Abril+Fatface&family=Shadows+Into+Light&display=swap&family=Lobster&display=swap&family=Montserrat:wght@700&display=swap&family=Montserrat&display=swap&family=Vina+Sans&display=swap&family=Poppins:ital@1&display=swap&family=Nanum+Pen+Script&display=swap&family=Kanit:ital,wght@1,500&family=DM+Sans:opsz@9..40&family=Noto+Sans+KR:wght@300" rel="stylesheet">
	<script src="/mingle/js/home.js"></script>
</head>
<div id="page_home">
	<!-- banner -->
	<div id="background_homeBanner">
		<div id="banner_body">
			<a href="#" class="photo">
			  <img src="/mingle/img/home/main_banner.png"/>
			  <div class="glow-wrap">
			    <i class="glow"></i>
			  </div>
			  <div></div>
			</a>
		</div>
		<div id="text_homeBanner">Welcome to my world!!!</div>
	</div>
	<!-- main -->
	<!-- category -->
	<ul id="category_homeresell">
	<!-- men category -->
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
	<!-- women category -->
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
					      <path id="wavePath" d="M-700 100 Q-30 7 -20 9 T0 9 T20 9 T40 9 T60 9 T80 9 T100 9 T120 9 V20 H-40z" mask="url(#mask)" fill="url(#gradient)"> 
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
	<!-- bag category -->
		<li id="bag_HC">
			<a href="">
				<h1 id="h1_bag_HC"><span>B</span><span>A</span><span>G</span></h1>
			</a>
		</li>
	<!-- shoes category -->
		<li id="shoes_HC">
			<a href="">
				<div id="body_shoes_HC">
					<div class="container">
					  <svg viewBox="0 0 960 300">
					    <symbol id="s-text">
					      <text text-anchor="middle" x="50%" y="80%">SHOES</text>
					    </symbol>
					    <g class = "g-ants">
					      <use xlink:href="#s-text" class="text-copy"></use>
					      <use xlink:href="#s-text" class="text-copy"></use>
					      <use xlink:href="#s-text" class="text-copy"></use>
					      <use xlink:href="#s-text" class="text-copy"></use>
					      <use xlink:href="#s-text" class="text-copy"></use>
					    </g>
					  </svg>
					</div>
				</div>
			</a>
		</li>
	<!-- other category -->
		<li id="other_HC">
			<section class='section'>
			    <div class='masthead-image' id='master-container'>
			        <div class='content center'>
			            <h1 id='master'>
			              <div>How about</div>
			              <div id='master-container-scroller'>
			                <div class='master-container-scroller_item'>
			                  <a class='cta-link' href='#'>CAP</a>.
			                </div>
			                <div class='master-container-scroller_item'>
			                  <a class='cta-link' href='#'>Fedora</a>.
			                </div>
			                <div class='master-container-scroller_item'>
			                  <a class='cta-link' href='#'>Gloves</a>.
			                </div>
			                <div class='master-container-scroller_item'>
			                  <a class='cta-link' href='#'>Scarf</a>.
			                </div>
			                <div class='master-container-scroller_item'>
			                  <a class='cta-link' href='#'>Watch</a>.
			                </div>
			                <div class='master-container-scroller_item'>
			                  <a class='cta-link' href='#'>Necklace</a>.
			                </div>
			                <div class='master-container-scroller_item'>
			                  <a class='cta-link' href='#'>Ring</a>.
			                </div>
			                <div class='master-container-scroller_item'>
			                  <a class='cta-link' href='#'>Bracelet</a>.
			                </div>
			                <div class='master-container-scroller_item'>
			                  <a class='cta-link' href='#'>Mask</a>.
			                </div>
			                <div class='master-container-scroller_item'>Trooper.</div>
			              </div>
			              <div>Today?</div>
			            </h1>
			        </div>
			    </div>
			</section>
		</li>
	</ul>
	<!-- main content -->
	<div id="homeContent">
	<!-- top content -->
		<div class="area_homeContent">
	<!-- list content -->
			<div class="area_ListContent">
				<div class="homeTitle">Resell items</div> 
				<div class="homeSubtitle">리셀 상품</div>
				<!-- List -->
				<div id="area_List_home">
					<div class="homePost_resell">
						<a href="">
							<img src="" class="homePostImg_resell"/>
							<div class="homePostTitle_resell">불꽃 핫바지 조거 트레이닝 팬츠</div>
							<div class="textBottom_homePost">
								<div class="homePostPrice_resell">25000</div>
								<div class="homePostTime_resell">2023.05.10</div>
							</div>
						</a>
					</div>
					<div class="homePost_resell">
						<a href="">
							<img src="" class="homePostImg_resell"/>
							<div class="homePostTitle_resell">불꽃 핫바지 조거 트레이닝 팬츠</div>
							<div class="textBottom_homePost">
								<div class="homePostPrice_resell">25000</div>
								<div class="homePostTime_resell">2023.05.10</div>
							</div>
						</a>
					</div>
					<div class="homePost_resell">
						<a href="">
							<img src="" class="homePostImg_resell"/>
							<div class="homePostTitle_resell">불꽃 핫바지 조거 트레이닝 팬츠</div>
							<div class="textBottom_homePost">
								<div class="homePostPrice_resell">25000</div>
								<div class="homePostTime_resell">2023.05.10</div>
							</div>
						</a>
					</div>
					<div class="homePost_resell">
						<a href="">
							<img src="" class="homePostImg_resell"/>
							<div class="homePostTitle_resell">불꽃 핫바지 조거 트레이닝 팬츠</div>
							<div class="textBottom_homePost">
								<div class="homePostPrice_resell">25000</div>
								<div class="homePostTime_resell">2023.05.10</div>
							</div>
						</a>
					</div>
					<div class="homePost_resell">
						<a href="">
							<img src="" class="homePostImg_resell"/>
							<div class="homePostTitle_resell">불꽃 핫바지 조거 트레이닝 팬츠</div>
							<div class="textBottom_homePost">
								<div class="homePostPrice_resell">25000</div>
								<div class="homePostTime_resell">2023.05.10</div>
							</div>
						</a>
					</div>
				</div>
				<a href="#" class="homeMore">
					<div class="buttons">
					    <button class="btn-hover color-8">more</button>
					</div>
				</a>
			</div>
	<!-- adv contnet -->
			<div class="area_advContnet" id="adv_cody">
				<div class="topArea_adv"><img src="/mingle/img/home/main_banner_cody.jpg" id="bannerImg_cody"/></div>
				<div class="bottomArea_adv">
					<div id="homeContentTitle_cody">
						<link href="https://fonts.googleapis.com/css?family=Mr+Dafoe" rel="stylesheet">
						<div class="shadow">"What should i wear today?"</div>
					</div>
					<div class="adv_homeLink">
						<div class="row columns">
					      <ul class="menu align-center expanded text-center SMN_effect-11">
					        <li><a href="" data-hover="cody next>"><span id="homeContentLink_cody">cody next></span></a></li>
					      </ul>
					    </div>
					</div> 
				</div>
			</div>
		</div>
	<!-- bottom content -->
		<div class="area_homeContent">
	<!-- list contnet -->
			<div class="area_ListContent">
				<div class="homeTitle">Daily style</div>
				<div class="homeSubtitle"">#일주일 코디 배틀</div>
				<div id="homePost_style">
					<div class="homePostImg_style">
						<a href="">
							<img src="/mingle/img/home/img_homeList_style.jpg"/>
							<div class="onContent_img">
								<img src="/mingle/img/home/icon_profile.png" class="homePostImg_profile_style"/>
								<div class="homePostImg_userid_style">@d3fi5g</div>
							</div>
						</a>
					</div>
					<div class="homePostImg_style">
						<a href="">
							<img src="/mingle/img/home/img_homeList_style.jpg"/>
							<div class="onContent_img">
								<img src="/mingle/img/home/icon_profile.png" class="homePostImg_profile_style"/>
								<div class="homePostImg_userid_style">@d3fi5g</div>
							</div>
						</a>
					</div>
					<div class="homePostImg_style">
						<a href="">
							<img src="/mingle/img/home/img_homeList_style.jpg"/>
							<div class="onContent_img">
								<img src="/mingle/img/home/icon_profile.png" class="homePostImg_profile_style"/>
								<div class="homePostImg_userid_style">@d3fi5g</div>
							</div>
						</a>
					</div>
					<div class="homePostImg_style">
						<a href="">
							<img src="/mingle/img/home/img_homeList_style.jpg"/>
							<div class="onContent_img">
								<img src="/mingle/img/home/icon_profile.png" class="homePostImg_profile_style"/>
								<div class="homePostImg_userid_style">@d3fi5g</div>
							</div>
						</a>
					</div>
					<div class="homePostImg_style">
						<a href="">
							<img src="/mingle/img/home/img_homeList_style.jpg"/>
							<div class="onContent_img">
								<img src="/mingle/img/home/icon_profile.png" class="homePostImg_profile_style"/>
								<div class="homePostImg_userid_style">@d3fi5g</div>
							</div>
						</a>
					</div>
					<div class="homePostImg_style">
						<a href="">
							<img src="/mingle/img/home/img_homeList_style.jpg"/>
							<div class="onContent_img">
								<img src="/mingle/img/home/icon_profile.png" class="homePostImg_profile_style"/>
								<div class="homePostImg_userid_style">@d3fi5g</div>
							</div>
						</a>
					</div>
					
				</div>
				<a href="#" class="homeMore">
					<div class="buttons">
					    <button class="btn-hover color-8">more</button>
					</div>
				</a>
			</div>
	<!--
			<hr style="width:1340px;">
		
	<div id="area_homeStyle">
		<div id="leftArea_homeStyle">
			<video src="/mingle/img/home/style_bg.mp4" muted autoplay loop></video>
			<div>비오는 날씨에 입기좋은 나일론 팬츠 스타일링 보러가기</div>
		</div>
		<div id="rightArea_homeStyle">
		</div>
	</div>
	-->
	<!-- adv contnet -->
			<div id="advStyle_body">
				<div id="advStyle">
					<div id="advStyle_TEXT" data-text="TAKE IT TO">TAKE<span>IT</span><span>TO</span><br><span>THE</span><span>NEXT</span><span>LEVEL</span></div>
					<div id="adv_homeLink_style">
						<div class="row columns">
					      <ul class="menu align-center expanded text-center SMN_effect-11">
					        <li><a href="" data-hover="style next>"><span id="homeContentLink_style">style next></span></a></li>
					      </ul>
					    </div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
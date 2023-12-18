<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript" src="/mingle/js/resell/resell_main.js"></script>
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
			<a href="/mingle/resell?page=1&category=1">
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
			<a href="/mingle/resell?page=1&category=2">
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
			<a href="/mingle/resell?page=1&detail=500">
				<h1 id="h1_bag_HC"><span>B</span><span>A</span><span>G</span></h1>
			</a>
		</li>
	<!-- shoes category -->
		<li id="shoes_HC">
			<a href="/mingle/resell?page=1&detail=400">
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
			                  <a class='cta-link' href='/mingle/resell?page=1&category=3'>CAP</a>.
			                </div>
			                <div class='master-container-scroller_item'>
			                  <a class='cta-link' href='/mingle/resell?page=1&category=3'>Fedora</a>.
			                </div>
			                <div class='master-container-scroller_item'>
			                  <a class='cta-link' href='/mingle/resell?page=1&category=3'>Gloves</a>.
			                </div>
			                <div class='master-container-scroller_item'>
			                  <a class='cta-link' href='/mingle/resell?page=1&category=3'>Scarf</a>.
			                </div>
			                <div class='master-container-scroller_item'>
			                  <a class='cta-link' href='/mingle/resell?page=1&category=3'>Watch</a>.
			                </div>
			                <div class='master-container-scroller_item'>
			                  <a class='cta-link' href='/mingle/resell?page=1&category=3'>Necklace</a>.
			                </div>
			                <div class='master-container-scroller_item'>
			                  <a class='cta-link' href='/mingle/resell?page=1&category=3'>Ring</a>.
			                </div>
			                <div class='master-container-scroller_item'>
			                  <a class='cta-link' href='/mingle/resell?page=1&category=3'>Bracelet</a>.
			                </div>
			                <div class='master-container-scroller_item'>
			                  <a class='cta-link' href='/mingle/resell?page=1&category=3'>Mask</a>.
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
					<c:forEach var="vo" items="${kreamList}">
						<div class="homePost_resell">
							<a href="/mingle/resell/board?no=${vo.item_no}">
								<c:choose>
									<c:when test="${empty vo.item_image}">	
										<c:set var="firstImg" value="${pageContext.request.contextPath}/uploadfile/${vo.item_file_name}"/>
									</c:when>
									<c:otherwise>
										<c:set var="firstImg" value="${vo.item_image}"/>
									</c:otherwise>
								</c:choose>
								<img src="${firstImg}" class="homePostImg_resell"/>
								<div class="homePostTitle_resell">${vo.item_name}</div>
								<div class="textBottom_homePost">
									<c:set var="format" value="${vo.item_price}"/>
									<fmt:formatNumber var="formatPrice" value="${format}" pattern="#,###원"/>
									<div class="homePostPrice_resell">${formatPrice}</div>
									<div class="homePostTime_resell"><script>document.write(timeDiff('${vo.item_postdate}'));</script></div>
								</div>
							</a>
						</div>
					</c:forEach>
				</div>
				<a href="/mingle/resell" class="homeMore">
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
					        	<li>
					        		<c:if test="${empty authUser}"> 
	 									<a href="javascript:goLogin()" data-hover="cody next>">
						        			<span id="homeContentLink_cody">cody next></span>
						        		</a>
	 								</c:if>
					        		<c:if test="${not empty authUser}"> 
					        			<a href="/mingle/cody" data-hover="cody next>">
						        			<span id="homeContentLink_cody">cody next></span>
						        		</a>
					        		</c:if>
					        	</li>
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
					<c:forEach var="style" items="${styles}">
						<div class="homePostImg_style">
							<a href="/mingle/style/trend/info/${style.style_no}">
								<img src="/mingle/uploadfile/${style.style_file_name}"/>
								<div class="onContent_img">
									<img src="${style.user_img}" class="homePostImg_profile_style"/>
									<div class="homePostImg_userid_style">@${style.user_nick}</div>
								</div>
							</a>
						</div>
					</c:forEach>
					
				</div>
				<a href="/mingle/style?tabs=1" class="homeMore">
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
					        <li><a href="/mingle/style?tabs=1" data-hover="style next>"><span id="homeContentLink_style">style next></span></a></li>
					      </ul>
					    </div>
					</div>
				</div>
			</div>
			<c:if test="${authUser!=''}">
				<div><a href="/mingle/style/request/write">글쓰기</a></div>
			</c:if>
		</div>
	</div>
</div>
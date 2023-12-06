<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/mingle/css/style/style_write.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
<script src="/mingle/js/style/style_write.js"></script>

<div class="page_style">
	<!-- 글제목 -->
	<div class="styleWrite_title">
		STYLE 작성페이지
		<div class="styleWrite_subtitle">형식에 맞게 입력해주세요.</div>
	</div>
	<!-- 글 종류 선택 -->
	<div class="writeType_select">
		<div class="resell"><a href="/mingle/resell/write" class="writeType_link">RESELL</a></div>
		<div class="request"><a href="/mingle/style/requestwrite" class="writeType_link">REQUEST</a></div>
		<div class="style"><a href="/mingle/style/write" class="writeType_link">STYLE</a></div>
	</div>
	<form method="post" action="${pageContext.servletContext.contextPath}/style/writeOk" id="frm" class="styleWrite" onsubmit="return validateForm()" enctype="multipart/form-data">
		<div class="styleWrite_wrapper">
			<!-- 헤더 -->
			<div class="header_style">
				<div class="profileImg_wrapper">
					<img src="" id="profileImg">
				</div>
				<div class="user_wrapper">
					<div id="username">username</div>
					<div id="datetime">10일전</div>
				</div>
			</div>
			<div class="middle">
				<input type="file" class="real-upload" accept="image/*" required multiple>
				<div class="swiper mySwiper">
				    <div class="swiper-wrapper"></div>
				    <div class="swiper-button-next"></div>
					<div class="swiper-button-prev"></div>
					<div class="swiper-pagination"></div>
			    </div>
		  	</div>
		  	<!-- 이미지 업로드 버튼 -->
		  	
		  	<a href="#" class="buttonu type--A upload">
		  		<div class="buttonu__line"></div>
			    <div class="buttonu__line"></div>
			    <span class="buttonu__text">image upload</span>
			    <div class="buttonu__drow1"></div>
			  	<div class="buttonu__drow2"></div>
			</a>
		  	<div class="footer_style">
			  	<div class="tag-items">
				<div class="tag">태그상품</div>
				</div>
			  	<!-- 태그 상품 완료 -->
				<div class="tag-slider-container">
					<div class="tag-slider">
						<div class="tag-slide-show">
							<div class="tag-slide">
								<div class="tag-items-infobox">
									<img class="tag-img" src="/mingle/img/style/aaa.jpg" alt="Image 3" />
									<div class="tag-items-info">Asics x Cecilie Bahnsen GT-2160
										White</div>
								</div>
								<div class="tag-items-infobox">
									<img class="tag-img" src="/mingle/img/style/aaa.jpg" alt="Image 3" />
									<div class="tag-items-info">Asics x Cecilie Bahnsen GT-2160
										White</div>
								</div>
								<div class="tag-items-infobox">
									<img class="tag-img" src="/mingle/img/style/aaa.jpg" alt="Image 3" />
									<div class="tag-items-info">Asics x Cecilie Bahnsen GT-2160
										White</div>
								</div>
								<div class="tag-items-infobox">
									<img class="tag-img" src="/mingle/img/style/aaa.jpg" alt="Image 3" />
									<div class="tag-items-info">Asics x Cecilie Bahnsen GT-2160
										White</div>
								</div>
								<div class="tag-items-infobox">
									<img class="tag-img" src="/mingle/img/style/aaa.jpg" alt="Image 3" />
									<div class="tag-items-info">Asics x Cecilie Bahnsen GT-2160
										White</div>
								</div>
							</div>
							<div class="tag-slide">
								<div class="tag-items-infobox">
									<img class="tag-img" src="/mingle/img/style/aaa.jpg" alt="Image 3" />
									<div class="tag-items-info">Asics x Cecilie Bahnsen GT-2160
										White</div>
								</div>
								<div class="tag-items-infobox">
									<img class="tag-img" src="/mingle/img/style/aaa.jpg" alt="Image 3" />
									<div class="tag-items-info">Asics x Cecilie Bahnsen GT-2160
										White</div>
								</div>
								<div class="tag-items-infobox">
									<img class="tag-img" src="/mingle/img/style/aaa.jpg" alt="Image 3" />
									<div class="tag-items-info">Asics x Cecilie Bahnsen GT-2160
										White</div>
								</div>
								<div class="tag-items-infobox">
									<img class="tag-img" src="/mingle/img/style/aaa.jpg" alt="Image 3" />
									<div class="tag-items-info">Asics x Cecilie Bahnsen GT-2160
										White</div>
								</div>
								<div class="tag-items-infobox">
									<img class="tag-img" src="/mingle/img/style/aaa.jpg" alt="Image 3" />
									<div class="tag-items-info">Asics x Cecilie Bahnsen GT-2160
										White</div>
								</div>
							</div>
							
						</div>
						<button type="button" class="tag-slide-btn" id="tag-prevBtn">❮</button>
						<button type="button" class="tag-slide-btn" id="tag-nextBtn">❯</button>
					</div>
				</div>
				<!-- 글제목 작성 -->
				<div class="style_title">
					<div class="style_title_subject">글 제목을 입력하세요.</div>
					<textarea class="style_title_text" id="style_subject" name="subject"></textarea>
				</div>
		  	</div>
		  	<!-- 작성,취소 버튼 -->
			<div class="pushBack_box">
			    <input type="submit" title="Button push blue/green" class="button btnPush btnBlueGreen" value="PUSH" onsubmit="return validateForm()">
			    <input type="button" title="Button push lightblue" class="button btnPush btnLightBlue" value="BACK" onclick="history.back()">
		    	<div class="clear"></div>
			</div>
		</div>
		<!-- Swiper JS -->
		<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
		<script src="/mingle/js/style/style_write_slider.js"></script>
	</form>
</div>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/mingle/css/style/style_write.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />

<!-- 글제목 -->
<div class="styleWrite_title">
	STYLE 작성페이지
	<div class="styleWrite_subtitle">형식에 맞게 입력해주세요.</div>
</div>
<div class="styleWrite">
	<div class="styleWrite_wrapper">
		<!-- 헤더 -->
		<div class="header">
			<div class="profileImg_wrapper">
				<img src="" id="profileImg">
			</div>
			<div class="user_wrapper">
				<div id="username">username</div>
				<div id="datetime">10일전</div>
			</div>
		</div>
		<div class="middle">
			<div class="imgUpload upload">
				<input type="file" class="real-upload" accept="image/*" required multiple>
				<ul class="image_preview">상단 노출 제품 관련 이미지를 선택해주세요.</ul>
			</div>
			<button class="slide-btn" id="prevBtn">❮</button>
			<button class="slide-btn" id="nextBtn">❯</button>
			<div class="pagination"></div>
	  	</div>
	  	<script src="/mingle/js/style/style_write_slider.js"></script>
	</div>
</div>
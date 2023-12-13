<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://kit.fontawesome.com/7b899d6a28.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/mingle/css/user/loginForm.css">
<link rel="stylesheet" href="/mingle/css/user/fp_Form.css">
<link rel="stylesheet" href="/mingle/css/user/fi_Form.css">
<link rel="stylesheet" href="/mingle/css/user/joinForm.css">
<main>
	<div class="container">
		<!-- 로그인폼 시작 -->
		<div class="div-main-form div-main-lg">
			<div class="blank-102"></div>
			<div class="div-logo">mingle</div>
			<div class="blank-22"></div>
			<div class="div-tile-desc">Mixing various fashions into one</div>
			<!-- 아이디 비밀번호 -->
			<div class="blank-20"></div>
			<!-- <form method="POST" action="/migle/user/loginProc"> -->
			<div class="div-login-outline">
				<div class="div-id-text">아이디</div>
				<input id="adminid" name="adminid" type="text" class="in-txt" placeholder="예)asdf12345">
				<div class="blank-20"></div>
				<div class="div-pwd-text">비밀번호</div>
				<input id="adminpwd" name="adminpwd" type="password" class="in-txt" placeholder="예)qwert0987654">
			</div>
			<!-- 로그인 버튼 -->
			<div class="div-020"></div>
			<input id="btn-admin-login" class="btn-login" type="button" value="로그인">
			<!-- </form> -->
			<div class="blank-56"></div>
		</div>
		<!-- 로그인 폼 끝 -->
</main>
<script src="/mingle/js/layout_resize.js"></script>
<script src="/mingle/js/admin/adminjoin.js"></script>
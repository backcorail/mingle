<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="/mingle/css/admin_main.css">
<script src="<c:url value='/js/admin_main.js'/>"></script>

<div class="all_select">
	<!-- 회원 관리 섹션 -->
	<div class="management_section" id="members_management">
		<h2>회원 관리</h2>
		<div class="management_list">
			<!-- 리스트 헤더 -->
			<div class="list_header">
				<ul>
					<li>아이디</li>
					<li>비밀번호</li>
					<li>이름</li>
					<li>닉네임</li>
					<li>전화번호</li>
					<li>주소</li>
					<li>프로필 이미지</li>
				</ul>
			</div>

			<!-- 리스트 아이템 -->
			<c:forEach var="user" begin="1" end="8">
				<div class="list_item">
					<ul>
						<li>user1</li>
						<li>password1</li>
						<li>홍길동</li>
						<li>gildong</li>
						<li>010-1234-5678</li>
						<li>서울시 어딘가</li>
						<li>이미지</li>
					</ul>
				</div>
			</c:forEach>
		</div>
	</div>
</div>

<!-- ... 다른 섹션들 ... -->
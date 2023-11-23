<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="/mingle/css/admin_main.css">
<script src="<c:url value='/js/admin_main.js'/>"></script>

<div class="admin-container">
	<aside class="sidebar">
		<!-- Sidebar 메뉴 -->
		<ul class="sidebar-menu">
			<li><a href="#">관리자 페이지</a></li>

			<li><a href="#">회원 관리</a>
				<ul class="submenu">
					<li><a href="#">회원 데이터</a></li>
				</ul></li>

			<li><a href="#">상품 관리</a>
				<ul class="submenu">
					<li><a href="#">카테고리별 상품수</a></li>
					<li><a href="#">상품 강제 삭제</a></li>
				</ul></li>

			<li><a href="#">거래 관리</a>
				<ul class="submenu">
					<li><a href="#">거래 내역 확인</a></li>
					<li><a href="#">거래 강제 삭제</a></li>
				</ul></li>

			<li><a href="#">커뮤니티 관리</a>
				<ul class="submenu">
					<li><a href="#">게시글 내역 확인</a></li>
					<li><a href="#">게시글 강제 삭제</a></li>
				</ul></li>

			<li><a href="#">관리자 추천 코디</a>
				<ul class="submenu">
					<li><a href="#">다수의 아이템 동시 적용</a></li>
					<li><a href="#">관리자 적용 글 작성 페이지</a></li>
					<li><a href="#">코디 추천 기록 조회</a></li>
				</ul></li>

			<li><a href="#">관리자 권한 설정</a>
				<ul class="submenu">
					<li><a href="#">권한 지정</a></li>
				</ul></li>
		</ul>
	</aside>
	<main class="main-content">
		<!-- 회원 관리 섹션 -->
		<div class="management-section">
			<h2>회원 관리</h2>
			<div class="management-list">
				<!-- 리스트 헤더 -->
				<div class="list-header">
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
				<c:forEach items="${userList}" var="user">
					<div class="list-item">
						<ul>
							<li><c:out value="${user.id}" /></li>
							<li><c:out value="${user.password}" /></li>
							<li><c:out value="${user.name}" /></li>
							<li><c:out value="${user.nickname}" /></li>
							<li><c:out value="${user.phone}" /></li>
							<li><c:out value="${user.address}" /></li>
							<li><img src="<c:out value="${user.profileImage}"/>"
								alt="Profile Image"></li>
							<!-- 추가 내용-->
						</ul>
					</div>
				</c:forEach>
			</div>
		</div>
	</main>
</div>

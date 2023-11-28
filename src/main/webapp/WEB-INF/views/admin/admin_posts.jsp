<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="/mingle/css/admin_main.css">
<script src="<c:url value='/js/admin_main.js'/>"></script>


<!-- 커뮤니티 관리 섹션 -->
<div class="management_section" id="posts_management">
	<h2>커뮤니티 관리</h2>
	<div class="management_list">
		<!-- 리스트 헤더 -->
		<div class="list_header">
			<ul>
				<li>종류</li>
				<li>제목</li>
				<li>작성자</li>
				<li>작성일</li>
			</ul>
		</div>
	</div>
</div>

<!-- 리스트 -->
<c:forEach var="user" begin="1" end="8">
	<div class="list_item">
		<ul>
			<li>스타일</li>
			<li>New Balance 993</li>
			<li>홍길동</li>
			<li>신발</li>
			<li>2023.11.14</li>
		</ul>
	</div>
</c:forEach>
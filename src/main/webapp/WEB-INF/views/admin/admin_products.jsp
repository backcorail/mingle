<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="/mingle/css/admin_main.css">
<script src="<c:url value='/js/admin_main.js'/>"></script>


<!-- 상품 관리 섹션 -->
<div class="management_section" id="product_management">
	<h2>상품 관리</h2>
	<div class="management_list">
		<!-- 리스트 헤더 -->
		<div class="list_header">
			<ul>
				<li>판매자</li>
				<li>상품명</li>
				<li>입고일</li>
				<li>카테고리</li>
				<li>이미지</li>
			</ul>
		</div>
	</div>
</div>

<!-- 리스트 -->
<c:forEach var="user" begin="1" end="8">
	<div class="list_item">
		<ul>
			<li>user1</li>
			<li>New Balance 993</li>
			<li>2023.11.14</li>
			<li>신발</li>
			<li>이미지</li>
		</ul>
	</div>
</c:forEach>
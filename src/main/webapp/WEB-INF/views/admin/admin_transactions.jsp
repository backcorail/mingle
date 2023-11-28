<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="/mingle/css/admin_main.css">
<script src="<c:url value='/js/admin_main.js'/>"></script>


<!-- 거래 관리 섹션 -->
<div class="management_section" id="transactions_management">
	<h2>거래 관리</h2>
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
<c:forEach items="${transactionsList}" var="transactions">
	<div class="list_item">
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
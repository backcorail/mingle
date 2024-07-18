<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="all_select grid4_list">
	<div class="reqeust_wrapper">						
		<c:forEach var="n" items="${klist}">
			<a href="/mingle/style/trend/info/${n.item_no}" class="reqeust_content">
				<img src="${n.item_image}" class="mainImg">
				<div class="profile">
					<img src="/mingle/img/style/민글 로고.GIF" class="profileImg">
					<div class="writer">mingle</div>
				</div>
				<div class="title">${n.item_name}</div>
			</a>
		</c:forEach>
		<c:forEach var="n" items="${klist}">
			<a href="/mingle/style/trend/info/${n.item_no}" class="reqeust_content">
				<img src="${n.item_image}" class="mainImg">
				<div class="profile">
					<img src="/mingle/img/style/민글 로고.GIF" class="profileImg">
					<div class="writer">mingle</div>
				</div>
				<div class="title">${n.item_name}</div>
			</a>
		</c:forEach>
		<c:forEach var="n" items="${klist}">
			<a href="/mingle/style/trend/info/${n.item_no}" class="reqeust_content">
				<img src="${n.item_image}" class="mainImg">
				<div class="profile">
					<img src="/mingle/img/style/민글 로고.GIF" class="profileImg">
					<div class="writer">mingle</div>
				</div>
				<div class="title">${n.item_name}</div>
			</a>
		</c:forEach>
		<c:forEach var="n" items="${klist}">
			<a href="/mingle/style/trend/info/${n.item_no}" class="reqeust_content">
				<img src="${n.item_image}" class="mainImg">
				<div class="profile">
					<img src="/mingle/img/style/민글 로고.GIF" class="profileImg">
					<div class="writer">mingle</div>
				</div>
				<div class="title">${n.item_name}</div>
			</a>
		</c:forEach>
	</div>
</div>


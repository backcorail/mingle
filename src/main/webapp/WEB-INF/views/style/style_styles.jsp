<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="all_select grid4_list">
	<div class="reqeust_wrapper">						
		<c:forEach var="style" items="${styles}">
			<a href="/mingle/style/trend/info/${style.style_no}" class="reqeust_content">
				<img src="/mingle/uploadfile/${style.style_file_name}" class="mainImg">
				<div class="profile">
					<img src="${style.user_img}" class="profileImg">
					<div class="writer">${style.user_nick}</div>
				</div>
				<div class="title">${style.style_name}</div>
			</a>
			<!--
			<div class="board_items" data-item-no="${style.style_no}">
				<div class="imgdiv">
					<img class="img" src="/mingle/uploadfile/${style.style_file_name}"/>
				</div>
				<div class="board-content">
					<img class="profile-img" src="${style.user_img}" /> 
					<a class="username" href="">${style.user_nick}</a>
		
					<a href="#" class="likeLink1">
								  <img class="like1" src="/mingle/img/img_mingle/page_recell/icon_heart.png"><span>0</span>
					</a>												
					<a class="hashtag" href="/mingle/style/trend/info/${style.style_no}">${style.style_name}</a>
					
				</div>
			</div>
			-->
		</c:forEach>
	</div>
</div>

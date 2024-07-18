<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="all_select grid4_list">
	<div class="reqeust_wrapper">						
		<c:forEach var="n" items="${list}">
			<a href="/mingle/style/request/${n.request_no}" class="reqeust_content">
				<img src="${pageContext.request.contextPath}/uploadfile/${n.request_datafile_dataname}" class="mainImg">
				<div class="profile">
					<img src="${n.user_img}" class="profileImg">
					<div class="writer">${n.user_nick}</div>
				</div>
				<div class="title">${n.request_name}</div>
			</a>
		</c:forEach>
	</div>
</div>
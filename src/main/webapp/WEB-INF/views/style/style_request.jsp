<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"></script>
<script src="/mingle/js/style_main.js"></script>
<script src="/mingle/js/style_styles.js"></script>
<script src="/mingle/js/home.js"></script>
<script src="/mingle/js/style/request_board.js"></script>
<link rel="stylesheet" href="/mingle/css/style/style_main.css">
<link rel="stylesheet" href="/mingle/css/style/style_request.css">



<main class="style_main">
	<div class="style_title_container">
		<h2 class="style_title">STYLE</h2>
		<!-- 제목 -->
	</div>
	<div id="style_tabs">
		<ul class="style_tabs_list">
			<li class="tab"><a href="/mingle/style?tabs=1" id="ranking_tab">RANKING</a></li>
			<li class="tab"><a href="/mingle/style?tabs=2" id="style_tab">STYLE</a></li>
			<li class="tab"><a href="/mingle/style?tabs=3" id="trend_tab">TREND</a></li>
			<li class="tab"><a href="/mingle/style/request/list" id="request_tab">REQUEST</a></li>
		</ul>
		<hr class="style_header_line">
		<!-- 수평선 -->
		<!-- 탭의 내용을 구분하는 선 -->
		<div class="style_tab_content" id="tabs">
			<!-- 탭 4의 콘텐츠 -->
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
	</div>
</main>
<c:if test="${empty authUser}"> 
	<a href="javascript:goLogin()" class = "fillout">fill out</a>
</c:if>
<c:if test="${not empty authUser}"> 
	<a class = "fillout" href="/mingle/style/request/write">fill out</a>
</c:if>
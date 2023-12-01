<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<link rel="stylesheet" href="/mingle/css/resell/resell_main.css">
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@900&display=swap&family=Nanum+Pen+Script&display=swap&family=Abril+Fatface&family=Kanit:ital,wght@1,500&family=Noto+Sans+KR:wght@300" rel="stylesheet">
<script type="text/javascript" src="/mingle/js/resell/resell_main.js"></script>

<!-- 위쪽 카테고리 선택부분 -->
<div>
	<ul class="resell_top">
		<li>
			페이지당 레코드수 = ${rVO.onePageRecord}<br>
			총 레코드수 = ${rVO.ktotalRecord}<br>
			총 페이지수 = ${rVO.ktotalPage}<br>
		</li>
		<li class="resell_search">
			<form>
				<input type="text" id="search_bar">
			</form>
			<img src="/mingle/img/resell/magnifier.png">
		</li>
		<li id="choose_men" class="choose"><h3>Men</h3></li>
		<li id="choose_women" class="choose"><h3>Women</h3></li>
		<li id="choose_shoes" class="choose"><h3>Shoes</h3></li>
		<li id="choose_bag" class="choose"><h3>Bag</h3></li>
		<li id="choose_other" class="choose"><h3>Other</h3></li>
	</ul>
</div>

<div class="resell_main">
<!-- 왼쪽 탭 부분 -->
	<div class="resell_left">
	
		<!-- TOP 부분 -->
		<div class="resell_left_top">
			<div class="resell_left_topic">
				<h2>TOP</h2>
				<img src="/mingle/img/resell/btn_more_resell.png" id="moreView1" class="moreView"/>
			</div>
			<ul id="category1" class="category">
				<li>맨투맨/스웨트 셔츠</li>
				<li>니트/스웨터</li>
				<li>긴소매 티셔츠</li>
				<li>카라 티셔츠</li>
				<li>반소매 티셔츠</li>
				<li>민소매 티셔츠</li>
				<li>스포츠 상의</li>
				<li>셔츠</li>
			</ul>
		</div>
		
		<!-- BOTTOM 부분 -->
		<div class="resell_left_bottom">
			<div class="resell_left_topic">
				<h2>BOTTOM</h2>
				<img src="/mingle/img/resell/btn_more_resell.png" id="moreView2" class="moreView"/>
			</div>
			<ul id="category2" class="category">
				<li>데님팬츠</li>
				<li>코튼 팬트</li>
				<li>슈트 팬츠/슬랙스</li>
				<li>트레이닝/조거 팬츠</li>
				<li>숏 팬츠</li>
				<li>스포츠 하의</li>
				<li>기타 바지</li>
				<li>점프 슈트/오버올</li>
			</ul>
		</div>
		
		<!-- OUTER 부분 -->
		<div class="resell_left_outer">
			<div class="resell_left_topic">
				<h2>OUTER</h2>
				<img src="/mingle/img/resell/btn_more_resell.png" id="moreView3" class="moreView"/>
			</div>
			<ul id="category3" class="category">
				<li>후드 집업</li>
				<li>블루종</li>
				<li>라이더 재킷</li>
				<li>트리커 재킷</li>
				<li>슈트/블레이저 재킷</li>
				<li>무스탕/퍼</li>
				<li>카디건</li>
				<li>아노락</li>
				<li>코트</li>
				<li>패딩</li>
				<li>나일론/코치 재킷</li>
			</ul>
		</div>
		
		<!-- 글작성 부분 -->
        <div class="write_recell">
			<a href="/mingle/resell/write" class="button_container">
			  	<button class="btn_write_recell"><span>fill out</span></button>
			</a>
	 	</div> 
	</div>
	
	<!-- 리셀 부분 -->
	<div class="resell_right">
		<div class="resell_list">
			<c:forEach var="vo" items="${klist}">
				<div class="list_box">
					<img src="/mingle/img/resell/sample.jpg">
					<!-- <img src="${vo.item_image}"/> -->
					<a href="/mingle/resell/board?no=${vo.item_no}&page=${rVO.nowPage}">${vo.item_name}</a>
					<div class="recell_price">${vo.item_price}</div>
					<div class="recell_time">
						<div>
							<script>document.write(timeDiff('${vo.item_postdate}'));</script>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	
		<!-- 페이지수 -->
		<div class="resell_bottom">
			<ul class="page_select">
				<li>
					<c:if test="${rVO.nowPage != 1}">
						<a href="/mingle/resell?page=1" class="page_box">첫 페이지</a>
					</c:if>
				</li>
				<li>
					<c:if test="${rVO.nowPage > rVO.onePageCount}">
						<a href="/mingle/resell?page=${rVO.startPage - rVO.onePageCount}" class="page_box">이전</a>
					</c:if>
				</li>
				<c:forEach var="n" begin="${rVO.startPage}" end="${rVO.startPage + rVO.onePageCount-1}">
					<li>
						<c:if test="${n<=rVO.ktotalPage}">
							<c:if test="${n==rVO.nowPage}">
								<a href="/mingle/resell?page=${n}" class="page_now">${n}</a>
							</c:if>
							<c:if test="${n!=rVO.nowPage}">
								<a href="/mingle/resell?page=${n}" class="page_box">${n}</a>
							</c:if>
						</c:if>
					</li>
				</c:forEach>
				<li>
					<c:if test="${rVO.nowPage / rVO.onePageCount < rVO.ktotalPage / rVO.onePageCount}">
						<a href="/mingle/resell?page=${rVO.startPage + rVO.onePageCount}" class="page_box">다음</a>
					</c:if>
				</li>
				<li>
					<c:if test="${rVO.nowPage != rVO.ktotalPage}">
						<a href="/mingle/resell?page=${rVO.ktotalPage}" class="page_box">끝 페이지</a>
					</c:if>
				</li>
			</ul>
		</div>
	</div>
</div>
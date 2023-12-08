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
			총 레코드/페이지 수 = ${rVO.ktotalRecord}/${rVO.ktotalPage}<br>
			test = ${rVO.searchWord1}/${rVO.searchWord2}/${rVO.searchWord3}<br>
			1:${rVO.nowPage}, 2:${rVO.ktotalPage}
		</li>
		<li class="resell_search">
			<div>
				<form method="get" action="resell" onsubmit="return search()">
					<input type="text" id="search_bar">
				</form>
				<img class="search_img" id="search_magnifier" src="/mingle/img/resell/search.png">
				<img class="search_img" id="search_slide" src="/mingle/img/resell/slide.png">
			</div>
			<ul class="search_word">
				<c:if test="${rVO.searchWord1 != null}">
					<li>
						<div>${rVO.searchWord1}</div>
						<img class="search_delete" id="search_delete1" src="/mingle/img/resell/delete.png"/>
					</li>
				</c:if>
				<c:if test="${rVO.searchWord2 != null}">
					<li>
						<div>${rVO.searchWord2}</div>
						<img class="search_delete" id="search_delete2" src="/mingle/img/resell/delete.png"/>
					</li>
				</c:if>
				<c:if test="${rVO.searchWord3 != null}">
					<li>
						<div>${rVO.searchWord3}</div>
						<img class="search_delete" id="search_delete3" src="/mingle/img/resell/delete.png"/>
					</li>
				</c:if>
			</ul>
		</li>
		<li class="search_category">
			<div>
				<div id="type_men" class="category_type select">Men</div>
				<div id="type_women" class="category_type">Women</div>
				<div id="type_shoes" class="category_type">Shoes</div>
				<div id="type_bag" class="category_type">Bag</div>
				<div id="type_other" class="category_type">Other</div>
			</div>
			<div class="sort_dropdown">
				<div class="sort_button">
					<div>정렬</div>
					<img src="/mingle/img/resell/sort_slide.png">
					<div class="sort_list">
						<a class="resell_sort <c:if test="${rVO.sort == 'latest'}">active</c:if>" href="/mingle/resell?sort=latest">최신순</a>
						<a class="resell_sort <c:if test="${rVO.sort == 'name'}">active</c:if>" href="/mingle/resell?sort=name">이름순</a>
						<a class="resell_sort <c:if test="${rVO.sort == 'price'}">active</c:if>" href="/mingle/resell?sort=price">가격순</a>
					</div>
				</div>
			</div>
		</li>
		
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
			<ul id="category_detail1" class="category_detail">
				<li><a href="">맨투맨/스웨트 셔츠</a></li>
				<li><a href="">니트/스웨터</a></li>
				<li><a href="">긴소매 티셔츠</a></li>
				<li><a href="">카라 티셔츠</a></li>
				<li><a href="">반소매 티셔츠</a></li>
				<li><a href="">민소매 티셔츠</a></li>
				<li><a href="">스포츠 상의</a></li>
				<li><a href="">셔츠</a></li>
			</ul>
		</div>
		
		<!-- BOTTOM 부분 -->
		<div class="resell_left_bottom">
			<div class="resell_left_topic">
				<h2>BOTTOM</h2>
				<img src="/mingle/img/resell/btn_more_resell.png" id="moreView2" class="moreView"/>
			</div>
			<ul id="category_detail2" class="category_detail">
				<li><a href="">데님팬츠</a></li>
				<li><a href="">코튼 팬트</a></li>
				<li><a href="">슈트 팬츠/슬랙스</a></li>
				<li><a href="">트레이닝/조거 팬츠</a></li>
				<li><a href="">숏 팬츠</a></li>
				<li><a href="">스포츠 하의</a></li>
				<li><a href="">기타 바지</a></li>
				<li><a href="">점프 슈트/오버올</a></li>
			</ul>
		</div>
		
		<!-- OUTER 부분 -->
		<div class="resell_left_outer">
			<div class="resell_left_topic">
				<h2>OUTER</h2>
				<img src="/mingle/img/resell/btn_more_resell.png" id="moreView3" class="moreView"/>
			</div>
			<ul id="category_detail3" class="category_detail">
				<li><a href="">후드 집업</a></li>
				<li><a href="">블루종</a></li>
				<li><a href="">라이더 재킷</a></li>
				<li><a href="">트리커 재킷</a></li>
				<li><a href="">슈트/블레이저 재킷</a></li>
				<li><a href="">무스탕/퍼</a></li>
				<li><a href="">카디건</a></li>
				<li><a href="">아노락</a></li>
				<li><a href="">코트</a></li>
				<li><a href="">패딩</a></li>
				<li><a href="">나일론/코치 재킷</a></li>
			</ul>
		</div>
		
		<!-- 글작성 부분 -->
        <div class="write_recell">
			<a  href="/mingle/resell/write" class="button_container">
			  	<button class="btn_write_recell"><span>fill out</span></button>
			</a>
	 	</div> 
	</div>
	
	<!-- 리셀 부분 -->
	<div class="resell_right">
		<div class="resell_list">
			<c:if test="${rVO.ktotalPage == 0}">
				<div class="search_nothing">검색결과가 없습니다.</div>
			</c:if>
			<c:forEach var="vo" items="${klist}">
				<div class="list_box">
					<img referrerpolicy="no-referrer" src="${vo.item_image}">
					<!-- <img src="${vo.item_image}"/> -->
					<a href="/mingle/resell/board?no=${vo.item_no}&page=${rVO.nowPage}
						<c:if test="${rVO.searchWord1 != null}">&search=${rVO.searchWord1}</c:if>">${vo.item_name}</a>
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
		<c:if test="${rVO.ktotalPage != 0}">
			<div class="resell_bottom">
				<ul class="page_select">
					<li>
						<c:if test="${rVO.nowPage != 1}">
							<a href="/mingle/resell?page=1<c:if test="${rVO.searchWord!=''}">&search=${rVO.searchWord}</c:if>" class="page_box">첫 페이지</a>
						</c:if>
					</li>
					<li>
						<c:if test="${rVO.nowPage > rVO.onePageCount}">
							<a href="/mingle/resell?page=${rVO.startPage - rVO.onePageCount}<c:if test="${rVO.searchWord!=''}">&search=${rVO.searchWord}</c:if>" class="page_box">이전</a>
						</c:if>
					</li>
					<c:forEach var="n" begin="${rVO.startPage}" end="${rVO.startPage + rVO.onePageCount-1}">
						<li class="<c:if test='${n==rVO.nowPage}'>active</c:if>">
							<c:if test="${n<=rVO.ktotalPage}">
								<a href="/mingle/resell?page=${n}<c:if test="${rVO.searchWord!=''}">&search=${rVO.searchWord}</c:if>" class="page_box">${n}</a>
							</c:if>
						</li>
					</c:forEach>
					<li>
						<c:if test="${rVO.nowPage / rVO.onePageCount < rVO.ktotalPage / rVO.onePageCount}">
							<a href="/mingle/resell?page=${rVO.startPage + rVO.onePageCount}<c:if test="${rVO.searchWord!=''}">&search=${rVO.searchWord}</c:if>" class="page_box">다음</a>
						</c:if>
					</li>
					<li>
						<c:if test="${rVO.nowPage != rVO.ktotalPage && rVO.ktotalPage != 0}">
							<a href="/mingle/resell?page=${rVO.ktotalPage}<c:if test="${rVO.searchWord!=''}">&search=${rVO.searchWord}</c:if>" class="page_box">끝 페이지</a>
						</c:if>
					</li>
				</ul>
			</div>	
		</c:if>
	</div>
</div>
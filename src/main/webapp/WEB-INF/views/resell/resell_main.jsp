<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="authUser"/>
</sec:authorize>

<link rel="stylesheet" href="/mingle/css/resell/resell_main.css">
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@900&display=swap&family=Nanum+Pen+Script&display=swap&family=Abril+Fatface&family=Kanit:ital,wght@1,500&family=Noto+Sans+KR:wght@300" rel="stylesheet">
<script type="text/javascript" src="/mingle/js/resell/resell_main.js"></script>

<!-- 위쪽 카테고리 선택부분 -->
<div>
	<ul class="resell_top">
		<!-- 검색 부분 -->
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
		
		<!-- 상단 카테고리 -->
		<li class="search_category">
			<div>
				<c:forEach var="n" items="${main}" varStatus="n0">
					<div class="category_type ${n}" id="${n0.index}">${n}</div>
				</c:forEach>
			</div>
			<div class="sort_dropdown">
				<div class="sort_button">
					<div>정렬</div>
					<img src="/mingle/img/resell/sort_slide.png">
					<div class="sort_list">
						<div id="latest_desc" class="resell_sort <c:if test="${rVO.sort.startsWith('latest') || rVO.sort == ''}">active</c:if>">최신순</div>
						<div id="name_asc" class="resell_sort <c:if test="${rVO.sort.startsWith('name')}">active</c:if>">이름순</div>
						<div id="price_asc" class="resell_sort <c:if test="${rVO.sort.startsWith('price')}">active</c:if>">가격순</div>
						<div id="order_asc" class="resell_sort">
							<c:if test="${rVO.sort == 'latest_desc' || rVO.sort == 'name_asc' || rVO.sort == 'price_asc'}">
								오름차순<img src="/mingle/img/resell/order_up.png"></c:if>
							<c:if test="${rVO.sort == 'latest_asc' || rVO.sort == 'name_desc' || rVO.sort == 'price_desc'}">
								내림차순<img src="/mingle/img/resell/order_down.png"></c:if>
						</div>
					</div>
				</div>
			</div>
		</li>
	</ul>
</div>


<div class="resell_main">
<!-- 왼쪽 탭 부분 -->
	<ul class="resell_left">
		<!-- 왼쪽 카테고리 -->
		<c:forEach var="category" items="${title}" varStatus="n1">
	        <li>
	            <div class="resell_left_topic">
	                <div>${category}</div>
	                <img src="/mingle/img/resell/btn_more_resell.png" class="moreView">
	            </div>
	            <ul class="search_detail">
	                <c:forEach var="item" items="${requestScope[category]}" varStatus="n2">
	                    <li>
	                    	<div class="category_detail" id="<c:if test='${!n2.last}'>${(n1.index+1)*100+n2.index}</c:if>
	                    	<c:if test='${n2.last}'>${(n1.index+1)*100+99}</c:if>">${item}</div>
	                    </li>
	                </c:forEach>
	            </ul>
	        </li>
		</c:forEach>
		<!-- 글작성 부분 -->
		<c:if test="${not empty authUser}">
			<li class="write_recell">
				<a href="/mingle/resell/write" class="button_container">
				  	<button class="btn_write_recell"><span>fill out</span></button>
				</a>
		 	</li> 
	 	</c:if>
 	</ul>
	
	<!-- 리셀 부분 -->
	<div class="resell_right">
		<div class="resell_list">
			<c:if test="${rVO.ktotalPage == 0}">
				<div class="search_nothing">검색결과가 없습니다.</div>
			</c:if>
			<c:forEach var="vo" items="${klist}">
				<div class="list_box">
					<img referrerpolicy="no-referrer" src="${vo.item_image}">
					<div class="board_view" id="${vo.item_no}">${vo.item_name}</div>
					<c:set var="format" value="${vo.item_price}"/>
					<fmt:formatNumber var="formatPrice" value="${format}" pattern="#,###원"/>
					<div class="recell_price">${formatPrice}</div>
					<div class="recell_time">
						<div>
							${vo.item_postdate} / 
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
							<div id="1" class="page_box">첫 페이지</div>
						</c:if>
					</li>
					<li>
						<c:if test="${rVO.nowPage > rVO.onePageCount}">
							<div id="${rVO.startPage - rVO.onePageCount}" class="page_box">이전</div>
						</c:if>
					</li>
					<c:forEach var="n" begin="${rVO.startPage}" end="${rVO.startPage + rVO.onePageCount-1}">
						<li class="<c:if test='${n==rVO.nowPage}'>active</c:if>">
							<c:if test="${n<=rVO.ktotalPage}">
								<div id="${n}" class="page_box">${n}</div>
							</c:if>
						</li>
					</c:forEach>
					<li>
						<c:if test="${rVO.nowPage / rVO.onePageCount < rVO.ktotalPage / rVO.onePageCount}">
							<div id="${rVO.startPage + rVO.onePageCount}" class="page_box">다음</div>
						</c:if>
					</li>
					<li>
						<c:if test="${rVO.nowPage != rVO.ktotalPage && rVO.ktotalPage != 0}">
							<div id="${rVO.ktotalPage}" class="page_box">끝 페이지</div>
						</c:if>
					</li>
				</ul>
			</div>	
		</c:if>
	</div>
</div>
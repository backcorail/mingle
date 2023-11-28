<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"></script>
<script src="/mingle/js/admin_main.js"></script>
<link rel="stylesheet" href="/mingle/css/admin_main.css">


<div class="admin_container">
	<aside class="sidebar">
		<!-- Sidebar 메뉴 -->
		<ul class="sidebar_menu">
			<li class="side"><a href="#side-1" id="admin_side">관리자 페이지</a></li>

			<li class="side"><a href="#side-2" id="members_side">회원 관리</a>
				<ul class="submenu">
					<li class="tab"><a href="#tabs-1" id="members_tab">회원 데이터</a></li>
					<li class="tab"><a href="#tabs-2" id="blacklist_tab">블랙 리스트</a></li>
					<li class="tab"><a href="#tabs-3" id="inactive_tab">휴면/탈퇴 계정</a></li>
				</ul></li>

			<li class="side"><a href="#side-3" id="products_side">상품 관리</a>
				<ul class="submenu">
					<li class="tab"><a href="#tabs-4" id="category_tab">카테고리별 상품수</a></li>
					<li class="tab"><a href="#tabs-5" id="">----</a></li>
				</ul></li>

			<li class="side"><a href="#side-4" id="transactions_side">거래 관리</a>
				<ul class="submenu">
					<li class="tab"><a href="#tabs-6" id="transactions_tab">거래 내역 확인</a></li>
					<li class="tab"><a href="#tabs-7" id="">----</a></li>
				</ul></li>

			<li class="side"><a href="#side-5" id="posts_side">커뮤니티 관리</a>
				<ul class="submenu">
					<li class="tab"><a href="#tabs-8" id="posts_tab">게시글 내역 확인</a></li>
					<li class="tab"><a href="#tabs-9" id="">----</a></li>
				</ul></li>

			<li class="side"><a href="#side-6" id="recommendations_side">관리자 추천 코디</a>
				<ul class="submenu">
					<li class="tab"><a href="#tabs-10" id="items_tab">다수의 아이템 동시 적용</a></li>
					<li class="tab"><a href="#tabs-11" id="outfits_tab">관리자 적용 글 작성 페이지</a></li>
					<li class="tab"><a href="#tabs-12" id="behavior-tab">코디 추천 기록 조회</a></li>
				</ul></li>

			<li class="side"><a href="#side-7" id="server_side">관리자 권한 설정</a>
				<ul class="submenu">
					<li class="tab"><a href="#tabs-13" id="access_tab">권한 지정</a></li>
				</ul></li>
		</ul>
	</aside>
	<main class="admin_main">
		<!-- 메인 섹션 -->
		<div class="">
			<div class="admin_side_content" id="side-1">
			<!-- side 1의 콘텐츠 -->
			</div>
				<div class="admin_tab_content" id="tabs-1">
				<!-- tab 1의 콘텐츠 -->
				</div>
			<div class="admin_side_content" id="side-2">
			<!-- side 2의 콘텐츠 -->
			</div>
				<div class="admin_tab_content" id="tabs-2">
				<!-- tab 2의 콘텐츠 -->
				</div>
				<div class="admin_tab_content" id="tabs-3">
				<!-- tab 3의 콘텐츠 -->
				</div>
				<div class="admin_tab_content" id="tabs-4">
				<!-- tab 4의 콘텐츠 -->
				</div>
			<div class="admin_side_content" id="side-3">
			<!-- side 3의 콘텐츠 -->
			</div>
				<div class="admin_tab_content" id="tabs-5">
				<!-- tab 5의 콘텐츠 -->
				</div>
				<div class="admin_tab_content" id="tabs-6">
				<!-- tab 6의 콘텐츠 -->
				</div>
			<div class="admin_side_content" id="side-4">
			<!-- side 4의 콘텐츠 -->
			</div>
				<div class="admin_tab_content" id="tabs-7">
				<!-- tab 7의 콘텐츠 -->
				</div>
				<div class="admin_tab_content" id="tabs-8">
				<!-- tab 8의 콘텐츠 -->
				</div>
			<div class="admin_side_content" id="side-5">
			<!-- side 5의 콘텐츠 -->
			</div>
				<div class="admin_tab_content" id="tabs-9">
				<!-- tab 9의 콘텐츠 -->
				</div>
				<div class="admin_tab_content" id="tabs-10">
				<!-- tab 10의 콘텐츠 -->
				</div>
			<div class="admin_side_content" id="#side-6">
			<!-- side 6의 콘텐츠 -->
			</div>
				<div class="admin_tab_content" id="tabs-11">
				<!-- tab 11의 콘텐츠 -->
				</div>
				<div class="admin_tab_content" id="tabs-12">
				<!-- tab 12의 콘텐츠 -->
				</div>
				<div class="admin_tab_content" id="tabs-13">
				<!-- tab 13의 콘텐츠 -->
				</div>
			<div class="admin_side_content" id="side-7">
			<!-- side 7의 콘텐츠 -->
			</div>
				<div class="admin_tab_content" id="tabs-14">
				<!-- tab 14의 콘텐츠 -->
				</div>

		</div>
	</main>
</div>

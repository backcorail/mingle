<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="authUser"/>
</sec:authorize>
<link rel="stylesheet" href="/mingle/css/mypage/mypage_init.css">
<link rel="stylesheet" href="/mingle/css/mypage/mypage_main.css">
    <main>
      <div class="container">
        <!-- side 메뉴 -->
        <div class="div-side">
          <div class="div-my-page Kanit-SemiBold-28">마이페이지</div>
          <div class="div-edit-user Kanit-Regular-18">회원정보수정</div>

          <div class="div-shopping-data Kanit-SemiBold-28">쇼핑정보</div>
          <div class="div-buy-data Kanit-Regular-18">구매내역</div>
          <div class="div-sell-data Kanit-Regular-18">판매내역</div>
          <div class="div-my-basket Kanit-Regular-18">장바구니</div>

          <div class="div-myact Kanit-SemiBold-28">내활동</div>
          <div class="div-myboard Kanit-Regular-18">게시글</div>
          <div class="div-myreply Kanit-Regular-18">댓글</div>
          <div class="div-favo Kanit-Regular-18">좋아요</div>
          <div class="div-scrap Kanit-Regular-18">스크랩</div>
        </div>

        <!-- mypage main -->
        <div class="div-mypage-main">
          <div class="Kanit-SemiBold-28">회원정보수정</div>
          
        </div> <!-- mypage main 끝  -->
      </div><!-- container -->
    </main>
<script src="/mingle/js/layout_resize.js"></script>
<script src="/mingle/js/mypage/myinit.js"></script>
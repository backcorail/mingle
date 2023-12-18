<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link rel="stylesheet" href="/mingle/css/mypage/mypage_init.css">
<link rel="stylesheet" href="/mingle/css/mypage/mypage_buylist.css">
    <main>
      <div class="container">
        <!-- side 메뉴 -->
<%@ include file="myaside.jspf" %>
        <!-- mypage main -->
        <div class="div-mypage-main">
          <div class="Kanit-SemiBold-28">구매내역</div>
          <div class="div-select-date-area">
            <input type="button" value="최근일주일" class="Inika-Regular-18">
            <input type="button" value="1개월" class="Inika-Regular-18">
            <input type="button" value="3개월" class="Inika-Regular-18">
            <input type="date" class="Inika-Regular-18">
            <div class="Inika-bold-25"> ~ </div>
            <input type="date" class="Inika-Regular-18">
            <input type="button" value="조회" class="Inika-Regular-18w">
          </div>
          <div class="div-ub-bold">
            <div class="Kanit-Regular-25b">상품정보</div>
          </div>
          <div class="div-item-list-area">
 
              <!-- 임시데이터 -->
               <input id="resellno" type="hidden" value="${lastmap['리셀']}">
              <c:forEach var="actInfo" items="${actInfos}">
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="/mingle/uploadfile/${actInfo.img}" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18" >${actInfo.title}</div>
                  <!-- <div class="div-eye-item-script Inika-Regular-16">${actInfo.contents}</div> -->
                </div>
              </div><!-- 관심상품 list-box1 -->
			</c:forEach>         
          </div>
          <div class="div-blank-45"></div>
          <input id="btn-more-buy" type="button" value="더보기" class="btn-more-data Inika-bold-20w">
		<div class="div-blank-45"></div>
          
        </div> <!-- mypage main 끝  -->
      </div><!-- container -->
    </main>
<script src="/mingle/js/layout_resize.js"></script>
<script src="/mingle/js/mypage/mybuylist.js"></script>
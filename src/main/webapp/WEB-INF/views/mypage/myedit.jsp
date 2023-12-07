<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="authUser"/>
</sec:authorize>
<link rel="stylesheet" href="/mingle/css/mypage/mypage_init.css">
<link rel="stylesheet" href="/mingle/css/mypage/mypage_edit.css">
    <main>
      <div class="container">
        <!-- side 메뉴 -->
<%@ include file="myaside.jspf" %>
        <!-- mypage main -->
        <div class="div-mypage-main">
          <div class="Kanit-SemiBold-28">회원정보수정</div>
          <!-- 경계선 굵은것 -->
          <div class="div-underline-bold"></div>
          <div class="div-edit-area">
            <img id="img-profile" src="/mingle/img/user/profileEX.png" alt="" >
            <div class="div-profile-area">
              <div class="div-my-nick Inika-bold-25">adam_12_like_@</div>
              <div class="div-my-name Inika-Regular-20">김연아</div>
              <div class="div-btn-area">
                <input type="button" value="이미지변경">
                <input type="button" value="이미지삭제">
              </div>
            </div>
          </div>
          <!-- 경계선 굵은것 앏은것-->
          <div class="div-underline-thin"></div>
          <div class="div-profile-edit-area">
            <div class="div-main-data-area">
              <div class="Inika-Regular-16-af">아이디</div>
              <div class="div-userid-area div-underline-thin-data">
                <input type="text" class="userid Inika-Regular-22 input-userdata-commom" value="q***************@naver.">
                <input type="button" class="btn-userdata-common" value="변경">
              </div>
              <div class="div-blank"></div>
              <div class="Inika-Regular-16-af">비밀번호</div>
              <div class="div-userid-area div-underline-thin-data">
                <input type="text" class="userpwd Inika-Regular-22 input-userdata-commom" value="a*******************************">
                <input type="button" class="btn-userdata-common" value="변경">
              </div>
            </div>
            <div class="div-sub-data-area">
              <div class="Inika-Regular-16-af">닉네임</div>
              <div class="div-niick-area div-underline-thin-data">
                <input type="text" class="usernick Inika-Regular-22 input-userdata-commom" value="adam_12_like_@">
                <input type="button" class="btn-userdata-common" value="변경">
              </div>
              <div class="div-blank"></div>
              <div class="Inika-Regular-16-af">이름</div>
              <div class="div-name-area div-underline-thin-data">
                <input type="text" class="userpwd Inika-Regular-22 input-userdata-commom" value="김연아">
                <input type="button" class="btn-userdata-common" value="변경">
              </div>
              <div class="div-blank"></div>
              <div class="Inika-Regular-16-af">전화번호</div>
              <div class="div-tel-area div-underline-thin-data">
                <input type="text" class="usertel Inika-Regular-22 input-userdata-commom" value="010-xxxx-xxxx">
                <input type="button" class="btn-userdata-common" value="변경">
              </div>
              <div class="div-blank"></div>
              <div class="Inika-Regular-16-af">주소</div>
              <div class="div-addr-area div-underline-thin-data">
                <input type="text" class="useraddr Inika-Regular-22 input-userdata-commom" value="328 Gangnam-daero, Gangnam-gu, Seoul">
                <input type="button" class="btn-userdata-common" value="변경">
              </div>
            </div>
          </div>
          
        </div> <!-- mypage main 끝  -->
      </div><!-- container -->
    </main>
<script src="/mingle/js/layout_resize.js"></script>
<script src="/mingle/js/mypage/myedit.js"></script>
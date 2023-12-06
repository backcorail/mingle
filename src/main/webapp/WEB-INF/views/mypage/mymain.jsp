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
<%@ include file="myaside.jspf" %>
        <!-- mypage main -->
        <div class="div-mypage-main">
          <!-- 프로필 -->
          <div class="div-profile">
            <img id="img-profile" src="/mingle/img/user/profileEX.png" alt="" >
            <div class="div-my-nick">adam_12_like_@</div>
            <div class="div-my-name">김연아</div>
            <div class="div-id Inika-bold-20" >ID</div>
            <div class="div-userid Inika-Regular-16">y**********@naver.com</div>
            <div class="div-pwd Inika-bold-20">PASSWORD</div>
            <div class="div-usrepwd Inika-Regular-16">y2k************</div>
            <div class="div-tel Inika-bold-20">Tel</div>
            <div class="div-usertel Inika-Regular-16">010-xxxx-xxxx</div>
            <div class="div-addr Inika-bold-20">Address</div>
            <div class="div-useraddr Inika-Regular-16">328 Gangnam-daero, Gangnam-gu, Seoul</div>
            <input type="button" class="btn-edit-userdata Inika-bold-20" value="회원정보 수정">
          </div>
          
          <!-- 내 관련정보 -->
          <div class="div-my-detail-data">
            <!-- 구매 내역 -->
            <div class="div-buy-data-num">
              <div class="div-title-txt Inika-bold-20">구매내역</div>
              <ul class="ul-templete-mydata">
                <li>
                  <div class="div-subtitle-txt">전체</div>
                  <div class="div-subtitle-num">0</div>
                </li>
                <li class="li-col-line"><div></div></li>
                <li>
                  <div class="div-subtitle-txt">판매 대기</div>
                  <div class="div-subtitle-num">0</div>
                </li>
                <li class="li-col-line"><div></div></li>
                <li>
                  <div class="div-subtitle-txt">판매중</div>
                  <div class="div-subtitle-num">0</div>
                </li>
                <li class="li-col-line"><div></div></li>
                <li>
                  <div class="div-subtitle-txt">판매 완료</div>
                  <div class="div-subtitle-num">0</div>
                </li>
              </ul>
            </div>
            <!-- 구매 리스트 -->
            <div class="div-buy-detail-list">
              <p class="Inika-Regular-16">판매내역없음</p>
            </div>
            <!-- 판매내역 -->
            <div class="div-buy-data-num">
              <div class="div-title-txt Inika-bold-20">판매내역</div>
              <ul class="ul-templete-mydata">
                <li>
                  <div class="div-subtitle-txt">전체</div>
                  <div class="div-subtitle-num">0</div>
                </li>
                <li class="li-col-line"><div></div></li>
                <li>
                  <div class="div-subtitle-txt">판매 대기</div>
                  <div class="div-subtitle-num">0</div>
                </li>
                <li class="li-col-line"><div></div></li>
                <li>
                  <div class="div-subtitle-txt">판매중</div>
                  <div class="div-subtitle-num">0</div>
                </li>
                <li class="li-col-line"><div></div></li>
                <li>
                  <div class="div-subtitle-txt">판매 완료</div>
                  <div class="div-subtitle-num">0</div>
                </li>
              </ul>
            </div>
            <!-- 구매 리스트 -->
            <div class="div-sell-detail-list">
              <p class="Inika-Regular-16">구매내역없음</p>
            </div>
            <!-- 관심상풍 -->
            <div class="div-title-txt Inika-bold-20">관심 상품</div>
            <div class="div-related-item-box">              
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18">Stone Island</div>
                  <p class="div-eye-item-script Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycl..</p>
                </div>
              </div><!-- 관심상품 list-box1 -->
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18">Stone Island</div>
                  <p class="div-eye-item-script Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycl..</p>
                </div>
              </div><!-- 관심상품 list-box2 -->
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18">Stone Island</div>
                  <p class="div-eye-item-script Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycl..</p>
                </div>
              </div><!-- 관심상품 list-box3 -->
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18" >Stone Island</div>
                  <p class="div-eye-item-script Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycl..</p>
                </div>
              </div><!-- 관심상품 list-box4 -->
            </div><!-- 관심상풀 -->
          </div>
        </div> <!-- mypage main 끝  -->
      </div><!-- container -->
    </main>
<script src="/mingle/js/layout_resize.js"></script>
<script src="/mingle/js/mypage/mymain.js"></script>
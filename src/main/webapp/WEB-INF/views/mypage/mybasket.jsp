<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="authUser"/>
</sec:authorize>
<link rel="stylesheet" href="/mingle/css/mypage/mypage_init.css">
<link rel="stylesheet" href="/mingle/css/mypage/mypage_basket.css">
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
          <div class="Kanit-SemiBold-28">장바구니</div>

          <div class="div-ub-bold">
            <div class="Kanit-Regular-25b">상품정보</div>
            <div class="Kanit-Regular-25b">가격</div>
            <div class="Kanit-Regular-25b">등록일</div>
          </div>
          <div class="div-item-list-area">
            <!-- 1 track -->
            <div class="div-track">
              <div class="div-item-area">
                <img src="" alt="" class="item">
                <div class="div-item-script">
                  <div class="div-item-title Inika-bold-18">Stone Island</div>
                  <div class="div-item-contnet Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycled
                    Nylon Hooded Down Jacket Black - 23FW</div>
                </div>
              </div>
              <div class="div-item-price-area">
                <div class="div-item-price Kanit-Regular-25y">1,089,000원</div>
              </div>
              <div class="div-item-date-area">
                <div class="div-item-date Kanit-Regular-20">2023.05.10</div>
              </div>
            </div>
            <!-- track 끝 -->
            <!-- 2 track -->
            <div class="div-track">
              <div class="div-item-area">
                <img src="" alt="" class="item">
                <div class="div-item-script">
                  <div class="div-item-title Inika-bold-18">Stone Island</div>
                  <div class="div-item-contnet Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycled
                    Nylon Hooded Down Jacket Black - 23FW</div>
                </div>
              </div>
              <div class="div-item-price-area">
                <div class="div-item-price Kanit-Regular-25y">1,089,000원</div>
              </div>
              <div class="div-item-date-area">
                <div class="div-item-date Kanit-Regular-20">2023.05.10</div>
              </div>
            </div>
            <!-- track 끝 -->
            <!-- 3 track -->
            <div class="div-track">
              <div class="div-item-area">
                <img src="" alt="" class="item">
                <div class="div-item-script">
                  <div class="div-item-title Inika-bold-18">Stone Island</div>
                  <div class="div-item-contnet Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycled
                    Nylon Hooded Down Jacket Black - 23FW</div>
                </div>
              </div>
              <div class="div-item-price-area">
                <div class="div-item-price Kanit-Regular-25y">1,089,000원</div>
              </div>
              <div class="div-item-date-area">
                <div class="div-item-date Kanit-Regular-20">2023.05.10</div>
              </div>
            </div>
            <!-- track 끝 -->
            <!-- 4 track -->
            <div class="div-track">
              <div class="div-item-area">
                <img src="" alt="" class="item">
                <div class="div-item-script">
                  <div class="div-item-title Inika-bold-18">Stone Island</div>
                  <div class="div-item-contnet Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycled
                    Nylon Hooded Down Jacket Black - 23FW</div>
                </div>
              </div>
              <div class="div-item-price-area">
                <div class="div-item-price Kanit-Regular-25y">1,089,000원</div>
              </div>
              <div class="div-item-date-area">
                <div class="div-item-date Kanit-Regular-20">2023.05.10</div>
              </div>
            </div>
            <!-- track 끝 -->
            <!-- 5 track -->
            <div class="div-track">
              <div class="div-item-area">
                <img src="" alt="" class="item">
                <div class="div-item-script">
                  <div class="div-item-title Inika-bold-18">Stone Island</div>
                  <div class="div-item-contnet Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycled
                    Nylon Hooded Down Jacket Black - 23FW</div>
                </div>
              </div>
              <div class="div-item-price-area">
                <div class="div-item-price Kanit-Regular-25y">1,089,000원</div>
              </div>
              <div class="div-item-date-area">
                <div class="div-item-date Kanit-Regular-20">2023.05.10</div>
              </div>
            </div>
            <!-- track 끝 -->
            <input type="button" value="더보기" class="btn-more-data Inika-bold-20w">
          </div>


        </div> <!-- mypage main 끝  -->
      </div><!-- container -->
    </main>
<script src="/mingle/js/layout_resize.js"></script>
<script src="/mingle/js/mypage/mybasket.js"></script>
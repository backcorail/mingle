<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
            <img id="img-profile" src="${!empty userVO.user_img ?userVO.user_img : '/mingle/img/user/profileEX.png'}" alt="" >
            
            <div class="div-my-nick">${!empty userVO.user_nick ?userVO.user_nick : '등록한 닉네임 없음'}</div>
            <div class="div-my-name">김연아</div>
            
            <div class="div-id Inika-bold-20" >Email</div>
            <div class="div-userid Inika-Regular-16">${!empty userVO.user_email ?userVO.user_email : '등록한 이메일 없음'}</div>
            
            <div class="div-pwd Inika-bold-20">PASSWORD</div>
            <div class="div-usrepwd Inika-Regular-16">***************</div>
            
            <div class="div-tel Inika-bold-20">Tel</div>
            <div class="div-usertel Inika-Regular-16">${!empty userVO.user_tel ?userVO.user_tel : '등록한 전화번호 없음'}</div>
            
            <div class="div-addr Inika-bold-20">Address</div>
            <div class="div-useraddr Inika-Regular-16">${!empty userVO.user_addr ?userVO.user_addr : '등록한 주소 없음'}</div>
            
            <a href="/mingle/mypage/myedit"><input type="button" class="btn-edit-userdata Inika-bold-20" value="회원정보 수정"></a> 
          </div>
          
          <!-- 내 관련정보 -->
          <div class="div-my-detail-data">
            <!-- 구매 내역 -->
            <div class="div-buy-data-num">
              <div class="div-title-txt Inika-bold-20"><h1>${authUser.userVO.user_nick}</h1></div>
              <ul class="ul-templete-mydata">
                <li>
                  <div class="div-subtitle-txt">전체</div>
                  <div class="div-subtitle-num buy-total">0</div>
                </li>
                <li class="li-col-line"><div></div></li>
                <li>
                  <div class="div-subtitle-txt">구매 대기</div>
                  <div class="div-subtitle-num buy-wait">0</div>
                </li>
                <li class="li-col-line"><div></div></li>
                <li>
                  <div class="div-subtitle-txt">구매중</div>
                  <div class="div-subtitle-num buy-ing">0</div>
                </li>
                <li class="li-col-line"><div></div></li>
                <li>
                  <div class="div-subtitle-txt">구매 완료</div>
                  <div class="div-subtitle-num buy-done">0</div>
                </li>
              </ul>
            </div>
            <!-- 구매 리스트 -->
            <div class="div-buy-detail-list">
              <p class="Inika-Regular-16">구매내역없음</p>
            </div>
            <!-- 판매내역 -->
            <div class="div-buy-data-num">
              <div class="div-title-txt Inika-bold-20">판매내역</div>
              <ul class="ul-templete-mydata">
                <li>
                  <div class="div-subtitle-txt">전체</div>
                  <div class="div-subtitle-num sell-total">0</div>
                </li>
                <li class="li-col-line"><div></div></li>
                <li>
                  <div class="div-subtitle-txt">판매 대기</div>
                  <div class="div-subtitle-num sell-wait">0</div>
                </li>
                <li class="li-col-line"><div></div></li>
                <li>
                  <div class="div-subtitle-txt">판매중</div>
                  <div class="div-subtitle-num sell-ing">0</div>
                </li>
                <li class="li-col-line"><div></div></li>
                <li>
                  <div class="div-subtitle-txt">판매 완료</div>
                  <div class="div-subtitle-num sell-done">0</div>
                </li>
              </ul>
            </div>
            <!-- 구매 리스트 -->
            <div class="div-sell-detail-list">
              <p class="Inika-Regular-16">판매내역없음</p>
            </div>
            <!-- 관심상풍 eye-->
            <div class="div-title-txt Inika-bold-20">관심 상품</div>
            
            <!-- 관심상품 list-box1 -->
            <div class="div-related-item-box">              
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18">Stone Island</div>
                  <p class="div-eye-item-script Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycl..</p>
                </div>
              </div>
              <!-- 관심상품 list-box2 -->
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18">Stone Island</div>
                  <p class="div-eye-item-script Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycl..</p>
                </div>
              </div>
              <!-- 관심상품 list-box3 -->
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18">Stone Island</div>
                  <p class="div-eye-item-script Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycl..</p>
                </div>
              </div>
              <!-- 관심상품 list-box4 -->
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18" >Stone Island</div>
                  <p class="div-eye-item-script Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycl..</p>
                </div>
              </div>
              
            </div><!-- 관심상풀 -->
          </div>
        </div> <!-- mypage main 끝  -->
      </div><!-- container -->
    </main>
<script src="/mingle/js/layout_resize.js"></script>
<script src="/mingle/js/mypage/mymain.js"></script>
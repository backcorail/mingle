<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="authUser"/>
</sec:authorize>
<link rel="stylesheet" href="/mingle/css/mypage/mypage_init.css">
<link rel="stylesheet" href="/mingle/css/mypage/mypage_selllist.css">
    <main>
      <div class="container">
        <!-- side 메뉴 -->
<%@ include file="myaside.jspf" %>
        <!-- mypage main -->
        <div class="div-mypage-main">
          <div class="Kanit-SemiBold-28">판매내역</div>
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
            <div class="div-track">
              <!-- 임시데이터 -->
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18" >Stone Island</div>
                  <p class="div-eye-item-script Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycl..</p>
                  <div class="div-forsale"></div>
                </div>
              </div><!-- 관심상품 list-box1 -->
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18" >Stone Island</div>
                  <p class="div-eye-item-script Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycl..</p>
                  <div class="div-forsale"></div>
                </div>
              </div><!-- 관심상품 list-box1 -->
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18" >Stone Island</div>
                  <p class="div-eye-item-script Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycl..</p>
                  <div class="div-forsale"></div>
                </div>
              </div><!-- 관심상품 list-box1 -->
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18" >Stone Island</div>
                  <p class="div-eye-item-script Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycl..</p>
                  <div class="div-soldout"></div>
                </div>
              </div><!-- 관심상품 list-box1 -->
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18" >Stone Island</div>
                  <p class="div-eye-item-script Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycl..</p>
                  <div class="div-soldout"></div>
                </div>
              </div><!-- 관심상품 list-box1 -->
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18" >Stone Island</div>
                  <p class="div-eye-item-script Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycl..</p>
                  <div class="div-soldout"></div>
                </div>
              </div><!-- 관심상품 list-box1 -->
            </div><!-- track 끝 -->

            <div class="div-track">
              <!-- 임시데이터 -->
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18" >Stone Island</div>
                  <p class="div-eye-item-script Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycl..</p>
                  <div class="div-soldout"></div>
                </div>
              </div><!-- 관심상품 list-box1 -->
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18" >Stone Island</div>
                  <p class="div-eye-item-script Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycl..</p>
                  <div class="div-soldout"></div>
                </div>
              </div><!-- 관심상품 list-box1 -->
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18" >Stone Island</div>
                  <p class="div-eye-item-script Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycl..</p>
                  <div class="div-soldout"></div>
                </div>
              </div><!-- 관심상품 list-box1 -->
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18" >Stone Island</div>
                  <p class="div-eye-item-script Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycl..</p>
                  <div class="div-soldout"></div>
                </div>
              </div><!-- 관심상품 list-box1 -->
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18" >Stone Island</div>
                  <p class="div-eye-item-script Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycl..</p>
                  <div class="div-soldout"></div>
                </div>
              </div><!-- 관심상품 list-box1 -->
              <div class="div-eye-items-box">
                <div class="div-eye-item">
                  <img src="" alt="" class="div-eye-itme">
                  <div class="div-eye-item-title Inika-bold-18" >Stone Island</div>
                  <p class="div-eye-item-script Inika-Regular-16">Stone Island 40723 Garment Dyed Crinkle Reps Recycl..</p>
                  <div class="div-soldout"></div>
                </div>
              </div><!-- 관심상품 list-box1 -->
            </div><!-- track 끝 -->
            
            <input type="button" value="더보기" class="btn-more-data Inika-bold-20w">
          </div>

          
        </div> <!-- mypage main 끝  -->
      </div><!-- container -->
    </main>
<script src="/mingle/js/layout_resize.js"></script>
<script src="/mingle/js/mypage/myselllist.js"></script>
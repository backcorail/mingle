<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="authUser"/>
</sec:authorize>
<link rel="stylesheet" href="/mingle/css/mypage/mypage_init.css">
<link rel="stylesheet" href="/mingle/css/mypage/mypage_reply.css">
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
          <div class="Kanit-SemiBold-28">댓글</div>

          <div class="div-ub-bold">
            <div class="Kanit-Regular-25b">위치</div>
            <div class="Kanit-Regular-25b">제목</div>
            <div class="Kanit-Regular-25b">댓글내용</div>
            <div class="Kanit-Regular-25b">등록일</div>
          </div>
          <div class="div-item-list-area">
            <!-- 1 track -->
            <div class="div-track">
              <div class="div-board-cate-area">
                <div class="div-board-cate Inika-bold-18">스타일</div>
              </div>
              <div class="div-board-title-area">
                <div class="div-board-title Inika-Regular-16-l2">Stone Island 40723 Garment Dyed Crinkle Reps Recycled Nylon Hooded Down Jacket Black - 23FW</div>
              </div>
              <div class="div-reply-content-area">
                <div class="div-reply-content Inika-Regular-20">혹시 이 제품 에누리 가능할까요??.......</div>
              </div>
              <div class="div-board-date-area">
                <div class="div-board-date Inika-Regular-20">2023.05.10</div>
              </div>
            </div>
            <!-- track 끝 -->
            <!-- 2 track -->
            <div class="div-track">
              <div class="div-board-cate-area">
                <div class="div-board-cate Inika-bold-18">트렌드</div>
              </div>
              <div class="div-board-title-area">
                <div class="div-board-title Inika-Regular-16-l2">Stone Island 40723 Garment Dyed Crinkle Reps Recycled Nylon Hooded Down Jacket Black - 23FW</div>
              </div>
              <div class="div-reply-content-area">
                <div class="div-reply-content Inika-Regular-20">혹시 이 제품 에누리 가능할까요??.......</div>
              </div>
              <div class="div-board-date-area">
                <div class="div-board-date Inika-Regular-20">2023.05.10</div>
              </div>
            </div>
            <!-- track 끝 -->
            <!-- 3 track -->
            <div class="div-track">
              <div class="div-board-cate-area">
                <div class="div-board-cate Inika-bold-18">리퀘스트</div>
              </div>
              <div class="div-board-title-area">
                <div class="div-board-title Inika-Regular-16-l2">Stone Island 40723 Garment Dyed Crinkle Reps Recycled Nylon Hooded Down Jacket Black - 23FW</div>
              </div>
              <div class="div-reply-content-area">
                <div class="div-reply-content Inika-Regular-20">혹시 이 제품 에누리 가능할까요??.......</div>
              </div>
              <div class="div-board-date-area">
                <div class="div-board-date Inika-Regular-20">2023.05.10</div>
              </div>
            </div>
            <!-- track 끝 -->
            <!-- 2 track -->
            <div class="div-track">
              <div class="div-board-cate-area">
                <div class="div-board-cate Inika-bold-18">트렌드</div>
              </div>
              <div class="div-board-title-area">
                <div class="div-board-title Inika-Regular-16-l2">Stone Island 40723 Garment Dyed Crinkle Reps Recycled Nylon Hooded Down Jacket Black - 23FW</div>
              </div>
              <div class="div-reply-content-area">
                <div class="div-reply-content Inika-Regular-20">혹시 이 제품 에누리 가능할까요??.......</div>
              </div>
              <div class="div-board-date-area">
                <div class="div-board-date Inika-Regular-20">2023.05.10</div>
              </div>
            </div>
            <!-- track 끝 -->
            <!-- 3 track -->
            <div class="div-track">
              <div class="div-board-cate-area">
                <div class="div-board-cate Inika-bold-18">리퀘스트</div>
              </div>
              <div class="div-board-title-area">
                <div class="div-board-title Inika-Regular-16-l2">Stone Island 40723 Garment Dyed Crinkle Reps Recycled Nylon Hooded Down Jacket Black - 23FW</div>
              </div>
              <div class="div-reply-content-area">
                <div class="div-reply-content Inika-Regular-20">혹시 이 제품 에누리 가능할까요??.......</div>
              </div>
              <div class="div-board-date-area">
                <div class="div-board-date Inika-Regular-20">2023.05.10</div>
              </div>
            </div>
            <!-- track 끝 -->
            <!-- 2 track -->
            <div class="div-track">
              <div class="div-board-cate-area">
                <div class="div-board-cate Inika-bold-18">트렌드</div>
              </div>
              <div class="div-board-title-area">
                <div class="div-board-title Inika-Regular-16-l2">Stone Island 40723 Garment Dyed Crinkle Reps Recycled Nylon Hooded Down Jacket Black - 23FW</div>
              </div>
              <div class="div-reply-content-area">
                <div class="div-reply-content Inika-Regular-20">혹시 이 제품 에누리 가능할까요??.......</div>
              </div>
              <div class="div-board-date-area">
                <div class="div-board-date Inika-Regular-20">2023.05.10</div>
              </div>
            </div>
            <!-- track 끝 -->
            <!-- 3 track -->
            <div class="div-track">
              <div class="div-board-cate-area">
                <div class="div-board-cate Inika-bold-18">리퀘스트</div>
              </div>
              <div class="div-board-title-area">
                <div class="div-board-title Inika-Regular-16-l2">Stone Island 40723 Garment Dyed Crinkle Reps Recycled Nylon Hooded Down Jacket Black - 23FW</div>
              </div>
              <div class="div-reply-content-area">
                <div class="div-reply-content Inika-Regular-20">혹시 이 제품 에누리 가능할까요??.......</div>
              </div>
              <div class="div-board-date-area">
                <div class="div-board-date Inika-Regular-20">2023.05.10</div>
              </div>
            </div>
            <!-- track 끝 -->
            <!-- 2 track -->
            <div class="div-track">
              <div class="div-board-cate-area">
                <div class="div-board-cate Inika-bold-18">트렌드</div>
              </div>
              <div class="div-board-title-area">
                <div class="div-board-title Inika-Regular-16-l2">Stone Island 40723 Garment Dyed Crinkle Reps Recycled Nylon Hooded Down Jacket Black - 23FW</div>
              </div>
              <div class="div-reply-content-area">
                <div class="div-reply-content Inika-Regular-20">혹시 이 제품 에누리 가능할까요??.......</div>
              </div>
              <div class="div-board-date-area">
                <div class="div-board-date Inika-Regular-20">2023.05.10</div>
              </div>
            </div>
            <!-- track 끝 -->
            <!-- 3 track -->
            <div class="div-track">
              <div class="div-board-cate-area">
                <div class="div-board-cate Inika-bold-18">리퀘스트</div>
              </div>
              <div class="div-board-title-area">
                <div class="div-board-title Inika-Regular-16-l2">Stone Island 40723 Garment Dyed Crinkle Reps Recycled Nylon Hooded Down Jacket Black - 23FW</div>
              </div>
              <div class="div-reply-content-area">
                <div class="div-reply-content Inika-Regular-20">혹시 이 제품 에누리 가능할까요??.......</div>
              </div>
              <div class="div-board-date-area">
                <div class="div-board-date Inika-Regular-20">2023.05.10</div>
              </div>
            </div>
            <!-- track 끝 -->
            <!-- 2 track -->
            <div class="div-track">
              <div class="div-board-cate-area">
                <div class="div-board-cate Inika-bold-18">트렌드</div>
              </div>
              <div class="div-board-title-area">
                <div class="div-board-title Inika-Regular-16-l2">Stone Island 40723 Garment Dyed Crinkle Reps Recycled Nylon Hooded Down Jacket Black - 23FW</div>
              </div>
              <div class="div-reply-content-area">
                <div class="div-reply-content Inika-Regular-20">혹시 이 제품 에누리 가능할까요??.......</div>
              </div>
              <div class="div-board-date-area">
                <div class="div-board-date Inika-Regular-20">2023.05.10</div>
              </div>
            </div>
            <!-- track 끝 -->
            <!-- 3 track -->
            <div class="div-track">
              <div class="div-board-cate-area">
                <div class="div-board-cate Inika-bold-18">리퀘스트</div>
              </div>
              <div class="div-board-title-area">
                <div class="div-board-title Inika-Regular-16-l2">Stone Island 40723 Garment Dyed Crinkle Reps Recycled Nylon Hooded Down Jacket Black - 23FW</div>
              </div>
              <div class="div-reply-content-area">
                <div class="div-reply-content Inika-Regular-20">혹시 이 제품 에누리 가능할까요??.......</div>
              </div>
              <div class="div-board-date-area">
                <div class="div-board-date Inika-Regular-20">2023.05.10</div>
              </div>
            </div>
            <!-- track 끝 -->
            <div class="div-blank-45"></div>
            <input type="button" value="더보기" class="btn-more-data Inika-bold-20w">
          </div>

          
        </div> <!-- mypage main 끝  -->
      </div><!-- container -->
    </main>
<script src="/mingle/js/layout_resize.js"></script>
<script src="/mingle/js/mypage/myreply.js"></script>
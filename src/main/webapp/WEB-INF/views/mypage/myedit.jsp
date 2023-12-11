<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link rel="stylesheet" href="/mingle/css/mypage/mypage_init.css">
<link rel="stylesheet" href="/mingle/css/mypage/mypage_edit.css">

<main>
	<div class="container">
		<!-- side 메뉴 -->
		<%@ include file="myaside.jspf"%>
		<!-- mypage main -->
		<div class="div-mypage-main">
			<div class="Kanit-SemiBold-28">회원정보수정</div>
			<!-- 경계선 굵은것 -->
			<div class="div-underline-bold"></div>
			<div class="div-edit-area">
				<c:if test="${empty userVO.user_img }">
					<img id="img-profile" src="/mingle/img/user/profileEX.png" alt="">
				</c:if>
				<c:if test="${!empty userVO.user_img  }">
					<img id="img-profile" src="${userVO.user_img}">
				</c:if>
				

				<div class="div-profile-area">

					<!-- 상단 닉네임 -->
					<c:if test="${empty userVO.user_nick }">
						<div class="div-my-nickname Inika-bold-25">등록하신 닉네임이 없습니다.</div>
					</c:if>
					<c:if test="${!empty userVO.user_nick  }">
						<div class="div-my-nickname Inika-bold-25">${userVO.user_nick}</div>
					</c:if>
					<!-- 상단 이메일  -->
					<c:if test="${empty userVO.user_email }">
						<div class="div-my-email Inika-Regular-20">등록하신 이메일이 없습니다.</div>
					</c:if>
					<c:if test="${!empty userVO.user_email }">
						<div class="div-my-email Inika-Regular-20">${userVO.user_email }</div>
					</c:if>

					<div class="div-btn-area">
						<!-- 숨겨진 파일 선택기 -->
						<input type="file" id="file-selector" style="display: none;">
						<input id="btn-img-sel" type="button" value="이미지변경">
						<input id="btn-img-del" type="button" value="이미지삭제">
					</div>
				</div>
				<div class="user-out-area">
					<input type="button" class="user-out btn-userdata-common" value="회원탈퇴"> 
				</div>
			</div>
			<!-- 경계선 굵은것 앏은것-->
			<div class="div-underline-thin"></div>
			<div class="div-profile-edit-area">
				<div class="div-main-data-area">
					<!-- 아이디 -->
					<div class="Inika-Regular-16-af">아이디</div>
					<div class="div-userid-area div-underline-thin-data">
					
						<c:if test="${empty userVO.user_id ||  !empty userVO.user_Oauth }">
							<input readonly type="text" class="userid Inika-Regular-22 input-userdata-commom" placeholder="등록하신 아이디가 없습니다">
						</c:if>
						<c:if test="${empty userVO.user_Oauth}">
							<input readonly type="text" class="userid Inika-Regular-22 input-userdata-commom" value="${userVO.user_id}">
						</c:if>
						<!-- 변경 버튼 -->
						<c:if test="${empty userVO.user_Oauth }">
							<!-- <input id="btn-userid" type="button" class="btn-userdata-common" value="변경"> -->
						</c:if>
						<c:if test="${!empty userVO.user_Oauth }">
							<!-- <input id="btn-userid" type="button" class="btn-userdata-common" value="변경"> -->
						</c:if>
						
						
					</div>
					<!-- 비밀번호  암호화 되어 있어서 보여주기 불가능-->
					<div class="div-blank"></div>
					<div class="Inika-Regular-16-af">비밀번호</div>
					<div class="div-userid-area div-underline-thin-data">
						<input readonly type="text" class="userpw Inika-Regular-22 input-userdata-commom" placeholder="***************************">
						<!-- 변경 버튼 -->
						<c:if test="${empty userVO.user_Oauth }">
							<input id="btn-userpw" type="button" class="btn-userdata-common" value="변경">
						</c:if>
						<c:if test="${!empty userVO.user_Oauth }">
							
						</c:if>
						
					</div>
				</div>
				<div class="div-sub-data-area">
					<!-- 닉네임  -->
					<div class="Inika-Regular-16-af">닉네임</div>
					<div class="div-niick-area div-underline-thin-data">
						<c:if test="${empty userVO.user_nick }">
							<input readonly type="text" class="usernick Inika-Regular-22 input-userdata-commom" placeholder="등록하신 아이디가 없습니다">
						</c:if>
						<c:if test="${!empty userVO.user_nick }">
							<input readonly type="text" class="usernick Inika-Regular-22 input-userdata-commom" value="${userVO.user_nick}">
						</c:if>
						<!-- 변경 버튼 -->
						<input id="btn-usernick" type="button" class="btn-userdata-common" value="변경">
					</div>

					<!-- 전화번호 -->
					<div class="div-blank"></div>
					<div class="Inika-Regular-16-af">전화번호</div>
					<div class="div-tel-area div-underline-thin-data">
						<c:if test="${empty userVO.user_tel }">
							<input readonly type="text" class="usertel Inika-Regular-22 input-userdata-commom" placeholder="등록하신 번호가 없습니다">
						</c:if>
						<c:if test="${!empty userVO.user_tel }">
							<input readonly type="text" class="usertel Inika-Regular-22 input-userdata-commom" value="${userVO.user_tel}">
						</c:if>
						<!-- 변경 버튼 -->
						<input id="btn-usertel"type="button" class="btn-userdata-common" value="변경">
					</div>
					<!-- 주소 -->
					<div class="div-blank"></div>
					<div class="Inika-Regular-16-af">주소</div>
					<div class="div-addr-area div-underline-thin-data">
						<c:if test="${empty userVO.user_addr }">
							<input readonly type="text" class="useraddr Inika-Regular-22 input-userdata-commom" placeholder="등록하신 주소가 없습니다.">
						</c:if>
						<c:if test="${!empty userVO.user_addr }">
							<input readonly type="text" class="useraddr Inika-Regular-22 input-userdata-commom" value="${userVO.user_addr}">
						</c:if>
						<!-- 변경 버튼 -->
						<input  id="btn-useraddr" type="button" class="btn-userdata-common" value="변경">
					</div>
					<!-- 성별  -->
					<div class="div-blank"></div>
					<div class="Inika-Regular-16-af">성별</div>
					<!-- <div class="div-gen-area div-underline-thin-data"> -->
					<div class="div-gen-area">
						<!-- <input type="text" class="userpwd Inika-Regular-22 input-userdata-commom" value="김연아"> -->
						<div class="checkbox-wrapper-55">
						<!-- 성별  -->
							<label class="rocker rocker-small"> 
							<!-- 성별  -->
							<%-- <c:if test="{${empty userVO.user_gender } || ${userVO.user_gender==1 }"> --%>
							
							<c:if test="${ empty userVO.user_gender || userVO.user_gender==1 }">
								<input disabled class="usergen" type="checkbox" checked>
							</c:if>
							<c:if test="${userVO.user_gender==2 }">
								<input disabled class="usergen" type="checkbox">
							</c:if>						 
							<!-- <input disabled class="usergen" type="checkbox" checked> -->
								<!-- 성별  -->
								<span class="switch-left">남자</span> 
								<!-- 성별  -->
								<span class="switch-right">여성</span>
								<!-- 성별  -->
							</label>
						</div>
						<!-- 변경 버튼 -->
						<input id="btn-usergen" type="button" class="btn-userdata-common" style="margin-right: 7px" value="변경">
					</div>

				</div>
			</div>

		</div>
		<!-- mypage main 끝  -->
	</div>
	<!-- container -->
</main>
<script src="/mingle/js/layout_resize.js"></script>
<script src="/mingle/js/mypage/myedit.js"></script>
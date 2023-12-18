<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link rel="stylesheet" href="/mingle/css/resell/resell_write.css">
<link rel="stylesheet" href="/mingle/css/resell/ckeditor.css">
<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@1,700&display=swap&family=Nova+Square&display=swap&family=Abril+Fatface&display=swap&family=Bayon&display=swap&family=Grenze+Gotisch&display=swap&family=Fredericka+the+Great&display=swap&family=Racing+Sans+One&display=swap&family=Abril+Fatface&display=swap&family=Lilita+One&display=swap" rel="stylesheet" rel="stylesheet">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/39.0.1/super-build/ckeditor.js"></script>
<script src="/mingle/js/resell/ckeditor.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services"></script>
<script type="text/javascript" src="/mingle/js/resell/resell_write_map.js"></script>
<script>
//ck에디터
$(function() {
    //CKEDITOR
    CKEDITOR.ClassicEditor.create(document.getElementById("content"), option);
});
</script>
<div class="page">
	<form method="post" action="${pageContext.servletContext.contextPath}/resell/writeOk<c:if test='${not empty itemData.item_no}'>?no=${itemData.item_no}</c:if>" class="write_form" onsubmit="return validateForm()" enctype="multipart/form-data">
	<div id="writeForm_back">
		${itemData.item_no}
		<div id="writeForm_title">MIXING VARIOUS FASHIONS INTO ONE</div>
		<!-- 글 종류 선택 -->
		<div class="writeType_select">
			<div class="resell"><a href="/mingle/resell/write" class="writeType_link">RESELL</a></div>
			<div class="request"><a href="/mingle/style/request/write" class="writeType_link">REQUEST</a></div>
			<div class="style"><a href="/mingle/style/write" class="writeType_link">STYLE</a></div>
		</div>
		
		<!-- 제목 -->
		<div class="write_subject_wrapper">
			<div class="subjectText_write">TITLE</div>
			<div class="subjectBox_write">
				<input type="text" id="subject" name="resell_name" placeholder="제목을 입력하세요(일부 특수문자 제외 1000자 이내)"
					value="<c:if test='${not empty itemData.item_no}'>${boardData.resell_name}</c:if>">
			</div>
		</div>
		
		<!-- 부제목 -->
		<div class="write_subject_wrapper_2">
			<div class="subjectText_write_2">SUBTITLE</div>
			<div class="subjectBox_write_2">
				<input type="text" id="subTitle" name="item_name" placeholder="아이템 이름(부제목)을 입력하세요."
					value="<c:if test='${not empty itemData.item_no}'>${itemData.item_name}</c:if>">
			</div>
		</div>
		<div class="write_subject_wrapper_2">
			<div class="subjectText_write_2">PRICE</div>
			<div class="subjectBox_write_2">
				<input type="text" id="price" name="item_price" placeholder="가격(숫자만)을 입력하세요. ex) 2,500원 -> 2500"
					value="<c:if test='${not empty itemData.item_no}'>${itemData.item_price}</c:if>">
			</div>
		</div>
		
		<!-- 카테고리 -->
		<div class="category_area">
			<div class="radio_area">
				<div class="radioWrapper_area">
					<div class="radiogroup">
						<!-- 메인 카테고리 선택 하는부분 -->
						<c:forEach var="n" items="${main}" varStatus="n0">
							<div class="wrapper_radio">
								<input class="state" type="radio" name="item_category" id="${n}" value="${n0.index}"
									${n0.index == itemData.getItem_category() ? 'checked' : ''}>
								<label class="label" for="${n}">
									<div class="indicator"></div>
									<c:set var="upper" value="${fn:toUpperCase(n)}" />
									<span class="text">${upper}</span>
								</label>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="dropbox_area">
				<div class="button-55" id="dropbox_men">
					<select class="category_dropbox" id="selectbox_men" name="item_detail">
						<!-- 세부 카테고리 선택하는곳 -->
						<c:forEach var="category" items="${title}" varStatus="n1">
							<optgroup label="${category}">
								<c:forEach var="detail" items="${requestScope[category]}" varStatus="n2">
									<c:set var="numbering" value="${(n1.index+1)*100+n2.index}"/>
									
									<option value="${numbering}"
										${numbering == itemData.getItem_detail() ? 'selected' : ''}>${detail}(${numbering})</option>
								</c:forEach>
							</optgroup>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<!-- 내용 -->
		<div class="write_content_wrapper">
			<div class="contentText_write">CONTENT</div>
			<textarea name="resell_comment" id="content" placeholder="내용을 입력하세요(최소 30자 이상 입력해주세요.)">
				${boardData.getResell_comment()}
			</textarea>
		</div>
		<hr/>
		
		<!-- 제품 이미지 -->
		<div class="imgUpload_area">
			<div class="imgUpload_textArea">Image<br/>Upload</div>
			<div class="imgUpload_contArea upload">
				<input type="file" class="real-upload" name="filename" accept="image/*" required multiple>
				<ul class="image_preview">상단 노출 제품 관련 이미지를 선택해주세요.</ul>
			</div>
	  	</div>
	  	<script src="/mingle/js/resell/resell_write.js"></script><!-- 위에 적으면 에러남 -->
	  	<hr/>
	  	<!-- 판매희망주소 --><!-- api 적용시, 분리하면 에러남 -->
	  	<div class="sellAddr_area">
		  	<input type="button" onclick="searchAddr()" value="PLACE SELECT" class="addr_btn">
		  	<input type="text" class="addr_post" name="resell_addr" value="${boardData.getResell_addr()}">
		  	<div class="addr_box">${boardData.getResell_addr()}</div>
		  	<div id="map"></div>
	  	</div>
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=32c66affb1cc55e17a82c794a21905ab&libraries=services,clusterer,drawing"></script>
	  	<hr/>
		<!-- 작성,취소 버튼 -->
		<div class="pushBack_box">
		    <input type="submit" title="Button push blue/green" class="button btnPush btnBlueGreen" value="PUSH">
		    <input type="button" title="Button push lightblue" class="button btnPush btnLightBlue" value="BACK" onclick="history.back()">
	    	<div class="clear"></div>
		</div>
	</div>
	</form>	
</div>

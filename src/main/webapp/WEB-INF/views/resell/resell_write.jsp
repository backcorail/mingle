<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/mingle/css/resell/resell_write.css">
<link rel="stylesheet" href="/mingle/css/resell/ckeditor.css">
<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@1,700&display=swap&family=Nova+Square&display=swap&family=Abril+Fatface&display=swap&family=Bayon&display=swap&family=Grenze+Gotisch&display=swap&family=Fredericka+the+Great&display=swap&family=Racing+Sans+One&display=swap&family=Abril+Fatface&display=swap&family=Lilita+One&display=swap" rel="stylesheet" rel="stylesheet">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/39.0.1/super-build/ckeditor.js"></script>
<script src="/mingle/js/resell/ckeditor.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services"></script>
<script>
//ck에디터
$(function() {
    //CKEDITOR
    CKEDITOR.ClassicEditor.create(document.getElementById("content"), option);
});
</script>
<div class="page">
	<form method="post" action="${pageContext.servletContext.contextPath}/resell/writeOk" class="write_form" onsubmit="return validateForm()" enctype="multipart/form-data">
	<div id="writeForm_back">
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
				<input type="text" id="subject" name="resell_name" placeholder="제목을 입력하세요(일부 특수문자 제외 1000자 이내)">
			</div>
		</div>
		
		<!-- 부제목 -->
		<div class="write_subject_wrapper_2">
			<div class="subjectText_write_2">SUBTITLE</div>
			<div class="subjectBox_write_2">
				<input type="text" id="subTitle" name="item_name" placeholder="아이템 이름(부제목)을 입력하세요.">
			</div>
		</div>
		<div class="write_subject_wrapper_2">
			<div class="subjectText_write_2">PRICE</div>
			<div class="subjectBox_write_2">
				<input type="text" id="price" name="item_price" placeholder="가격(숫자만)을 입력하세요. ex) 2,500원 -> 2500">
			</div>
		</div>
		
		<!-- 카테고리 -->
		<div class="category_area">
			<div class="radio_area">
				<div class="radioWrapper_area">
					<div class="radiogroup">
					  <div class="wrapper_radio">
					    <input class="state" type="radio" name="item_category" id="all" value="0">
					    <label class="label" for="all">
					      <div class="indicator"></div>
					      <span class="text">ALL</span>
					    </label>
					  </div>
					  <div class="wrapper_radio">
					    <input class="state" type="radio" name="item_category" id="men" value="1">
					    <label class="label" for="men">
					      <div class="indicator"></div>
					      <span class="text">MEN</span>
					    </label>
					  </div>
					  <div class="wrapper_radio">
					    <input class="state" type="radio" name="item_category" id="women" value="2">
					    <label class="label" for="women">
					      <div class="indicator"></div>
					      <span class="text">WOMEN</span>
					    </label>
					  </div>
					  <div class="wrapper_radio">
					    <input class="state" type="radio" name="item_category" id="other" value="3">
					    <label class="label" for="other">
					      <div class="indicator"></div>
					      <span class="text">OTHER</span>
					    </label>
					  </div>
					</div>
				</div>
			</div>
			<div class="dropbox_area">
				<div class="button-55" id="dropbox_men">
					<select class="category_dropbox" id="selectbox_men" name="item_detail">
						<optgroup label="TOP">
							<option value="100">전체</option>
							<option value="101">맨투맨/스웨트</option>
							<option value="102">니트 스웨터</option>
							<option value="103">긴소매 티셔츠</option>
							<option value="104">카라 티셔츠</option>
							<option value="105">반소매 티셔츠</option>
							<option value="106">민소매 티셔츠</option>
							<option value="107">후드 티셔츠</option>
							<option value="108">스포츠 상의</option>
							<option value="109">셔츠/블라우스</option>
							<option value="110">기타 상의</option>
						</optgroup>
						<optgroup label="OUTER">
							<option value="200">전체</option>
							<option value="201">후드 집업</option>
							<option value="202">블루종</option>
							<option value="203">라이더재킷</option>
							<option value="204">트러커재킷</option>
							<option value="205">슈트/블레이저 재킷</option>
							<option value="206">무스탕/퍼</option>
							<option value="207">카디건</option>
							<option value="208">아노락</option>
							<option value="209">코트</option>
							<option value="210">패딩</option>
							<option value="211">나일론/코치 재킷</option>
							<option value="299">기타 아우터</option>
						</optgroup>
						<optgroup label="Bottom">
							<option value="300">전체</option>
							<option value="301">데님팬츠</option>
							<option value="302">코튼팬츠</option>
							<option value="303">슈트팬츠/슬랙스</option>
							<option value="304">트레이닝/조거팬츠</option>
							<option value="305">숏팬츠</option>
							<option value="306">스포츠 하의</option>
							<option value="399">기타 바지</option>
						</optgroup>
						<optgroup label="Shoes">
							<option value="400">전체</option>
							<option value="401">구두</option>
							<option value="402">부츠</option>
							<option value="403">힐/펌스스</option>
							<option value="404">운동화</option>
							<option value="405">슬리퍼</option>
							<option value="406">샌들</option>
							<option value="499">기타 신발</option>
						</optgroup>
						<optgroup label="Bag">
							<option value="500">전체</option>
							<option value="501">백팩</option>
							<option value="502">크로스백/메신저백</option>
							<option value="503">슬링백</option>
							<option value="504">핸드백</option>
							<option value="505">지갑</option>
							<option value="599">기타 가방</option>
						</optgroup>
					</select>
				</div>
			</div>
		</div>
		<!-- 내용 -->
		<div class="write_content_wrapper">
			<div class="contentText_write">CONTENT</div>
			<textarea name="resell_comment" id="content" placeholder="내용을 입력하세요(최소 30자 이상 입력해주세요.)"></textarea>
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
		  	<input type="text" id="sellPlace" style="display:none;" name="resell_addr">
		  	<div id="map" style="width:100%;height:350px;display:none;"></div>
	  	</div>
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=32c66affb1cc55e17a82c794a21905ab&libraries=services,clusterer,drawing"></script>
		<script type="text/javascript" src="/mingle/js/resell/resell_write_map.js"></script>
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

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/mingle/css/resell/resell_write.css">
<link rel="stylesheet" href="/mingle/css/resell/ckeditor.css">
<link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&display=swap&family=Bayon&display=swap&family=Grenze+Gotisch&display=swap&family=Fredericka+the+Great&display=swap&family=Racing+Sans+One&display=swap&family=Abril+Fatface&display=swap&family=Lilita+One&display=swap" rel="stylesheet" rel="stylesheet">
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
	<form method="post" action="/mingle/resell/writeOk" class="write_form" onsubmit="return validateForm()">
	<div id="writeForm_back">
		<div id="writeForm_title">MIXING VARIOUS FASHIONS INTO ONE</div>
		<!-- 글 종류 선택 -->
		<div class="writeType_select">
			<div class="resell"><a href="" class="writeType_link">RESELL</a></div>
			<div class="request"><a href="" class="writeType_link">REQUEST</a></div>
			<div class="style"><a href="" class="writeType_link">STYLE</a></div>
		</div>
		
		<!-- 제목 -->
		<div class="write_subject_wrapper">
			<div class="subjectText_write">TITLE</div>
			<div class="subjectBox_write">
				<input type="text" id="subject" name="subject" placeholder="제목을 입력하세요(일부 특수문자 제외 1000자 이내)">
			</div>
		</div>
		
		<!-- 부제목 -->
		<div class="write_subject_wrapper_2">
			<div class="subjectText_write_2">SUBTITLE</div>
			<div class="subjectBox_write_2">
				<input type="text" id="subTitle" name="subTitle" placeholder="부제목을 입력하세요(일부 특수문자 제외 1000자 이내)">
			</div>
		</div>
		
		<!-- 카테고리 -->
		<div class="category_area">
			<div class="checkbox_area">
				<div class="checkbox_text">해당되는 종류를 선택하세요.</div>
				<input type="checkbox" class="checkbox_btn">men
				<input type="checkbox" class="checkbox_btn">women
				<input type="checkbox" class="checkbox_btn">shoes
				<input type="checkbox" class="checkbox_btn">bag
				<input type="checkbox" class="checkbox_btn">other
			</div>
			<div class="dropbox_area">
				<div class="dropbox_text"></div>
				<select id="selectbox_men" name="category_men">
					<optgroup label="top">
						<option value="mtom">맨투맨/스웨트 셔츠</option>
						<option value="neat">니트/스웨터</option>
						<option value="hood">후드 티셔츠</option>
						<option value="longt">긴소매 티셔츠</option>
						<option value="polot">카라 티셔츠</option>
						<option value="tshirt">반소매 티셔츠</option>
						<option value="Sleeveless">민소매 티셔츠</option>
						<option value="sportsweart">스포츠 상의</option>
						<option value="shirt">셔츠</option>
					</optgroup>
					<optgroup label="bottom">
						<option value="denimpants">데님팬츠</option>
						<option value="cottonpants">코튼팬츠</option>
						<option value="slacks">슈트팬츠/슬랙스</option>
						<option value="joggerpants">트레이닝/조거팬츠</option>
						<option value="shortpants">숏팬츠</option>
						<option value="sportswearpants">스포츠 하의</option>
						<option value="otherpants">기타 바지</option>
						<option value="jumpsuit">점프슈트/오버올</option>
					</optgroup>
					<optgroup label="outer">
						<option value="hoodzipup">후드집업</option>
						<option value="blouson">블루종</option>
						<option value="riderjacket">라이더재킷</option>
						<option value="truckerjacket">트러커재킷</option>
						<option value="blazer">슈트/블레이저 재킷</option>
						<option value="mustang">무스탕/퍼</option>
						<option value="cardigan">카디건</option>
						<option value="anorak">아노락</option>
						<option value="coat">코트</option>
						<option value="padding">패딩</option>
						<option value="nylonjacket">나일론/코치 재킷</option>
					</optgroup>
				</select>
				<select id="selectbox_women" name="category_women">
					<optgroup label="top">
						<option value="mtom">맨투맨/스웨트 셔츠</option>
						<option value="neat">니트/스웨터</option>
						<option value="hood">후드 티셔츠</option>
						<option value="longt">긴소매 티셔츠</option>
						<option value="polot">카라 티셔츠</option>
						<option value="tshirt">반소매 티셔츠</option>
						<option value="Sleeveless">민소매 티셔츠</option>
						<option value="sportsweart">스포츠 상의</option>
						<option value="blouse">셔츠/블라우스</option>
					</optgroup>
					<optgroup label="bottom">
						<option value="denimpants">데님팬츠</option>
						<option value="cottonpants">코튼팬츠</option>
						<option value="slacks">슈트팬츠/슬랙스</option>
						<option value="joggerpants">트레이닝/조거팬츠</option>
						<option value="shortpants">숏팬츠</option>
						<option value="sportswearpants">스포츠 하의</option>
						<option value="otherpants">기타 바지</option>
						<option value="jumpsuit">점프슈트/오버올</option>
						<option value="leggings">레깅스</option>
						<option value="skirt">스커트</option>
						<option value="onepiece">원피스</option>
					</optgroup>
					<optgroup label="outer">
						<option value="hoodzipup">후드집업</option>
						<option value="blouson">블루종</option>
						<option value="riderjacket">라이더재킷</option>
						<option value="truckerjacket">트러커재킷</option>
						<option value="blazer">슈트/블레이저 재킷</option>
						<option value="mustang">무스탕/퍼</option>
						<option value="cardigan">카디건</option>
						<option value="anorak">아노락</option>
						<option value="coat">코트</option>
						<option value="padding">패딩</option>
						<option value="nylonjacket">나일론/코치 재킷</option>
					</optgroup>
				</select>
				<select id="selectbox_shoes" name="category_shoes">
					<optgroup label="shoes">
						<option value="shoe">구두</option>
						<option value="loafers">로퍼</option>
						<option value="heel">힐/펌프스</option>
						<option value="flatshoes">플랫슈즈</option>
						<option value="bloafer">블로퍼</option>
						<option value="sandal">샌들</option>
						<option value="slipper">슬리퍼</option>
						<option value="othershoes">기타신발</option>
						<option value="moccasin">모카신/보트슈즈</option>
					</optgroup>
					<optgroup label="sneakers">
						<option value="canvas">캔버스/단화</option>
						<option value="fashionsneakers">패션스니커즈화</option>
						<option value="sportssneakers">스포츠스니커즈</option>
						<option value="othersneakers">기타스니커즈</option>
					</optgroup>
					<optgroup label="supplies">
						<option value="supplies">신발용품</option>
					</optgroup>
				</select>
				<select id="selectbox_bag" name="category_bag">
					<optgroup label="bag">
						<option value="shoe">백팩</option>
						<option value="loafers">메신저/크로스백</option>
						<option value="heel">숄더백</option>
						<option value="flatshoes">토트백</option>
						<option value="bloafer">에코백</option>
						<option value="sandal">보스턴/드럼/더블백</option>
						<option value="slipper">웨이스트백</option>
						<option value="othershoes">파우치백</option>
						<option value="moccasin">브리프케이스</option>
						<option value="moccasin">캐리어</option>
						<option value="moccasin">가방 소품</option>
						<option value="moccasin">지갑/머니클립</option>
						<option value="moccasin">클러치백</option>
					</optgroup>
				</select>
				<select id="selectbox_other" name="category_other">
					<optgroup label="hat">
						<option value="cap">캡/야구모자</option>
						<option value="messengerbag">헌팅캡/베레모</option>
						<option value="shoulderbag">페도라</option>
						<option value="totebag">버킷/사파리햇</option>
						<option value="ecobag">비니</option>
						<option value="doublebag">트루퍼</option>
						<option value="waistbag">기타모자</option>
					</optgroup>
					<optgroup label="gloves">
						<option value="gloves">장갑</option>
					</optgroup>
					<optgroup label="muffler">
						<option value="muffler">목도리</option>
					</optgroup>
					<optgroup label="accessory">
						<option value="watch">손목시계</option>
						<option value="necklace">목걸이</option>
						<option value="ring">반지</option>
						<option value="bracelet">팔찌</option>
						<option value="anklet">발찌</option>
						<option value="mask">마스크</option>
					</optgroup>
				</select>
				
			</div>
		</div>
		
		<!-- 내용 -->
		<div class="write_content_wrapper">
			<div class="contentText_write">CONTENT</div>
			<textarea name="content" id="content" placeholder="내용을 입력하세요(최소 30자 이상 입력해주세요.)"></textarea>
		</div>
		<hr/>
		
		<!-- 제품 이미지 -->
		<div class="imgUpload_area">
			<div class="imgUpload_textArea">Image<br/>Upload</div>
			<div class="imgUpload_contArea upload">
				<input type="file" class="real-upload" accept="image/*" required multiple>
				<ul class="image_preview">상단 노출 제품 관련 이미지를 선택해주세요.</ul>
			</div>
	  	</div>
	  	<script src="/mingle/js/resell/resell_write.js"></script><!-- 위에 적으면 에러남 -->
	  	<hr/>
	  	<!-- 판매희망주소 --><!-- api 적용시, 분리하면 에러남 -->
	  	<div class="sellAddr_area">
		  	<input type="button" onclick="searchAddr()" value="PLACE SELECT" class="addr_btn">
		  	<div id="sellPlace" style="display:none;"></div>
		  	<div id="map" style="width:100%;height:350px;display:none;"></div>
	  	</div>
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=32c66affb1cc55e17a82c794a21905ab&libraries=services,clusterer,drawing"></script>
		<script type="text/javascript" src="/mingle/js/resell/resell_write_map.js"></script>
	  	<hr/>
		<!-- 작성,취소 버튼 -->
		<div class="pustBack_box">
		    <a href="" title="Button push blue/green" class="button btnPush btnBlueGreen">PUSH</a>
		    <a href="" title="Button push lightblue" class="button btnPush btnLightBlue">BACK</a>
	    <div class="clear"></div>
	  	</div>
	</div>
	</form>	
</div>
>>>>>>> refs/heads/kream_test

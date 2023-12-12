<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/mingle/css/resell/resell_write.css">
<link rel="stylesheet" href="/mingle/css/resell/ckeditor.css">
<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@1,700&display=swap&family=Nova+Square&display=swap&family=Abril+Fatface&display=swap&family=Bayon&display=swap&family=Fredericka+the+Great&display=swap&family=Racing+Sans+One&display=swap&family=Abril+Fatface&display=swap&family=Lilita+One&display=swap" rel="stylesheet" rel="stylesheet">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/39.0.1/super-build/ckeditor.js"></script>
<script src="/mingle/js/resell/ckeditor.js"></script>
<script src="/mingle/js/style/request_write.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services"></script>
<script>
//ck에디터
$(function() {
    //CKEDITOR
    CKEDITOR.ClassicEditor.create(document.getElementById("content"), option);
});
</script>
<div class="page">
	<form method="post" action="${pageContext.servletContext.contextPath}/style/request/writeOk" class="write_form" onsubmit="return dataCheck()" enctype="multipart/form-data">
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
					<input type="text" id="subject" name="request_name" placeholder="제목을 입력하세요(일부 특수문자 제외 1000자 이내)">
				</div>
			</div>
			<!-- 요청, 질문 선택 -->
			<div class="write_select_wrapper">
				<div class="reqSelect_wrapper">
					<input class="select_radio" type="radio" name="request_type" id="request" value="1">
						<label class="req_label" for="request">
							<span class="req_text">요청</span>
					    </label>
				</div>
				<div class="reqSelect_wrapper">
					<input class="select_radio" type="radio" name="request_type" id="question" value="2">
						<label class="req_label" for="question">
							<span class="req_text">질문</span>
					    </label>
				</div>	
			</div>
			<!-- 내용 -->
			<div class="write_content_wrapper">
				<div class="contentText_write">CONTENT</div>
				<textarea name="request_comment" id="content" placeholder="내용을 입력하세요(최소 30자 이상 입력해주세요.)"></textarea>
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
			<!-- 작성,취소 버튼 -->
			<div class="pushBack_box">
			    <input type="submit" title="Button push blue/green" class="button btnPush btnBlueGreen" value="PUSH">
			    <input type="button" title="Button push lightblue" class="button btnPush btnLightBlue" value="BACK" onclick="history.back()">
		    	<div class="clear"></div>
			</div>
		</div>
	</form>	
</div>

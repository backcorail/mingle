<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main>
	<h2>STS4에서 스프링부트 실행하기</h2>
	<form>
		<label>보낼 데이터</label>
		<ul>
			<li><input type="text" id="hangle" value="한글전송"></li>
			<li><input type="text" id="susu" value="123456"></li>
			<li><input type="text" id="eng" value="mingle-test"></li>
		</ul>
	</form>
	<input type="button" id="btn-get" value="GET 전송">
	<input type="button" id="btn-post" value="POST 전송">
	<input type="button" id="btn-put" value="PUT 전송">
	<input type="button" id="btn-delete" value="DELETE 전송">
	<div id="div-response"></div>
	<img alt="" src="./img/cody/cody.jpg">
</main>
<script defer src="./js/request_test.js" ></script>
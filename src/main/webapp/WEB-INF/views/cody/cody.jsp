<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="/mingle/css/cody/assets/css/korea-map-font-v1.css">
<link rel="stylesheet" href="/mingle/css/cody/cody.css">
<form method="post"
	action="${pageContext.servletContext.contextPath}/cody_selectAlgorithm" id="cody_form"
	onsubmit="return validateForm()">
	<div class="background">
		<div id="mapSelect_title">현재 위치를 선택해주세요.</div>
		<div id="mapSelect_content">
			<ul class="korea-map-font-v1">
				<li class="강원">a</li>
				<li class="경기">b</li>
				<li class="경남">c</li>
				<li class="경북">d</li>
				<li class="광주">e</li>
				<li class="대구">f</li>
				<li class="대전">g</li>
				<li class="부산">h</li>
				<li class="서울">i</li>
				<li class="세종">j</li>
				<li class="울산">k</li>
				<li class="인천">l</li>
				<li class="전남">m</li>
				<li class="전북">n</li>
				<li class="제주">o</li>
				<li class="충남">p</li>
				<li class="충북">q</li>
			</ul>
			<div id="sb_container">
				<div id="selectBox">
					<div class="container">
						<!-- checkbox 라벨은 js코드로 추가 -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="background2" style="display: none">
		<!-- 상황 선택 checkbox -->
		<div id="copceptSelect_container">
			<fieldset class="checkbox-group">
				<legend class="checkbox-group-legend">오늘의 데일리 컨셉을 선택해주세요.</legend>
				<div class="checkbox">
					<label class="checkbox-wrapper"> <input type="radio"
						class="checkbox-input" name="concept" value="wedding"/> <span
						class="checkbox-tile"> <span class="checkbox-icon"></span>
							<span class="checkbox-label">Wedding</span>
					</span>
					</label>
				</div>
				<div class="checkbox">
					<label class="checkbox-wrapper"> <input type="radio"
						class="checkbox-input" name="concept" value="casual"/> <span
						class="checkbox-tile"> <span class="checkbox-label">Casual</span>
					</span>
					</label>
				</div>
				<div class="checkbox">
					<label class="checkbox-wrapper"> <input type="radio"
						class="checkbox-input" name="concept" value="street" /> <span
						class="checkbox-tile"> <span class="checkbox-label">Street</span>
					</span>
					</label>
				</div>
				<div class="checkbox">
					<label class="checkbox-wrapper"> <input type="radio"
						class="checkbox-input" name="concept" value="vintage"/> <span
						class="checkbox-tile"> <span class="checkbox-label">Vintage</span>
					</span>
					</label>
				</div>
				<div class="checkbox">
					<label class="checkbox-wrapper"> <input type="radio"
						class="checkbox-input" name="concept" value="maximalism"/> <span
						class="checkbox-tile"> <span class="checkbox-label">Maximalism</span>
					</span>
					</label>
				</div>
				<div class="checkbox">
					<label class="checkbox-wrapper"> <input type="radio"
						class="checkbox-input" name="concept" value="modern"/> <span
						class="checkbox-tile"> <span class="checkbox-label">Modern</span>
					</span>
					</label>
				</div>
				<div class="checkbox">
					<label class="checkbox-wrapper"> <input type="radio"
						class="checkbox-input" name="concept" value="feminine"/> <span
						class="checkbox-tile"> <span class="checkbox-label">Feminine</span>
					</span>
					</label>
				</div>
				<div class="checkbox">
					<label class="checkbox-wrapper"> <input type="radio"
						class="checkbox-input" name="concept" value="dandy"/> <span
						class="checkbox-tile"> <span class="checkbox-label">Dandy</span>
					</span>
					</label>
				</div>
			</fieldset>
		</div>
	</div>
	<div id="pageBtn">
		<div id="cody_prevBtn" style="pointer-events: none; opacity: 0.5;"
			onclick="btnClick(1)">&lt; PREV</div>
		<div id="cody_nextBtn" onclick="btnClick(2)">NEXT &gt;</div>
		<div id="cody_sendBtn" style="display: none;" onclick="btnClick(3)">SEND</div>
	</div>
</form>
<script src="/mingle/js/cody/cody.js"></script>
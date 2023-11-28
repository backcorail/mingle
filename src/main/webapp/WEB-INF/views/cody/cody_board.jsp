<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/mingle/css/cody_board.css">
<script>
	$(document).ready(function(){
	    var day_names= ["일","월","화","수","목","금","토"]
	    var date = new Date();
	    $("#dateName").text(day_names[date.getDay()]);
	    $("#date").text((date.getMonth()+1)+ "." +date.getDate());
	    var apiURI = "https://api.openweathermap.org/data/2.5/weather?q=Seoul,kr&appid=43e709e6a39f22a1a3734e13c7720b45";
	    $.ajax({
	        url: apiURI,
	        dataType: "json",
	        type: "GET",
	        async: "false",
	        success: function(resp) {
	            console.log(resp);
	            console.log("최고온도 : "+ (resp.main.temp_max - 273.15) );
	            console.log("최저온도 : "+ (resp.main.temp_min - 273.15) );
	            console.log("날씨 : "+ resp.weather[0].main );
	            console.log("구름  : "+ (resp.clouds.all) +"%" );     
	            
	            var temp_max = resp.main.temp_max - 273.15;
	            var temp_min = resp.main.temp_min - 273.15;
	            
	            const weatherIcon = resp.weather[0].icon;
	            const weatherIconAdrs = "http://openweathermap.org/img/wn/"+weatherIcon+"@2x.png";
	            
	            $("#weather_Icon").attr("src", weatherIconAdrs);
	            
	            $("#min_temperature").text(temp_min.toFixed(1));
	            $("#max_temperature").text(temp_max.toFixed(1));
	        }
	});
});
</script>

<div class="codyboard_background" style="background-image:url('/mingle/img/cody/day_sunny/background.png');">
	<div class="weather">
		<span>오늘의 날씨</span>
		<div class="today" id="today">
		<h1 id="dateName"></h1>
		<a id="date"></a><br>
		<img id="weather_Icon" style="width:50px;height:50px;"/><br>
		<a id="min_temperature" class="min_temperature"></a><a style="color:#D8D8D8">/</a><a id="max_temperature" class="max_temperature"></a><br>
		<a></a>
		</div>
	</div>
	<div class="codiTap">
		<h2 style="color:#FF1493; text-align:center;"><b>추천 코디</b></h2>
		<img class="codi" src="/mingle/img/cody/2.jpg"><br>
		
		<a>무난무난하고 깔끔한 데일리 켐퍼스룩</a>
		</div>
	<div class="cody_item">
		<div class="slide">
		<h1 class="category_h1">자켓</h1>
	      	<ul class="slide_list">
	      		<li class="rightBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
	        	<c:forEach var="n" begin="1" end="4">
					<li class="slide_item">
	        			<img src="/mingle/img/cody/jk.jpg">
	        		</li>
				</c:forEach>
	        	<li class="leftBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
	      </ul>
	   </div>
	   <div class="slide">
	   <h1 class="category_h1">맨투맨</h1>
	      	<ul class="slide_list">
	      		<li class="rightBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
	        	<c:forEach var="n" begin="1" end="4">
					<li class="slide_item">
	        			<img src="/mingle/img/cody/mtm.jpg">
	        		</li>
				</c:forEach>
	        	<li class="leftBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
	      </ul>
	   </div>
	   <div class="slide">
	   <h1 class="category_h1">데님팬츠</h1>
	      	<ul class="slide_list">
	      		<li class="rightBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
		        <c:forEach var="n" begin="1" end="4">
					<li class="slide_item">
	        			<img src="/mingle/img/cody/dp.jpg">
	        		</li>
				</c:forEach>
	        	<li class="leftBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
	      </ul>
	   </div>
	   <div class="slide">
	   <h1 class="category_h1">스니커즈</h1>
	      	<ul class="slide_list">
	      		<li class="rightBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
	        	<c:forEach var="n" begin="1" end="4">
					<li class="slide_item">
	        			<img src="/mingle/img/cody/snk.jpg">
	        		</li>
				</c:forEach>
	        	<li class="leftBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
	      </ul>
		</div>
	</div>
</div>
<input type="button" class="homeBtn" name="homeBtn" value="Main" onclick="location.href='/mingle'" >

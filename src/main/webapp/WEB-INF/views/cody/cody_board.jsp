<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.codiboard{
	width: 100%;
	height: 100%;
}
h4{color:#FF1493;}
.weather{
	position: absolute;
	left:15%;
	top: 200px;
	width: 100px;
	height: 200px;
	text-align:center;
}

.today{
	background-color: white;
	border-radius:10px;
}


.codiTap{
	position: absolute;
	left:23%;
	top: 80px;
	margin-top: 70px;
}

.codi{
	background-color: white;
	width: 400px;
	height: 500px;
	border-radius:10px;
}


/*슬라이드*/
.slide__item{
	background-color:white;
}

.slide{
	position: absolute;
	left:50%;
	top: 150px;
	width: 900px;
	height: 100px;
	
}
.slide2{
	position: absolute;
	left:50%;
	top: 150px;
	width: 900px;
	height: 100px;
	margin-top: 200px;
}
.slide3{
	position: absolute;
	left:50%;
	top: 150px;
	width: 900px;
	height: 100px;
	margin-top: 400px;
}
.slide4{
	position: absolute;
	left:50%;
	top: 150px;
	width: 900px;
	height: 100px;
	margin-top: 600px;
}

.slide_item{
	width:100px;
	height:100px;
	float:left;
	margin-right: 20px;
	background-color: white;
	border-radius:5px;
}

.category_h1{
	font-size:15px; 
	color:#FF1493;
	margin-left: 45px;
}

.item_image{
	width:100px;
	height:100px;
	border-radius:5px;
}

.rightBtn{
	float:left;	
    margin-top: 37px;
    margin-right: 20px;
}

.leftBtn{
	float:left;	
    margin-top: 37px;
}

</style>
<script>



</script>



</head>
<body>
	<div class="codiboard" style="background-image:url('/mingle/img/cody/day_sunny/background.png');width: 1200px%; height: 100%">
		<div class="weather">
			<div style="font-size:15px; color:#FF1493;">오늘의 날씨</div>
			<div class="today", id="today">
			<h1>수</h1>
			<a>11.08</a><br>
			<img src="/mingle/img/cody/day_sunny/icon_sunny.png" style="width:50px;height:50px;"/>
			
			</div>
		</div>
		<div class="codiTap">
			<h2 style="color:#FF1493; text-align:center;"><b>추천 코디</b></h2>
			<img class="codi" src="/mingle/img/cody/2.jpg" style="width: 400px; height: 500px;">
			
			<h4 style="text-align:center;">무난무난하고 깔끔한 데일리 켐퍼스룩</h4>
			</div>
		</div>
			<div class="slide">
			<h1 class="category_h1">자켓</h1>
		      	<ul class="slide_list">
		      		<li class="rightBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
		        	<li class="slide_item">
		        	<img class="item_image" src="/mingle/img/cody/cody.jpg">
		        	</li>
		        	<li class="slide_item">
		          	<img class="item_image" src="/mingle/img/cody/cody.jpg">
			        </li>
			        <li class="slide_item">
					<img class="item_image" src="/mingle/img/cody/cody.jpg">
			        </li>
			        <li class="slide_item">
			        <img class="item_image" src="/mingle/img/cody/cody.jpg">
			        </li>
			        <li class="slide_item">
		         	<img class="item_image" src="/mingle/img/cody/cody.jpg">
		        	</li>
		        	<li class="leftBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
		      </ul>
		   </div>
		   <div class="slide2">
		   <h1 class="category_h1">맨투맨</h1>
		      	<ul class="slide_list">
		      		<li class="rightBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
		        	<li class="slide_item">
		        	<img class="item_image" src="/mingle/img/cody/cody.jpg">
		        	</li>
		        	<li class="slide_item">
		          	<img class="item_image" src="/mingle/img/cody/cody.jpg">
			        </li>
			        <li class="slide_item">
					<img class="item_image" src="/mingle/img/cody/cody.jpg">
			        </li>
			        <li class="slide_item">
			        <img class="item_image" src="/mingle/img/cody/cody.jpg">
			        </li>
			        <li class="slide_item">
		         	<img class="item_image" src="/mingle/img/cody/cody.jpg">
		        	</li>
		        	<li class="leftBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
		      </ul>
		   </div>
		   <div class="slide3">
		   <h1 class="category_h1">데님팬츠</h1>
		      	<ul class="slide_list">
		      		<li class="rightBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
		        	<li class="slide_item">
		        	<img class="item_image" src="/mingle/img/cody/cody.jpg">
		        	</li>
		        	<li class="slide_item">
		          	<img class="item_image" src="/mingle/img/cody/cody.jpg">
			        </li>
			        <li class="slide_item">
					<img class="item_image" src="/mingle/img/cody/cody.jpg">
			        </li>
			        <li class="slide_item">
			        <img class="item_image" src="/mingle/img/cody/cody.jpg">
			        </li>
			        <li class="slide_item">
		         	<img class="item_image" src="/mingle/img/cody/cody.jpg">
		        	</li>
		        	<li class="leftBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
		      </ul>
		   </div>
		   <div class="slide4">
		   <h1 class="category_h1">스니커즈</h1>
		      	<ul class="slide_list">
		      		<li class="rightBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
		        	<li class="slide_item">
		        	<img class="item_image" src="/mingle/img/cody/cody.jpg">
		        	</li>
		        	<li class="slide_item">
		          	<img class="item_image" src="/mingle/img/cody/cody.jpg">
			        </li>
			        <li class="slide_item">
					<img class="item_image" src="/mingle/img/cody/cody.jpg">
			        </li>
			        <li class="slide_item">
			        <img class="item_image" src="/mingle/img/cody/cody.jpg">
			        </li>
			        <li class="slide_item">
		         	<img class="item_image" src="/mingle/img/cody/cody.jpg">
		        	</li>
		        	<li class="leftBtn"><img src="/mingle/img/cody/day_sunny/icon_arrow.png" style="width:24px; height:24px;"></li>
		      </ul>
		   </div>
		   <div>
	</div>
	</div>
</body>
</html>
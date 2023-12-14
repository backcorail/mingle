const urlStr = window.location.href;
const url = new URL(urlStr);
const urlParams = url.searchParams;
const city = urlParams.get('city');
const situation = urlParams.get('situation');
var sit_num=0;
var tem=0;

if(situation=="exercise"){
	sit_num=0;
}else if(situation=="wedding"){
	sit_num=1;
}else if(situation=="business"){
	sit_num=2;
}else{
	sit_num=3;
}





var $item = 170;
var $count = $('.slide_item1').length;
var $count2 = $('.slide_item2').length;
var $count3 = $('.slide_item3').length;
var $count4 = $('.slide_item4').length;

console.log($count);
console.log($count2);
console.log($count3);
console.log($count4);

var $slidebox = $item*$count;
var $slidebox2 = $item*$count2;
var $slidebox3 = $item*$count3;
var $slidebox4 = $item*$count4;
var count1 = 0;
var count2 = 0;
var count3 = 0;
var count4 = 0;

function moveSlider(){
	var check = $(this).attr('data-btn');
	if(check==0&& count1>0){
		count1 -= 1;
		$('.slide_list1').animate({left : '+='+$item+'px'},300,slideEnd)
	}else if(check == 1&&count1<($count-4)){
		count1 += 1;
		$('.slide_list1').animate({left : '-='+$item+'px'},300,slideEnd)
	}
}

function moveSlider2(){
	var check = $(this).attr('data-btn');
	if(check==0&& count2>0){
		count2 -= 1;
		$('.slide_list2').animate({left : '+='+$item+'px'},300,slideEnd2)
	}else if(check == 1&&count2<($count2-4)){
		count2 += 1;
		$('.slide_list2').animate({left : '-='+$item+'px'},300,slideEnd2)
	}
}
function moveSlider3(){
	var check = $(this).attr('data-btn');
	if(check==0&& count3>0){
		count3 -= 1;
		$('.slide_list3').animate({left : '+='+$item+'px'},300,slideEnd3)
	}else if(check == 1&&count3<($count3-4)){
		count3 += 1;
		$('.slide_list3').animate({left : '-='+$item+'px'},300,slideEnd3)
	}
}
function moveSlider4(){
	var check = $(this).attr('data-btn');
	if(check==0&& count4>0){
		count4 -= 1;
		$('.slide_list4').animate({left : '+='+$item+'px'},300,slideEnd4)
	}else if(check == 1&&count4<($count4-4)){
		count4 += 1;
		$('.slide_list4').animate({left : '-='+$item+'px'},300,slideEnd4)
	}
}


function slideEnd(){
	var nowLeft = $('.slide_list1').position().right;
	var end = -($slidebox-710);
	
	if(nowLeft<=end){
		$('.slide_list1').animate({right : end});
	}else if(nowLeft>0){
		$('.slide_list1').animate({right : 0});
	}
}

function slideEnd(){
	var nowLeft = $('.slide_list1').position().right;
	var end = -($slidebox2-710);
	
	if(nowLeft<=end){
		$('.slide_list1').animate({right : end});
	}else if(nowLeft>0){
		$('.slide_list1').animate({right : 0});
	}
}
function slideEnd2(){
	var nowLeft = $('.slide_list1').position().right;
	var end = -($slidebox3-710);
	
	if(nowLeft<=end){
		$('.slide_list1').animate({right : end});
	}else if(nowLeft>0){
		$('.slide_list1').animate({right : 0});
	}
}
function slideEnd3(){
	var nowLeft = $('.slide_list1').position().right;
	var end = -($slidebox4-710);
	
	if(nowLeft<=end){
		$('.slide_list1').animate({right : end});
	}else if(nowLeft>0){
		$('.slide_list1').animate({right : 0});
	}
}


window.onload=function(){
	setTimeout(function(){
		scrollTo(0,0);
	}, 100);
}


var prevScollpos = 0;
window.onscroll = headerLogoToggle
function headerLogoToggle(){
	var headerLogo = document.getElementById("header_logo");
	
	var currentScrollPos = window.pageYOffset;
	if(prevScollpos < currentScrollPos){
		headerLogo.style.opacity = 0.1;
	}else {
		headerLogo.style.opacity = 1;
	}
}







$(document).ready(function(){
		$('.slide_list1').css('width',$slidebox);
		$('.slide_list2').css('width',$slidebox2);
		$('.slide_list3').css('width',$slidebox3);
		$('.slide_list4').css('width',$slidebox4);
		
		$('.leftBtn1').on('click',moveSlider);
		$('.rightBtn1').on('click',moveSlider);
		$('.leftBtn2').on('click',moveSlider2);
		$('.rightBtn2').on('click',moveSlider2);
		$('.leftBtn3').on('click',moveSlider3);
		$('.rightBtn3').on('click',moveSlider3);
		$('.leftBtn4').on('click',moveSlider4);
		$('.rightBtn4').on('click',moveSlider4);
		
	    var day_names= ["일","월","화","수","목","금","토"]
	    var date = new Date();
	    $("#dateName").text(day_names[date.getDay()]);
	    $("#date").text((date.getMonth()+1)+ "." +date.getDate());
		
	    
	    var apiURI = "https://api.openweathermap.org/data/2.5/weather?q=" + city + ",kr&appid=43e709e6a39f22a1a3734e13c7720b45";
	    $.ajax({
	        url: apiURI,
	        dataType: "json",
	        type: "GET",
	        async: "false",
	        success: function(resp) {
	            /*console.log(resp);
	            console.log("최고온도 : "+ (resp.main.temp_max - 273.15) );
	            console.log("최저온도 : "+ (resp.main.temp_min - 273.15) );
	            console.log("날씨 : "+ resp.weather[0].main );
	            console.log("구름  : "+ (resp.clouds.all) +"%" );     
	            console.log("아이콘 번호"+resp.weather[0].icon);*/
	            tem = (resp.main.temp_max - 273.15 + resp.main.temp_min - 273.15)/2;
	            console.log(tem);
	            
	            
	            
	            $("#headerDiv").attr("style","background : none;");
	            
	            
			   	var temp_max = resp.main.temp_max - 273.15;
	            var temp_min = resp.main.temp_min - 273.15;
	            
	            const weatherIcon = "13d";
	            const weatherIconAdrs = "http://openweathermap.org/img/wn/"+weatherIcon+"@2x.png";
	            
	            $("#weather_Icon").attr("src", weatherIconAdrs);
	            
	            $("#min_temperature").text(temp_min.toFixed(1)+"°");
	            $("#max_temperature").text(temp_max.toFixed(1)+"°");
	            
	            if(weatherIcon=="01d"||weatherIcon=="02d"||weatherIcon=="50d"){
					$("#codyboard_background").attr("style", "background-image:url('/mingle/img/cody/day_sunny/background.png');");
					$("#codyboard_background").css("color", "#FF1493");
					$(".BtnImg").attr("src","/mingle/img/cody/day_sunny/icon_arrow.png")
					$(".codi").attr("style","box-shadow: 5px 5px 5px grey;");
					$(".homeBtn").css("color", "#FF1493");
					$("#header_logo, #btn_login").attr("style", "color:#FAB0B0");
					
				}else if(weatherIcon=="13d"){
					$("#codyboard_background").attr("style", "background-image:url('/mingle/img/cody/day_snow/snow.jpg');");
					$("#codyboard_background").css("color", "#FECB02");
					$(".BtnImg").attr("src","/mingle/img/cody/day_snow/icon_arrow.png");
					$(".homeBtn").css("color", "#FECB02");
					$("#header_logo, #btn_login").attr("style", "color:#FECB02");
				}else{
					$("#codyboard_background").attr("style", "background-image:url('/mingle/img/cody/day_rainny/rainny.png');");
					$("#codyboard_background").css("color", "black");
					$(".BtnImg").attr("src","/mingle/img/cody/day_rainny/icon_arrow.png");
					$(".codi").attr("style","box-shadow: 5px 5px 5px grey;");
					$("#header_logo, #btn_login").attr("style", "color:black");
				}
			}
			
	});
	console.log(tem)
});


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
	            /*console.log(resp);
	            console.log("최고온도 : "+ (resp.main.temp_max - 273.15) );
	            console.log("최저온도 : "+ (resp.main.temp_min - 273.15) );
	            console.log("날씨 : "+ resp.weather[0].main );
	            console.log("구름  : "+ (resp.clouds.all) +"%" );     
	            console.log("아이콘 번호"+resp.weather[0].icon);*/
	            $("#headerDiv").attr("style","background : none;");
	            
	            
			   	var temp_max = resp.main.temp_max - 273.15;
	            var temp_min = resp.main.temp_min - 273.15;
	            
	            const weatherIcon = "01d";
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
					$(".BtnImg").attr("src","/mingle/img/cody/day_rainny/icon_arrow.png");
					$(".codi").attr("style","box-shadow: 5px 5px 5px grey;");
					$("#header_logo, #btn_login").attr("style", "color:black");
				}
	        }
	});
});